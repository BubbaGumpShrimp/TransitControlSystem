package TrackControlModule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

public class TrackController {
	private int trackControllerID;
	private TrackControlComm comm;
	private Hashtable<Integer, Block> blocks;
	private ArrayList<Block> blockList;
	private ArrayList<Route> routes;
	private ArrayList<Train> trains;
	
	private final int signalChange = 1;
	private final int crossingChange = 2;
	private final int switchChange = 3;
	
	public TrackController(int trackControllerID) {
		this.trackControllerID = trackControllerID;
		comm = new TrackControlComm(this);
		blocks = new Hashtable<Integer, Block>();
		routes = new ArrayList<Route>();
		blockList = new ArrayList<Block>();
	}
	
	public void addBlock(int blockNumber, int speedLimit, int switch1, int switch2, int crossing, int overlap) {
		blocks.put(blockNumber, new Block(blockNumber, speedLimit, false, intToBool(overlap), crossing, switch1, switch2));
		blockList.add(blocks.get(blockNumber));
	}
	
	private boolean intToBool(int i) {
		return i != 0;
	}
	
	public int getTrackControllerID() {
		return trackControllerID;
	}
	
	public TrackControlComm getComm() {
		return comm;
	}

	public Block getBlock(int blockID) {
		return blocks.get(blockID);
	}
	
	public void addRoutes(ArrayList<Route> routes) {
		routes.addAll(routes);
	}
	
	public Route getRoute(int routeNumber) {
		return routes.get(routeNumber);
	}
	
	public void removeRoute(Route route) {
		routes.remove(route);
	}
	
	public void addTrain(Train t) {
		trains.add(t);
	}
	
	public Train getTrain(int blockNumber) {
		for (Train t: trains) {
			if (t.getBlockLocated() == blockNumber) {
				return t;
			}
		}
		return null;
	}
	
	public void runPLC() {
		//ArrayList<BlockChanges> changes = PLCProgram.getPLCAction(this);
		//implementChanges(changes);
		ArrayList<BlockChanges> firstChanges = PLCProgram.getPLCAction(this);
		ArrayList<BlockChanges> secondChanges = PLCProgram.getPLCAction(this);
		ArrayList<BlockChanges> thirdChanges = PLCProgram.getPLCAction(this);
		if (firstChanges.equals(secondChanges) && secondChanges.equals(thirdChanges)) {
			System.out.println("PLC Passed Triple Redundancy Check");
			implementChanges(firstChanges);
		}
		else {
			System.out.println("PLC Failed Triple Redundancy Check");
		}
	}
	
	private void implementChanges(ArrayList<BlockChanges> blockChanges) {
		for (BlockChanges changes: blockChanges) {
			while (changes.anyChanges()) {
				int blockNumber = changes.getBlockNumber();
				int change = changes.getChange();
				switch (change) {
					case signalChange:
						this.getBlock(blockNumber).toggleSignal();
					case crossingChange:
						this.getBlock(blockNumber).toggleCrossing();
					case switchChange:
						this.getBlock(blockNumber).toggleSwitch();
				}
			}
		}
	}
	
//	public void printStatus() {
//		System.out.format("Block#   Occupied   Signal   Crossing%n");
//		for (int key: blocks.keySet()) {
//			Block block = blocks.get(key);
//			System.out.format("%-9d%-11s%-9s",key,block.isOccupied(),block.isSignal());
//			if (block instanceof CrossingBlock) {
//				System.out.format("%s",((CrossingBlock)block).isCrossing());
//			}
//			System.out.format("%n");
//		}
//	}
	
	public ArrayList<Block> getAllBlocks() {
		ArrayList<Block> temp = new ArrayList<Block>();
		ArrayList<Integer> keys = new ArrayList<Integer>();
		keys.addAll(blocks.keySet());
		Collections.sort(keys);
		for (int key: keys) {
			temp.add(blocks.get(key));
		}
		return temp;
	}
	
	public String toString() {
		return "Controller #"+trackControllerID;
	}
	
	public ArrayList<Block> getBlockList() {
		return blockList;
	}
}

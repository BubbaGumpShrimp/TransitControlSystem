package TrackControlModule;

import java.util.ArrayList;
import java.util.Hashtable;

public class TrackController {
	private int trackControllerID;
	private TrackControlComm comm;
	private Hashtable<Integer, Block> blocks;
	private ArrayList<Block> blockList;
	private ArrayList<Route> routes;
	private ArrayList<Train> trainList;
	
	public TrackController(int trackControllerID) {
		this.trackControllerID = trackControllerID;
		comm = new TrackControlComm(this);
		blocks = new Hashtable<Integer, Block>();
		routes = new ArrayList<Route>();
		blockList = new ArrayList<Block>();
		trainList = new ArrayList<Train>();
	}
	
	//Adds a new block to this track controller
	public void addBlock(int blockNumber, int speedLimit, int switch1, int switch2, int crossing, int overlap) {
		blocks.put(blockNumber, new Block(blockNumber, speedLimit, false, intToBool(overlap), crossing, switch1, switch2));
		blockList.add(blocks.get(blockNumber));
	}
	
	//Internally used method to quicly convert an int to a boolean
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
	
	//Add a route provided by the CTC Office
	public void addRoutes(ArrayList<Route> routes) {
		routes.addAll(routes);
	}
	
	public Route getRoute(int routeNumber) {
		return routes.get(routeNumber);
	}
	
	public void removeRoute(Route route) {
		routes.remove(route);
	}
	
	//Add a train when it enters one of the blocks controlled by this controller
	public void addTrain(Train t) {
		trainList.add(t);
	}
	
	//Get the train on a certain block
	public Train getTrain(int blockNumber) {
		for (Train t: trainList) {
			if (t.getBlockLocated() == blockNumber) {
				return t;
			}
		}
		return null;
	}
	
	//Sends this controller to the PLC Program to perform the appropriate logic
	public void runPLC() {
		PLCProgram.getPLCAction(this);
	}
	
	//List version of blocks on this controller for the UI
	public ArrayList<Block> getBlockList() {
		return blockList;
	}
	
	//List version of trains on this controller for the UI
	public ArrayList<Train> getTrainList() {
		return trainList;
	}
	
	//Used by the PLC program to get a list of all occupied blocks under this controller
	public ArrayList<Integer> getOccupiedBlocks() {
		ArrayList<Integer> occupiedBlocks = new ArrayList<Integer>();
		for (Block b: blockList) {
			if (b.isOccupied()) {
				occupiedBlocks.add(b.getBlockID());
			}
		}
		return occupiedBlocks;
	}
	
	//Determines if a train was at this block during the last PLC calculation
	public boolean wasTrainHere(int blockNumber) {
		for (Train t: trainList) {
			if (t.getBlockLocated() == blockNumber) {
				return true;
			}
		}
		return false;
	}
}

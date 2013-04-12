package TrackControlModule;

import java.util.ArrayList;
import java.util.Hashtable;

public class TrackController {
	private int trackControllerID;
	private TrackControlComm comm;
	private Hashtable<Integer, Block> blocks;
	
	private final int signalChange = 1;
	private final int crossingChange = 2;
	
	public TrackController(int trackControllerID, ArrayList<Integer> blockNumbers, ArrayList<Boolean> isCrossing, ArrayList<Integer> switchState) {
		this.trackControllerID = trackControllerID;
		comm = new TrackControlComm(this);
		blocks = new Hashtable<Integer, Block>();
		for (int i=0; i<blockNumbers.size(); i++) {
			if (isCrossing.get(i) && switchState.get(i) != 0) {
				blocks.put(blockNumbers.get(i), new SwitchedCrossingBlock(blockNumbers.get(i), false, false, switchState.get(i)));
			}
			else if (switchState.get(i) != 0) {
				blocks.put(blockNumbers.get(i), new SwitchedBlock(blockNumbers.get(i), false, switchState.get(i)));
			}
			else if (isCrossing.get(i)) {
				blocks.put(blockNumbers.get(i), new CrossingBlock(blockNumbers.get(i), false, false));
			}
			else {
				blocks.put(blockNumbers.get(i), new Block(blockNumbers.get(i), false));
			}
		}
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
						if (this.getBlock(blockNumber) instanceof CrossingBlock) {
							((CrossingBlock)this.getBlock(blockNumber)).toggleCrossing();
						}
				}
			}
		}
	}
	
	public void printStatus() {
		System.out.format("Block#   Occupied   Signal   Crossing%n");
		for (int key: blocks.keySet()) {
			Block block = blocks.get(key);
			System.out.format("%-9d%-11s%-9s",key,block.isOccupied(),block.isSignal());
			if (block instanceof CrossingBlock) {
				System.out.format("%s",((CrossingBlock)block).isCrossing());
			}
			System.out.format("%n");
		}
	}
}

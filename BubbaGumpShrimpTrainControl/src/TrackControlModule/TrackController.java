package TrackControlModule;

import java.util.ArrayList;
import java.util.Hashtable;

public class TrackController {
	private int trackControllerID;
	private TrackControlComm comm;
	private Hashtable<Integer, Block> blocks;
	
	public TrackController(int trackControllerID, ArrayList<Integer> blockNumbers, ArrayList<Boolean> isCrossing, ArrayList<Integer> switchState) {
		this.trackControllerID = trackControllerID;
		comm = new TrackControlComm(this);
		for (int i=0; i<blockNumbers.size(); i++) {
			if (isCrossing.get(i) && switchState.get(i) != 0) {
				blocks.put(blockNumbers.get(i), new SwitchedCrossingBlock(blockNumbers.get(i), switchState.get(i)));
			}
			else if (switchState.get(i) != 0) {
				blocks.put(blockNumbers.get(i), new SwitchedBlock(blockNumbers.get(i), switchState.get(i)));
			}
			else if (isCrossing.get(i)) {
				blocks.put(blockNumbers.get(i), new CrossingBlock(blockNumbers.get(i)));
			}
			else {
				blocks.put(blockNumbers.get(i), new Block(blockNumbers.get(i)));
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
		PLCProgram.getPLCAction(this);
	}
}

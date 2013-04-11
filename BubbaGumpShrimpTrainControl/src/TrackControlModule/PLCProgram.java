package TrackControlModule;

import java.util.ArrayList;

public class PLCProgram {
	public static ArrayList<BlockChanges> getPLCAction(TrackController trackController) {
		//Logic for PLC written by engineer here with case statements for different controllers
		//Change Key: 1=toggle signal, 2=toggle crossing
		ArrayList<BlockChanges> blockChanges = new ArrayList<BlockChanges>();
		if (trackController.getBlock(1).isOccupied()) {
			CrossingBlock tempBlock1 = new CrossingBlock(1, false, true);
			BlockChanges changes = trackController.getBlock(1).changesNeeded(tempBlock1);
			if (changes.anyChanges()) {
				blockChanges.add(changes);
			}
			Block tempBlock2 = new Block(2, true);
			changes = trackController.getBlock(2).changesNeeded(tempBlock2);
			if (changes.anyChanges()) {
				blockChanges.add(changes);
			}
		}
		return blockChanges;
	}
}

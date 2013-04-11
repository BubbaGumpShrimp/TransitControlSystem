package TrackControlModule;

import java.util.ArrayList;

public class PrototypeDemo {
	public static void main(String[] args) {
		ArrayList<Integer> blockNumbers = new ArrayList<Integer>();
		blockNumbers.add(1);
		blockNumbers.add(2);
		ArrayList<Boolean> isCrossing = new ArrayList<Boolean>();
		isCrossing.add(true);
		isCrossing.add(false);
		ArrayList<Integer> switchState = new ArrayList<Integer>();
		switchState.add(0);
		switchState.add(0);
		TrackController prototype = new TrackController(1, blockNumbers, isCrossing, switchState);
		System.out.println("Initial empty two blocks of track");
		prototype.printStatus();
		System.out.println("\nTrain enters block #1");
		prototype.getBlock(1).setOccupied(true);
		prototype.printStatus();
		System.out.println("\nRun PLC Program");
		prototype.runPLC();
		prototype.printStatus();
	}
}

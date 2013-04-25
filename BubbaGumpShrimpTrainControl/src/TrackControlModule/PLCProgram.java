package TrackControlModule;

import java.util.ArrayList;

public class PLCProgram {
	public static void getPLCAction(TrackController trackController) {
		//Logic for PLC written by engineer here with case statements for different controllers
		//Incomplete due to time constraints
		
		switch (trackController.getTrackControllerID()) {
			
			//Track Controller #1
			case 1:
				for (int i: trackController.getOccupiedBlocks()) {
					//New Train to this controller
					if (i == 13) {
						if (!trackController.wasTrainHere(12)) {
							trackController.addTrain(new Train(0, 12, 0, 0, 13));
						}
					}
					
					//Authority
					if (i == 1) {
						if (trackController.getBlock(12).isOccupied()) {
							trackController.getTrain(i).setAuthorityIssued(0);
						}
						else {
							trackController.getTrain(i).setAuthorityIssued(1);
						}
					}
					else if (trackController.wasTrainHere(i+1)) {
						trackController.getTrain(i+1).setBlockLocated(i);
						if (trackController.getBlock(i-1).isOccupied()) {
							trackController.getTrain(i).setAuthorityIssued(0);
						}
						else {
							trackController.getTrain(i).setAuthorityIssued(1);
						}
					}
					
					//New train appeared where it didn't belong, indicates a broken circuit
					else {
						trackController.getBlock(i).setBroken(true);
					}
					
					//Switch Logic
					if (i == 12 && trackController.getTrain(i).getLastBlock() == 13 && trackController.getBlock(12).getSwitchState() == 1) {
						trackController.getBlock(12).toggleSwitch();
					}
					if (i == 1 && trackController.getBlock(12).getSwitchState() == 12) {
						trackController.getBlock(12).toggleSwitch();
					}
				}
				
			//Track Controller #2
			case 2:
				//Crossing Management
				if (trackController.getBlock(19).isOccupied() && !trackController.getBlock(19).isSignal()) {
					trackController.getBlock(19).toggleSignal();
				}
				else if (trackController.getBlock(19).isOccupied() && trackController.getBlock(19).isSignal()) {
					trackController.getBlock(19).toggleSignal();
				}
				
				//Authority
				for (int i: trackController.getOccupiedBlocks()) {
					//New Train to this controller
					if (i == 12 && !trackController.wasTrainHere(13)) {
						trackController.addTrain(new Train(0, 12, 0, 0, 11));
					}
					else if (i == 29 && !trackController.wasTrainHere(28)) {
						trackController.addTrain(new Train(0, 29, 0, 0, 30));
					}
					
					//Authority
					if (trackController.wasTrainHere(i+1)) {
						trackController.getTrain(i+1).setBlockLocated(i);
						if (trackController.getBlock(i-1).isOccupied()) {
							trackController.getTrain(i).setAuthorityIssued(0);
						}
						else {
							trackController.getTrain(i).setAuthorityIssued(1);
						}
					}
					else if (trackController.wasTrainHere(i-1)) {
						trackController.getTrain(i-1).setBlockLocated(i);
						if (trackController.getBlock(i+1).isOccupied()) {
							trackController.getTrain(i).setAuthorityIssued(0);
						}
						else {
							trackController.getTrain(i).setAuthorityIssued(1);
						}
					}
				}
			
			//Track Controller #3
			case 3:
				//New Train to this controller
				for (int i: trackController.getOccupiedBlocks()) {
					if (i == 28 && !trackController.wasTrainHere(30)) {
						trackController.addTrain(new Train(0, 28, 0, 0, 27));
					}
					else if (i == 149 && !trackController.wasTrainHere(150)) {
						trackController.addTrain(new Train(0, 149, 0, 0, 150));
					}
				}
				
			case 4:
				
				
			case 5:
				
				
			case 6:
				
				
			case 7:
				
				
			case 8:
				
				
			case 9:
				
				
			case 10:
				
				
			case 11:
				
				
		}
	}
}

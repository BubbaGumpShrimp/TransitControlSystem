package TrackControlModule;

public class Block {
	private boolean occupied;
	private boolean signal;
	private boolean broken;
	//Label for blocks that overlap to another controller just to see if a train is in an adjacent block
	private boolean monitorOnly;
	private int crossing;
	private String crossingString;
	private int switch1;
	private int switch2;
	private String switchString;
	private int blockID;
	private int speedLimit;
	
	public Block(int blockID, int speedLimit, boolean signal, boolean monitorOnly, int crossing, int switch1, int switch2) {
		occupied = false;
		this.signal = signal;
		broken = false;
		this.blockID = blockID;
		this.monitorOnly = monitorOnly;
		this.crossing = crossing;
		this.switch1 = switch1;
		this.switch2 = switch2;
		//Sets up string represenations for the UI
		if (crossing == 0) {
			crossingString = null;
		}
		else if (crossing == 1) {
			crossingString = "Off";
		}
		else {
			crossingString = "On";
		}
		if (switch1 == 0) {
			switchString = null;
		}
		else {
			switchString = Integer.toString(switch1);
		}
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void toggleOccupied() {
		occupied = !occupied;
	}

	public boolean isSignal() {
		return signal;
	}

	public void toggleSignal() {
		this.signal = !this.signal;
	}

	public boolean isBroken() {
		return broken;
	}

	public void setBroken(boolean broken) {
		this.broken = broken;
	}
	
	public int getBlockID() {
		return blockID;
	}
	
	public int getSpeedLimit() {
		return speedLimit;
	}
	
	public boolean isCrossing() {
		return crossing > 0;
	}
	
	public void toggleCrossing() {
		if (isCrossing()) {
			if (crossing == 1) {
				crossing++;
				crossingString = "On";
			}
			else {
				crossing--;
				crossingString = "Off";
			}
		}
	}
	
	public int getCrossing() {
		return crossing;
	}
	
	public String getCrossingString() {
		return crossingString;
	}
	
	public boolean isSwitch() {
		return switch1 > 0;
	}
	
	public void toggleSwitch() {
		int temp = switch1;
		switch1 = switch2;
		switch2 = temp;
		switchString = Integer.toString(switch1);
	}
	
	public int getSwitchState() {
		return switch1;
	}
	
	public String getSwitchString() {
		return switchString;
	}
}

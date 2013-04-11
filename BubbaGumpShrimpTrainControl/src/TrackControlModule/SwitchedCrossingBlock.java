package TrackControlModule;

public class SwitchedCrossingBlock extends Block {
	public int switchState;
	private boolean crossing;

	public SwitchedCrossingBlock(int blockID, boolean signal, boolean crossing, int switchState) {
		super(blockID, signal);
		this.switchState = switchState;
		this.crossing = crossing;
	}

	public int getSwitchState() {
		return switchState;
	}

	public void setSwitchState(int switchState) {
		this.switchState = switchState;
	}

	public boolean isCrossing() {
		return crossing;
	}

	public void setCrossing(boolean crossing) {
		this.crossing = crossing;
	}
}

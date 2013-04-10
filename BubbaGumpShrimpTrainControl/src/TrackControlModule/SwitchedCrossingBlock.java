package TrackControlModule;

public class SwitchedCrossingBlock extends Block {
	public int switchState;
	private boolean crossing;

	public SwitchedCrossingBlock(int switchState) {
		super();
		this.switchState = switchState;
		crossing = false;
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

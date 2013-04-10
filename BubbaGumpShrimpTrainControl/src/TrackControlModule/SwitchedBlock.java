package TrackControlModule;

public class SwitchedBlock extends Block {
	public int switchState;
	
	public SwitchedBlock(int switchState) {
		super();
		this.switchState = switchState;
	}

	public int getSwitchState() {
		return switchState;
	}

	public void setSwitchState(int switchState) {
		this.switchState = switchState;
	}
}

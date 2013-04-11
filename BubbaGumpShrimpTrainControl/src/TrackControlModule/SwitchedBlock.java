package TrackControlModule;

public class SwitchedBlock extends Block {
	public int switchState;
	
	public SwitchedBlock(int blockID, boolean signal, int switchState) {
		super(blockID, signal);
		this.switchState = switchState;
	}

	public int getSwitchState() {
		return switchState;
	}

	public void setSwitchState(int switchState) {
		this.switchState = switchState;
	}
}

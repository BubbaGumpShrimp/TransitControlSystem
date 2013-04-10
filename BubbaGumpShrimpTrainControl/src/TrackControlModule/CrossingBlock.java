package TrackControlModule;

public class CrossingBlock extends Block {
	private boolean crossing;
	
	public CrossingBlock() {
		super();
		crossing = false;
	}

	public boolean isCrossing() {
		return crossing;
	}

	public void setCrossing(boolean crossing) {
		this.crossing = crossing;
	}
}

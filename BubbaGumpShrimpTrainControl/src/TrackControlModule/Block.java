package TrackControlModule;

public class Block {
	private boolean occupied;
	private boolean signal;
	private boolean broken;
	
	public Block() {
		occupied = false;
		signal = false;
		broken = false;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public boolean isSignal() {
		return signal;
	}

	public void setSignal(boolean signal) {
		this.signal = signal;
	}

	public boolean isBroken() {
		return broken;
	}

	public void setBroken(boolean broken) {
		this.broken = broken;
	}
}

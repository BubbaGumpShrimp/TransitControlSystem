package TrackControlModule;

public class Block {
	private boolean occupied;
	private boolean signal;
	private boolean broken;
	private int blockID;
	
	private final int signalChange = 1;
	
	public Block(int blockID, boolean signal) {
		occupied = false;
		this.signal = signal;
		broken = false;
		this.blockID = blockID;
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
	
	public BlockChanges changesNeeded(Block otherBlock) {
		BlockChanges changes = new BlockChanges(this.getBlockID());
		if (this.isSignal() != otherBlock.isSignal()) {
			changes.addChange(signalChange);
		}
		if (changes.anyChanges()) {
			return changes;
		}
		return changes;
	}
}

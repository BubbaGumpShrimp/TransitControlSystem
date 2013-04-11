package TrackControlModule;

public class CrossingBlock extends Block {
	private boolean crossing;
	
	private final int crossingChange = 2;
	
	public CrossingBlock(int blockID, boolean signal, boolean crossing) {
		super(blockID, signal);
		this.crossing = crossing;
	}

	public boolean isCrossing() {
		return crossing;
	}

	public void toggleCrossing() {
		this.crossing = !this.crossing;
	}
	
	public BlockChanges changesNeeded(Block other) {
		if (!(other instanceof CrossingBlock)) {
			return super.changesNeeded(other);
		}
		CrossingBlock otherBlock = (CrossingBlock)other;
		BlockChanges changes = new BlockChanges(this.getBlockID());
		changes = super.changesNeeded(otherBlock);
		if (this.isCrossing() != otherBlock.isCrossing()) {
			changes.addChange(crossingChange);
		}
		return changes;
	}
}

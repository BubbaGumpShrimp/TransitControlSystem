package TrackControlModule;

import java.util.LinkedList;

public class BlockChanges {
	private int blockNumber;
	private LinkedList<Integer> changes;
	
	public BlockChanges(int blockNumber) {
		this.blockNumber = blockNumber;
		changes = new LinkedList<Integer>();
	}
	
	public void addChange(int change) {
		changes.add(change);
	}
	
	public int getChange() {
		return changes.remove();
	}
	
	public boolean anyChanges() {
		return changes.size() != 0;
	}
	
	public int getBlockNumber() {
		return blockNumber;
	}
	
	public String toString() {
		String s = "#"+blockNumber+": ";
		s += changes.toString();
		return s;
	}
}

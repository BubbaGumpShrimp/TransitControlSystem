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
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + blockNumber;
		result = prime * result + ((changes == null) ? 0 : changes.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BlockChanges other = (BlockChanges) obj;
		if (this.blockNumber != other.blockNumber)
			return false;
		if (this.changes == null) {
			if (other.changes != null)
				return false;
		} else if (!changes.equals(other.changes))
			return false;
		return true;
	}

	public String toString() {
		String s = "#"+blockNumber+": ";
		s += changes.toString();
		return s;
	}
}

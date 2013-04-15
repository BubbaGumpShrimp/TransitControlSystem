package TrackControlModule;

import java.util.ArrayList;
import java.util.Iterator;

public class Route implements Iterable<Integer> {
	private int trainNumber;
	private ArrayList<Integer> path;
	private boolean direction;
	
	public Route(int trainNumber, boolean direction) {
		this.trainNumber = trainNumber;
		this.direction = direction;
	}
	
	public void addBlock(int block) {
		path.add(block);
	}
	
	public int getTrainNumber() {
		return trainNumber;
	}
	
	public int getBlock(int position) {
		if (position < path.size()) {
			return path.get(position);
		}
		else {
			return -1;
		}
	}
	
	public void removeBlock(Integer block) {
		path.remove(block);
	}
	
	public boolean getDirection() {
		return direction;
	}
	
	public Iterator<Integer> iterator() {
		return path.iterator();
	}
}

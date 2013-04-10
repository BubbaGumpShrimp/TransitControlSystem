package TrackControlModule;

import java.util.ArrayList;
import Shared.Packet;

public class TrackControlPacket extends Packet {
	private boolean[] signals;
	private boolean[] crossings;
	private int[] switches;
	private boolean[] broken;
	private boolean[] occupied;
	private ArrayList<ArrayList<Integer>> routes;
	private int trackController;
	
	//id = Track Controller module number
	//intendedController = id number of specific track controller associated with data
	public TrackControlPacket(int senderID, int recipientID, boolean direction, int trackController) {
		super(senderID, recipientID, direction);
		this.trackController = trackController;
	}
	
	//Data to be sent from the Track Model to the Track Controller
	public void trackLoadData(boolean[] signals, boolean[] crossings, int[] switches, boolean[] broken, boolean[] occupied) {
		this.signals = signals;
		this.crossings = crossings;
		this.switches = switches;
		this.broken = broken;
		this.occupied = occupied;
	}
	
	//Data to be sent from the CTC Office to the Track Controller
	public void ctcLoadData(ArrayList<ArrayList<Integer>> routes) {
		this.routes = routes;
	}
	
	public int getTrackController() {
		return trackController;
	}

	public boolean[] getSignals() {
		return signals;
	}

	public boolean[] getCrossings() {
		return crossings;
	}

	public int[] getSwitches() {
		return switches;
	}

	public boolean[] getBroken() {
		return broken;
	}

	public boolean[] getOccupied() {
		return occupied;
	}

	public ArrayList<ArrayList<Integer>> getRoutes() {
		return routes;
	}
}

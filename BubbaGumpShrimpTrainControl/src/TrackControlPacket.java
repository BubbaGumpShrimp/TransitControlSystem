import java.util.ArrayList;

public class TrackControlPacket extends Packet {
	boolean[] signals;
	boolean[] crossings;
	int[] switches;
	boolean[] broken;
	boolean[] occupied;
	ArrayList<ArrayList<Integer>> routes;
	int controllerNumber;
	
	//id = Track Controller module number
	//intendedController = id number of specific track controller associated with data
	public TrackControlPacket(int id, int intendedController) {
		super(id);
		controllerNumber = intendedController;
	}
	
	//Data to be sent from the Track Model to the Track Controller
	public void trackLoadData(boolean[] sigs, boolean[] cros, int[] swit, boolean[] brok, boolean[] occu) {
		signals = sigs;
		crossings = cros;
		switches = swit;
		broken = brok;
		occupied = occu;
	}
	
	//Data to be sent from the CTC Office to the Track Controller
	public void ctcLoadData(ArrayList<ArrayList<Integer>> rout) {
		routes = rout;
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

	public int getControllerNumber() {
		return controllerNumber;
	}
}

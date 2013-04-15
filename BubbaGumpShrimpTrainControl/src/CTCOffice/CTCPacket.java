///Bubba Gump Shrimp Co.
///Packet Class for CTC Office
///Jabari Dawkins
///April 10, 2013

package CTCOffice;

import shared.Packet;
import java.util.ArrayList;


public class CTCPacket extends Packet{
	private ArrayList<Integer> occupiedBlocks;
	private ArrayList<Integer> throughput;
	private boolean flag;
	
	//recipientID = CTC Office Module Number
	public CTCPacket(int senderID, int recipientID, boolean direction){
		super(senderID, recipientID, direction);
	}
	
	/**Following functions are responsible for receiving data from the
	 * rest of the system. The CTC office can only communicate directly
	 * with the track controller module.
	**/
	
	//Data to be sent from Track Controller to CTC Office 
	public void trackControllerLoadData(ArrayList<Integer> Blocklist){
		occupiedBlocks = Blocklist;
	}
	
	//Data to be sent from Train Model to CTC Office
	public void trainModelLoadData(ArrayList<Integer> t){
		throughput = t;
	}
	
	/**Following function is responsible for talking with the CTC
	 * Office's communication class, which will return data received 
	 * from the trackControllerLoadData(ArrayList<Integer>) function.
	**/ 
	
	//Data to be sent from this class to CTC_Comm class
	
	protected ArrayList<Integer> relayOccupiedBlocks(){
		return occupiedBlocks;
	}
	
	protected ArrayList<Integer> relayThroughput(){
		return throughput;
	}
	
	
}

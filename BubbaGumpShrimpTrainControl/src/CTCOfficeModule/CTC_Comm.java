///Bubba Gump Shrimp Co.
///Communication Class for CTC Office
///Jabari Dawkins
///April 10, 2013

package CTCOfficeModule;

import shared.Communication;
import trainControlModule.TrainControlPacket;
import trackControlModule.TrackControlPacket;
import trainControlModule.TrainControlComm;
import trackControlModule.TrackControlComm;


public class CTC_Comm implements Communication{
	private int module_id;
	private int authority;
	private int speedLimit;
	private double setSpeed;
	private ArrayList<ArrayList<Integer>> routes;
	private ArrayList<Integer> throughput;
	
	public CTC_Comm(int id){
		module_id = id;
	}
	
	//This method is called by other modules to 
	public static void receivePacket(Packet p){
		if(p.isMine()){
			this.getPacketData(p);
		}
		sendPacket(p);
	}
	
	public void getPacketData(Packet p){
		if(p instanceof TrackControlPacket){
			routes = p.getRoutes();
		}
		else if(p instanceof TrainModelPacket){
			throughput = p.getThroughput();
		}
	}
	
	public Packet createPacket(int recipientID, int trackControllerNum, int trainNum){
		if (recipientID == 2){
			TrackControlPacket p = new TrackControlPacket(module_id, recipientID, true, trackControllerNum);
			p.ctcLoadData(routes, speedLimit, authority);
		}
		else if (recipientID == 5){
			TrainControlPacket p = new TrainControlPacket(module_id, recipientID, true, trainNum);
			p.ctcLoadData(setSpeed);
		}
		else{
			return null;
		}
		return p;
	}
	
	public void sendPacket(Packet p){
		if(p.getDirection()){
			TrackControlComm.receivePacket(p);
		}
	} 
	
	private void loadAuthority(int auth){
		authority = auth;
		createPacket(2);
	}
	
	private void loadSpeedLimit(int sl){
		speedLimit = sl;
		createPacket(2);
	}
	
	private void loadSetSpeed(int ss){
		setSpeed = ss;
		createPacket(5);
	}
	
	private void loadRoutes(ArrayList<ArrayList<Integer>> r){
		routes = r;
		createPacket(2);
	}
}

package TrackControlModule;

import Shared.Communication;
import Shared.Packet;

public class TrackControlComm implements Communication {
	private final int myID = 2;
	private TrackController trackController;
	
	public TrackControlComm(TrackController trackController) {
		this.trackController = trackController;
	}
	public void receivePacket(Packet packet) {
		if (packet.isMine(myID)) {
			getPacketData(packet);
		}
		else {
			sendPacket(packet);
		}
	}

	public void getPacketData(Packet packet) {
		if (packet instanceof TrackControlPacket) {
			TrackControlPacket confirmedPacket = (TrackControlPacket) packet;
			if (packet.getSender() == 1) {
				//Set data provided by CTC Office
				trackController.addRoutes(confirmedPacket.getRoutes());
			}
			else if (packet.getSender() == 3) {
				//Set data provided by Track Model
				
			}
		}
	}

	public Packet createPacket(int recipientID) {
		if (recipientID == 1) {
			//Create packet and load it with data for CTC Office
		}
		else if (recipientID == 3) {
			//Create packet and load it with data for Track Model
		}
		return null;
	}

	public void sendPacket(Packet packet) {
		if (packet.getDirection()) {
			//send packet to Track Model
		}
		else {
			//send packet to CTC Office
		}
	}
}

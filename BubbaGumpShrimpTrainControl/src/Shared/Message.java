package Shared;
import java.util.Hashtable;

public class Message {
	private Hashtable<Integer,Packet> packets;
	private long timeCreated;
	
	public Message() {
		timeCreated = System.currentTimeMillis();
		packets = new Hashtable<Integer,Packet>();
	}
	
	public Boolean addPacket(Packet p) {
		if (containsID(p.getModuleID())) {
			return false;
		}
		packets.put(p.getModuleID(),p);
		return true;
	}
	
	public Boolean containsID(int moduleID) {
		return packets.containsKey(moduleID);
	}
	
	public Packet getPacket(int moduleID) {
		return packets.get(moduleID);
	}
	
	public long getCreateTime() {
		return timeCreated;
	}
}

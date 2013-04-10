package Shared;
public class Packet {
	private boolean read;
	private long timeCreated;
	private int moduleID;
	
	//id = Recipient module id number
	public Packet(int id) {
		timeCreated = System.currentTimeMillis();
		read = false;
		moduleID = id;
	}
	
	public long getCreateTime() {
		return timeCreated;
	}
	
	public int getModuleID() {
		return moduleID;
	}
	
	public void markRead(int id) {
		if (moduleID == id) {
			read = true;
		}
	}
	
	public boolean isRead() {
		return read;
	}
}
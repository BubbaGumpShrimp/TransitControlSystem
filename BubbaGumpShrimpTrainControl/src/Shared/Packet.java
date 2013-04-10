package Shared;

public class Packet {
	private long timeCreated;
	private int senderID;
	private int recipientID;
	//Message travel direction: true for forward (higher number next) and false for reverse (lower number next)
	private boolean direction;
	
	//id = Recipient module id number
	public Packet(int senderID, int recipientID, boolean direction) {
		timeCreated = System.currentTimeMillis();
		this.senderID = senderID;
		this.recipientID = recipientID;
		this.direction = direction;
	}
	
	public long getCreateTime() {
		return timeCreated;
	}
	
	public boolean isMine(int myID) {
		return recipientID == myID;
	}
	
	public int getSender() {
		return senderID;
	}
	
	public boolean getDirection() {
		return direction;
	}
}
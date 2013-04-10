package Shared;

public interface Communication {
	//This method will be called by your neighbor to provide your module with a packet
	//It should check for ownership and get data from your own packet or send another packet in the correct direction
	public void receivePacket(Packet p);
	//This method will allow you to get the data from the packet if you are the intended recipient
	public void getPacketData(Packet p);
	//This will create a new packet for the listed recipient
	//It should also fill the packet with data for the recipient
	public Packet createPacket(int recipientID);
	//Send the packet in the appropriate direction by calling your neighbor's receivePacket method
	public void sendPacket(Packet p);
}

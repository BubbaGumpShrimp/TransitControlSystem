package TrackControlModule;

import java.util.ArrayList;
import java.util.List;

public class Train {
	private int assumedNumber;
	private int blockLocated;
	private int authorityIssued;
	private int speedIssued;
	private int lastBlock;
	
	public Train(int assumedNumber, int beginBlock, int initialAuthority, int initialSpeed, int lastBlock) {
		this.assumedNumber = assumedNumber;
		this.blockLocated = beginBlock;
		this.authorityIssued = initialAuthority;
		this.speedIssued = initialSpeed;
		this.lastBlock = lastBlock;
	}

	//The assumed train number based on available information from CTC Office, if not known, this is 0
	public int getAssumedNumber() {
		return assumedNumber;
	}

	public void setAssumedNumber(int assumedNumber) {
		this.assumedNumber = assumedNumber;
	}

	public int getBlockLocated() {
		return blockLocated;
	}

	public void setBlockLocated(int blockLocated) {
		lastBlock = this.blockLocated;
		this.blockLocated = blockLocated;
	}

	public int getAuthorityIssued() {
		return authorityIssued;
	}

	public void setAuthorityIssued(int authorityIssued) {
		this.authorityIssued = authorityIssued;
	}

	public int getSpeedIssued() {
		return speedIssued;
	}

	public void setSpeedIssued(int speedIssued) {
		this.speedIssued = speedIssued;
	}
	
	public int getLastBlock() {
		return lastBlock;
	}
}

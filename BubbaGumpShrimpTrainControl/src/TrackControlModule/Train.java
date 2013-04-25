package TrackControlModule;

public class Train {
	private int assumedNumber;
	private int blockLocated;
	private int authorityIssued;
	private int speedIssued;
	
	public Train(int assumedNumber, int beginBlock, int initialAuthority, int initialSpeed) {
		this.assumedNumber = assumedNumber;
		this.blockLocated = beginBlock;
		this.authorityIssued = initialAuthority;
		this.speedIssued = initialSpeed;
	}

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
}

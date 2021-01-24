

/**
 * 
 */

/**
 * Christopher Brislin
 * 24 Jan 2021
 * UBlox
 */
public enum MessageClass implements UBXMessage{

	// Not actually 16bit, first byte is class, second is ID

	UBX_ACK((byte) 0x05),

	UBX_AID((byte) 0x0B),

	UBX_CFG((byte) 0x06),

	UBX_ESF((byte) 0x10),

	UBX_HNR((byte) 0x28),

	UBX_INF((byte) 0x04),

	UBX_LOG((byte) 0x21),

	UBX_MGA((byte) 0x13),

	UBX_MON((byte) 0x0A),

	UBX_NAV((byte) 0x01),

	UBX_RXM((byte) 0x02),

	UBX_SEC((byte) 0x27),

	UBX_TIM((byte) 0x0D),

	UBX_UPD((byte) 0x09)

	;

	private final byte message;

	MessageClass(byte message) {
		this.message = message;
	}

	

	public byte getByteVal() {
		// TODO Auto-generated method stub
		return this.message;
	}

}


public enum MessageID implements MessageClassInterface{
	
	ACK((byte) 0x01, MessageClass.UBX_ACK, "u1,u1"),
	NAK((byte) 0x00, MessageClass.UBX_ACK, "u1,u1"),
	
	ALM((byte) 0x30, MessageClass.UBX_AID, null),
	AOP((byte) 0x33, MessageClass.UBX_AID, null),
	EPH((byte) 0x31, MessageClass.UBX_AID, null),
	HUI((byte) 0x02, MessageClass.UBX_AID, null),
	INI((byte) 0x01, MessageClass.UBX_AID, null),
	
	ANT((byte) 0x13, MessageClass.UBX_CFG, null),
	BATCH((byte) 0x93, MessageClass.UBX_CFG, null),
	CFG((byte) 0x09, MessageClass.UBX_CFG, null),
	DAT((byte) 0x06, MessageClass.UBX_CFG, null),
	DGNSS((byte) 0x70, MessageClass.UBX_CFG, null),
	DOSC((byte) 0x61, MessageClass.UBX_CFG, null),
	ESRC((byte) 0x60, MessageClass.UBX_CFG, null),
	GEOFENCE((byte) 0x69, MessageClass.UBX_CFG, null),
	GNSS((byte) 0x3E, MessageClass.UBX_CFG, null),
	HNR((byte) 0x5C, MessageClass.UBX_CFG, null),
	INF((byte) 0x02, MessageClass.UBX_CFG, null),
	ITFM((byte) 0x39, MessageClass.UBX_CFG, null),
	LOGFILTER((byte) 0x47, MessageClass.UBX_CFG, null),
	MSG((byte) 0x01, MessageClass.UBX_CFG, null),
	NAV5((byte) 0x24, MessageClass.UBX_CFG, null),
	NAVX5((byte) 0x23, MessageClass.UBX_CFG, null),
	NMEA((byte) 0x17, MessageClass.UBX_CFG, null),
	ODO((byte) 0x1E, MessageClass.UBX_CFG, null),
	PM2((byte) 0x3B, MessageClass.UBX_CFG, null),
	PMS((byte) 0x86, MessageClass.UBX_CFG, null),
	PRT((byte) 0x00, MessageClass.UBX_CFG, null),
	PWR((byte) 0x57, MessageClass.UBX_CFG, null),
	RATE((byte) 0x08, MessageClass.UBX_CFG, null),
	RINV((byte) 0x34, MessageClass.UBX_CFG, null),
	RST((byte) 0x04, MessageClass.UBX_CFG, null),
	RXM((byte) 0x11, MessageClass.UBX_CFG, null),
	SBAS((byte) 0x16, MessageClass.UBX_CFG, null),
	SLAS((byte) 0x8D, MessageClass.UBX_CFG, null),
	SMGR((byte) 0x62, MessageClass.UBX_CFG, null),
	TMODE2((byte) 0x3D, MessageClass.UBX_CFG, null),
	TMODE3((byte) 0x71, MessageClass.UBX_CFG, null),
	TP5((byte) 0x31, MessageClass.UBX_CFG, null),
	TXSLOT((byte) 0x53, MessageClass.UBX_CFG, null),
	USB((byte) 0x1B, MessageClass.UBX_CFG, null),
	
	INS((byte) 0x15, MessageClass.UBX_ESF, null),
	MEAS((byte) 0x02, MessageClass.UBX_ESF, null),
	RAW((byte) 0x03, MessageClass.UBX_ESF, null),
	STATUS((byte) 0x10, MessageClass.UBX_ESF, null),
	
	H_INS((byte) 0x02, MessageClass.UBX_HNR, null),
	H_PVT((byte) 0x00, MessageClass.UBX_HNR, null),
	
	DEBUG((byte) 0x04, MessageClass.UBX_INF, null),
	ERROR((byte) 0x00, MessageClass.UBX_INF, null),
	NOTICE((byte) 0x02, MessageClass.UBX_INF, null),
	TEST((byte) 0x03, MessageClass.UBX_INF, null),
	WARNING((byte) 0x01, MessageClass.UBX_INF, null),
	
	L_BATCH((byte) 0x11, MessageClass.UBX_LOG, null),
	CREATE((byte) 0x07, MessageClass.UBX_LOG, null),
	ERASE((byte) 0x03, MessageClass.UBX_LOG, null),
	FINDTIME((byte) 0x0E, MessageClass.UBX_LOG, null),
	INFO((byte) 0x08, MessageClass.UBX_LOG, null),
	RETRIEVEBATCH((byte) 0x10, MessageClass.UBX_LOG, null),
	RETRIEVEPOSEXTRA((byte) 0x0F, MessageClass.UBX_LOG, null),
	RETRIEVEPOR((byte) 0x0B, MessageClass.UBX_LOG, null),
	RETRIEVE((byte) 0x09, MessageClass.UBX_LOG, null),
	STRING((byte) 0x04, MessageClass.UBX_LOG, null),
	
	MGA_ACK((byte) 0x60, MessageClass.UBX_MGA, null),
	MGA_ANO((byte) 0x20, MessageClass.UBX_MGA, null),
	MGA_BDS((byte) 0x03, MessageClass.UBX_MGA, null),
	MGA_DBD((byte) 0x80, MessageClass.UBX_MGA, null),
	MGA_FLASH((byte) 0x21, MessageClass.UBX_MGA, null),
	MGA_GAL((byte) 0x02, MessageClass.UBX_MGA, null),
	MGA_GLO((byte) 0x06, MessageClass.UBX_MGA, null),
	MGA_GPS((byte) 0x00, MessageClass.UBX_MGA, null),
	MGA_INI((byte) 0x40, MessageClass.UBX_MGA, null),
	MGA_QZSS((byte) 0x05, MessageClass.UBX_MGA, null),
	
	MON_BATCH((byte) 0x32, MessageClass.UBX_MON, null),
	MON_GNSS((byte) 0x28, MessageClass.UBX_MON, null),
	MON_HW2((byte) 0x0B, MessageClass.UBX_MON, null),
	MON_HW((byte) 0x09, MessageClass.UBX_MON, null),
	MON_IO((byte) 0x02, MessageClass.UBX_MON, null),
	MON_MSGPP((byte) 0x06, MessageClass.UBX_MON, null),
	MON_PATCH((byte) 0x27, MessageClass.UBX_MON, null),
	MON_RXBUF((byte) 0x07, MessageClass.UBX_MON, null),
	MON_RXR((byte) 0x21, MessageClass.UBX_MON, null),
	MON_SMGR((byte) 0x2E, MessageClass.UBX_MON, null),
	MON_TXBUF((byte) 0x08, MessageClass.UBX_MON, null),
	MON_VER((byte) 0x04, MessageClass.UBX_MON, null),
	
	AOPSTATUS((byte) 0x60, MessageClass.UBX_NAV, null),
	ATT((byte) 0x05, MessageClass.UBX_NAV, null),
	CLOCK((byte) 0x22, MessageClass.UBX_NAV, null),
	DGPS((byte) 0x31, MessageClass.UBX_NAV, null),
	DOP((byte) 0x04, MessageClass.UBX_NAV, null),
	EOE((byte) 0x61, MessageClass.UBX_NAV, null),
	NAV_GEOFENCE((byte) 0x39, MessageClass.UBX_NAV, null),
	HPPOSECEF((byte) 0x13, MessageClass.UBX_NAV, null),
	HPPOSLLH((byte) 0x14, MessageClass.UBX_NAV, null),
	NAV_ODO((byte) 0x09, MessageClass.UBX_NAV, null),
	ORB((byte) 0x34, MessageClass.UBX_NAV, null),
	POSECEF((byte) 0x01, MessageClass.UBX_NAV, null),
	POSLLH((byte) 0x02, MessageClass.UBX_NAV, null),
	PVT((byte) 0x07, MessageClass.UBX_NAV, null),
	RELPOSNED((byte) 0x3C, MessageClass.UBX_NAV, null),
	RESETODO((byte) 0x10, MessageClass.UBX_NAV, null),
	SAT((byte) 0x35, MessageClass.UBX_NAV, null),
	NAV_SBAS((byte) 0x32, MessageClass.UBX_NAV, null),
	NAV_SLAS((byte) 0x42, MessageClass.UBX_NAV, null),
	SOL((byte) 0x06, MessageClass.UBX_NAV, null),
	NAV_STATUS((byte) 0x03, MessageClass.UBX_NAV, null),
	SVINFO((byte) 0x30, MessageClass.UBX_NAV, null),
	SVIN((byte) 0x3B, MessageClass.UBX_NAV, null),
	TIMEBDS((byte) 0x24, MessageClass.UBX_NAV, null),
	TIMEGAL((byte) 0x25, MessageClass.UBX_NAV, null),
	TIMEGLO((byte) 0x23, MessageClass.UBX_NAV, null),
	TIMEGPS((byte) 0x20, MessageClass.UBX_NAV, null),
	TIMELS((byte) 0x26, MessageClass.UBX_NAV, null),
	TIMEUTC((byte) 0x21, MessageClass.UBX_NAV, null),
	VELECEF((byte) 0x11, MessageClass.UBX_NAV, null),
	VELNED((byte) 0x12, MessageClass.UBX_NAV, null),
	
	
	IMES((byte) 0x61, MessageClass.UBX_RXM, null),
	MEASX((byte) 0x14, MessageClass.UBX_RXM, null),
	PMREQ((byte) 0x41, MessageClass.UBX_RXM, null),
	RAWX((byte) 0x15, MessageClass.UBX_RXM, null),
	RLM((byte) 0x59, MessageClass.UBX_RXM, null),
	RTCM((byte) 0x32, MessageClass.UBX_RXM, null),
	SFRBX((byte) 0x13, MessageClass.UBX_RXM, null),
	SVSI((byte) 0x20, MessageClass.UBX_RXM, null),
	
	UNIQID((byte) 0x03, MessageClass.UBX_SEC, null),
	
	TIM_DOSC((byte) 0x11, MessageClass.UBX_TIM, null),
	TIM_FCHG((byte) 0x16, MessageClass.UBX_TIM, null),
	TIM_HOC((byte) 0x17, MessageClass.UBX_TIM, null),
	TIM_SMEAS((byte) 0x13, MessageClass.UBX_TIM, null),
	TIM_SVIN((byte) 0x04, MessageClass.UBX_TIM, null),
	TIM_TM2((byte) 0x03, MessageClass.UBX_TIM, null),
	TIM_TOS((byte) 0x12, MessageClass.UBX_TIM, null),
	TIM_TP((byte) 0x01, MessageClass.UBX_TIM, null),
	TIM_VCOCAL((byte) 0x15, MessageClass.UBX_TIM, null),
	TIM_VRFY((byte) 0x06, MessageClass.UBX_TIM, null),
	
	SOS((byte) 0x14, MessageClass.UBX_UPD, null),
	
	//Add RTCM message classes; Page 441
	
	
	;

	/**
	 * @param b 
	 * @param ubxAck
	 */
	private final byte messageID;
	private final MessageClass messageClass;
	private String messageFormat;
	
	
	MessageID(byte messageID, MessageClass messageClass, String messageFormat) {
		this.messageID = messageID;
		this.messageClass = messageClass;
		this.messageFormat = messageFormat;
	}

	@Override
	public byte getByteVal() {
		// TODO Auto-generated method stub
		return this.messageID;
	}
	
	public MessageClass getMessageClass() {
		return this.messageClass;
	}
	
	
	public String getMessageFormat() {
		return this.messageFormat;
	}
	
}

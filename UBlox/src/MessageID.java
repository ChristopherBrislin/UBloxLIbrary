
public enum MessageID implements UBXMessage{
	
	ACK((byte) 0x01, MessageClass.UBX_ACK),
	NAK((byte) 0x00, MessageClass.UBX_ACK),
	
	ALM((byte) 0x30, MessageClass.UBX_AID),
	AOP((byte) 0x33, MessageClass.UBX_AID),
	EPH((byte) 0x31, MessageClass.UBX_AID),
	HUI((byte) 0x02, MessageClass.UBX_AID),
	INI((byte) 0x01, MessageClass.UBX_AID),
	
	ANT((byte) 0x13, MessageClass.UBX_CFG),
	BATCH((byte) 0x93, MessageClass.UBX_CFG),
	CFG((byte) 0x09, MessageClass.UBX_CFG),
	DAT((byte) 0x06, MessageClass.UBX_CFG),
	DGNSS((byte) 0x70, MessageClass.UBX_CFG),
	DOSC((byte) 0x61, MessageClass.UBX_CFG),
	ESRC((byte) 0x60, MessageClass.UBX_CFG),
	GEOFENCE((byte) 0x69, MessageClass.UBX_CFG),
	GNSS((byte) 0x3E, MessageClass.UBX_CFG),
	HNR((byte) 0x5C, MessageClass.UBX_CFG),
	INF((byte) 0x02, MessageClass.UBX_CFG),
	ITFM((byte) 0x39, MessageClass.UBX_CFG),
	LOGFILTER((byte) 0x47, MessageClass.UBX_CFG),
	MSG((byte) 0x01, MessageClass.UBX_CFG),
	NAV5((byte) 0x24, MessageClass.UBX_CFG),
	NAVX5((byte) 0x23, MessageClass.UBX_CFG),
	NMEA((byte) 0x17, MessageClass.UBX_CFG),
	ODO((byte) 0x1E, MessageClass.UBX_CFG),
	PM2((byte) 0x3B, MessageClass.UBX_CFG),
	PMS((byte) 0x86, MessageClass.UBX_CFG),
	PRT((byte) 0x00, MessageClass.UBX_CFG),
	PWR((byte) 0x57, MessageClass.UBX_CFG),
	RATE((byte) 0x08, MessageClass.UBX_CFG),
	RINV((byte) 0x34, MessageClass.UBX_CFG),
	RST((byte) 0x04, MessageClass.UBX_CFG),
	RXM((byte) 0x11, MessageClass.UBX_CFG),
	SBAS((byte) 0x16, MessageClass.UBX_CFG),
	SLAS((byte) 0x8D, MessageClass.UBX_CFG),
	SMGR((byte) 0x62, MessageClass.UBX_CFG),
	TMODE2((byte) 0x3D, MessageClass.UBX_CFG),
	TMODE3((byte) 0x71, MessageClass.UBX_CFG),
	TP5((byte) 0x31, MessageClass.UBX_CFG),
	TXSLOT((byte) 0x53, MessageClass.UBX_CFG),
	USB((byte) 0x1B, MessageClass.UBX_CFG),
	
	INS((byte) 0x15, MessageClass.UBX_ESF),
	MEAS((byte) 0x02, MessageClass.UBX_ESF),
	RAW((byte) 0x03, MessageClass.UBX_ESF),
	STATUS((byte) 0x10, MessageClass.UBX_ESF),
	
	H_INS((byte) 0x02, MessageClass.UBX_HNR),
	H_PVT((byte) 0x00, MessageClass.UBX_HNR),
	
	DEBUG((byte) 0x04, MessageClass.UBX_INF),
	ERROR((byte) 0x00, MessageClass.UBX_INF),
	NOTICE((byte) 0x02, MessageClass.UBX_INF),
	TEST((byte) 0x03, MessageClass.UBX_INF),
	WARNING((byte) 0x01, MessageClass.UBX_INF),
	
	L_BATCH((byte) 0x11, MessageClass.UBX_LOG),
	CREATE((byte) 0x07, MessageClass.UBX_LOG),
	ERASE((byte) 0x03, MessageClass.UBX_LOG),
	FINDTIME((byte) 0x0E, MessageClass.UBX_LOG),
	INFO((byte) 0x08, MessageClass.UBX_LOG),
	RETRIEVEBATCH((byte) 0x10, MessageClass.UBX_LOG),
	RETRIEVEPOSEXTRA((byte) 0x0F, MessageClass.UBX_LOG),
	RETRIEVEPOR((byte) 0x0B, MessageClass.UBX_LOG),
	RETRIEVE((byte) 0x09, MessageClass.UBX_LOG),
	STRING((byte) 0x04, MessageClass.UBX_LOG),
	
	MGA_ACK((byte) 0x60, MessageClass.UBX_MGA),
	MGA_ANO((byte) 0x20, MessageClass.UBX_MGA),
	MGA_BDS((byte) 0x03, MessageClass.UBX_MGA),
	MGA_DBD((byte) 0x80, MessageClass.UBX_MGA),
	MGA_FLASH((byte) 0x21, MessageClass.UBX_MGA),
	MGA_GAL((byte) 0x02, MessageClass.UBX_MGA),
	MGA_GLO((byte) 0x06, MessageClass.UBX_MGA),
	MGA_GPS((byte) 0x00, MessageClass.UBX_MGA),
	MGA_INI((byte) 0x40, MessageClass.UBX_MGA),
	MGA_QZSS((byte) 0x05, MessageClass.UBX_MGA),
	
	MON_BATCH((byte) 0x32, MessageClass.UBX_MON),
	MON_GNSS((byte) 0x28, MessageClass.UBX_MON),
	MON_HW2((byte) 0x0B, MessageClass.UBX_MON),
	MON_HW((byte) 0x09, MessageClass.UBX_MON),
	MON_IO((byte) 0x02, MessageClass.UBX_MON),
	MON_MSGPP((byte) 0x06, MessageClass.UBX_MON),
	MON_PATCH((byte) 0x27, MessageClass.UBX_MON),
	MON_RXBUF((byte) 0x07, MessageClass.UBX_MON),
	MON_RXR((byte) 0x21, MessageClass.UBX_MON),
	MON_SMGR((byte) 0x2E, MessageClass.UBX_MON),
	MON_TXBUF((byte) 0x08, MessageClass.UBX_MON),
	MON_VER((byte) 0x04, MessageClass.UBX_MON),
	
	AOPSTATUS((byte) 0x60, MessageClass.UBX_NAV),
	ATT((byte) 0x05, MessageClass.UBX_NAV),
	CLOCK((byte) 0x22, MessageClass.UBX_NAV),
	DGPS((byte) 0x31, MessageClass.UBX_NAV),
	DOP((byte) 0x04, MessageClass.UBX_NAV),
	EOE((byte) 0x61, MessageClass.UBX_NAV),
	NAV_GEOFENCE((byte) 0x39, MessageClass.UBX_NAV),
	HPPOSECEF((byte) 0x13, MessageClass.UBX_NAV),
	HPPOSLLH((byte) 0x14, MessageClass.UBX_NAV),
	NAV_ODO((byte) 0x09, MessageClass.UBX_NAV),
	ORB((byte) 0x34, MessageClass.UBX_NAV),
	POSECEF((byte) 0x01, MessageClass.UBX_NAV),
	POSLLH((byte) 0x02, MessageClass.UBX_NAV),
	PVT((byte) 0x07, MessageClass.UBX_NAV),
	RELPOSNED((byte) 0x3C, MessageClass.UBX_NAV),
	RESETODO((byte) 0x10, MessageClass.UBX_NAV),
	SAT((byte) 0x35, MessageClass.UBX_NAV),
	NAV_SBAS((byte) 0x32, MessageClass.UBX_NAV),
	NAV_SLAS((byte) 0x42, MessageClass.UBX_NAV),
	SOL((byte) 0x06, MessageClass.UBX_NAV),
	NAV_STATUS((byte) 0x03, MessageClass.UBX_NAV),
	SVINFO((byte) 0x30, MessageClass.UBX_NAV),
	SVIN((byte) 0x3B, MessageClass.UBX_NAV),
	TIMEBDS((byte) 0x24, MessageClass.UBX_NAV),
	TIMEGAL((byte) 0x25, MessageClass.UBX_NAV),
	TIMEGLO((byte) 0x23, MessageClass.UBX_NAV),
	TIMEGPS((byte) 0x20, MessageClass.UBX_NAV),
	TIMELS((byte) 0x26, MessageClass.UBX_NAV),
	TIMEUTC((byte) 0x21, MessageClass.UBX_NAV),
	VELECEF((byte) 0x11, MessageClass.UBX_NAV),
	VELNED((byte) 0x12, MessageClass.UBX_NAV),
	
	
	IMES((byte) 0x61, MessageClass.UBX_RXM),
	MEASX((byte) 0x14, MessageClass.UBX_RXM),
	PMREQ((byte) 0x41, MessageClass.UBX_RXM),
	RAWX((byte) 0x15, MessageClass.UBX_RXM),
	RLM((byte) 0x59, MessageClass.UBX_RXM),
	RTCM((byte) 0x32, MessageClass.UBX_RXM),
	SFRBX((byte) 0x13, MessageClass.UBX_RXM),
	SVSI((byte) 0x20, MessageClass.UBX_RXM),
	
	UNIQID((byte) 0x03, MessageClass.UBX_SEC),
	
	TIM_DOSC((byte) 0x11, MessageClass.UBX_TIM),
	TIM_FCHG((byte) 0x16, MessageClass.UBX_TIM),
	TIM_HOC((byte) 0x17, MessageClass.UBX_TIM),
	TIM_SMEAS((byte) 0x13, MessageClass.UBX_TIM),
	TIM_SVIN((byte) 0x04, MessageClass.UBX_TIM),
	TIM_TM2((byte) 0x03, MessageClass.UBX_TIM),
	TIM_TOS((byte) 0x12, MessageClass.UBX_TIM),
	TIM_TP((byte) 0x01, MessageClass.UBX_TIM),
	TIM_VCOCAL((byte) 0x15, MessageClass.UBX_TIM),
	TIM_VRFY((byte) 0x06, MessageClass.UBX_TIM),
	
	SOS((byte) 0x14, MessageClass.UBX_UPD),
	
	
	;

	/**
	 * @param b
	 * @param ubxAck
	 */
	private final byte messageID;
	private final MessageClass messageClass;
	
	MessageID(byte messageID, MessageClass messageClass) {
		this.messageID = messageID;
		this.messageClass = messageClass;
	}

	@Override
	public byte getByteVal() {
		// TODO Auto-generated method stub
		return this.messageID;
	}
	
	public MessageClass getMessageClass() {
		return this.messageClass;
	}
	
}

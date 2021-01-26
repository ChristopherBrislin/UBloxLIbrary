import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * 
 */

/**
 * Christopher Brislin
 * 24 Jan 2021
 * UBlox
 */
public class MessageBuilder{
	
	PayloadBuilder payloadBuilder;
	
	private byte[] message;
	private byte[] payload = new byte[] {};
	private byte[] checksum;
	
	private final byte SYNC_A = (byte) 0xb5;
	private final byte SYNC_B = (byte) 0x62;
	
	MessageID messageID;
	MessageClass messageClass;
	
	UBXMessage ubxMessage;
	
	
	
	//Message length is 6 byte header, N byte body and 2 byte checksum;
	
	public UBXMessage build() {
		
		if(payloadBuilder != null) {
			//Construct with a payload.
		this.payload = payloadBuilder.getBody();
		construct(payload);
		
		}else {
		//Construct without a payload.
		construct();
		}
		//In case the Builder object gets re-used.
		payloadBuilder = null;
		ubxMessage = new UBXMessage(message);
		
		return ubxMessage;
	}
	
	
	
	public MessageBuilder builder(MessageID configType, byte[] payload) {
		//This method for manually build payloads in testing. 
		//Normally use the builder and reference the documentation. 
		this.messageID = configType;
		this.messageClass = configType.getMessageClass();
		this.payload = payload;
		
		return this;
	
	}
	
	public MessageBuilder builder(MessageID configType) {
		
		
		this.messageID = configType;
		this.messageClass = configType.getMessageClass();
		
		return this;
	
	}
	
	public PayloadBuilder bodyBuilder() {
		
		//Include a payload in the message.
		payloadBuilder = new PayloadBuilder(this);
		return payloadBuilder;
	}
	
	
	
	private void construct() {
		//Payload gets added even when there is no payload in the message
		short length = (short) 0;
		
		byte[] temp = new byte[]{SYNC_A, SYNC_B, messageClass.getByteVal(), messageID.getByteVal(), getByteArray(length)[0], getByteArray(length)[1] };
		byte[] temp2 = new byte[temp.length + payload.length + 2];
		
		
		System.arraycopy(temp, 0, temp2, 0, temp.length);
		
		
		byte[] checkSum = calcChecksum(temp2);
		
		System.arraycopy(checkSum, 0, temp2, temp2.length-2, checkSum.length);
		
		
		message = temp2;
		
	}
	
	private void construct(byte[] payload) {
		//Payload gets added even when there is no payload in the message
		short length = (short) this.payload.length;
		
		byte[] temp = new byte[]{SYNC_A, SYNC_B, messageClass.getByteVal(), messageID.getByteVal(), getByteArray(length)[0], getByteArray(length)[1] };
		byte[] temp2 = new byte[temp.length + payload.length + 2];
		
		
		System.arraycopy(temp, 0, temp2, 0, temp.length);
		System.arraycopy(payload, 0, temp2, 6, payload.length);
		
		byte[] checkSum = calcChecksum(temp2);
		
		System.arraycopy(checkSum, 0, temp2, temp2.length-2, checkSum.length);
		
		
		message = temp2;
		
	}
	
	private byte[] getByteArray(short val) {
		byte[] tempArray = new byte[2];
		
		tempArray =ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN).putShort(val).array();
		
		return tempArray;
	}
	
	public byte[] calcChecksum(byte[] data) {
		byte ckd_a=0;
		byte ckd_b = 0;
		
		byte[] sum = new byte[2];
		
		for(int i=2; i<data.length-2; i++) {
			
			
			ckd_a += data[i];
			ckd_b += ckd_a;
		}
		 sum[0] = ckd_a;
		 sum[1] = ckd_b;
		
		 this.checksum = sum;
		
		return this.checksum;
	}

}

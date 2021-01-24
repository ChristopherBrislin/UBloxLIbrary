import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * 
 */

/**
 * Christopher Brislin 24 Jan 2021 UBlox
 */
public class PayloadBuilder {

	byte[] payload;
	MessageBuilder parent;
	
	public PayloadBuilder(MessageBuilder parent) {
		payload = new byte[] {};
		this.parent = parent;
	}

	public PayloadBuilder unsignedByte(byte val) {

		concatPayload((byte) val);

		return this;
	}

	public PayloadBuilder signedByte(byte val) {

		concatPayload(val);

		return this;
	}

	public PayloadBuilder unsignedLong(int val) {

		byte[] int2byte = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt((int) val).array();
		
		
		
		concatPayload(int2byte);

		return this;
	}
	
	public PayloadBuilder signedLong(int val) {

		byte[] int2byte = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(val).array();

		concatPayload(int2byte);

		return this;
	}

	public PayloadBuilder unsignedShort(short val) {

		byte[] short2byte = ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN).putShort((short) val).array();

		concatPayload(short2byte);

		return this;
	}
	
	public PayloadBuilder signedShort(short val) {

		byte[] short2byte = ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN).putShort(val).array();

		concatPayload(short2byte);

		return this;
	}
	
	public MessageBuilder buildBody() {
		
		
		return parent;
	}
	
	public byte[] getBody() {
		return payload;
	}
	
	
	
	
	

	private void concatPayload(byte[] toAdd) {
			
		byte[] temp = new byte[payload.length + toAdd.length];
		
		System.arraycopy(payload, 0, temp, 0, payload.length);
		System.arraycopy(toAdd, 0, temp, payload.length, toAdd.length);
		
		
		payload = temp;
		
	}

	private void concatPayload(byte toAdd) {
			byte[] temp = new byte[payload.length+1];
			
			System.arraycopy(payload, 0, temp, 0, payload.length);
			temp[payload.length] = toAdd;
			
			payload = temp;
	}

}

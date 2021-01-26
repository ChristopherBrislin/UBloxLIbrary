import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.EnumSet;

public class UBXMessage {

	MessageClass messageClass;
	MessageID messageID;
	private short payloadSize;

	final static int PAYLOAD_INDEX = 6;
	byte[] message;
	byte[] payload;

	public UBXMessage() {

	}

	public UBXMessage(byte[] message) {
		this.message = message;
		parseMessage();
	}

	private void parseMessage() {

		payloadSize = getShort(message[4], message[5]);

		EnumSet.allOf(MessageID.class).forEach(messageID -> {

			if (message[2] == messageID.getMessageClass().getByteVal()) {

				if (message[3] == messageID.getByteVal()) {
					this.messageClass = messageID.getMessageClass();
					this.messageID = messageID;

					if (payloadSize > 0) {
						payload = new byte[payloadSize];
						for (int i = 0; i < payloadSize; i++) {
							this.payload[i] = message[i + PAYLOAD_INDEX];
						}
					}

				}
			}

		});

	}

	public MessageID getMessageID() {

		return this.messageID;
	}

	public MessageClass getMessageClass() {
		return this.messageClass;
	}

	private short getShort(byte a, byte b) {
		byte[] temp = { a, b };
		return ByteBuffer.wrap(temp).order(ByteOrder.LITTLE_ENDIAN).getShort();

	}

	public String getMessageString() {
		
		String payloadString = "";
		
		for(byte val:this.payload) {
			payloadString += (val&0xFF) +" ";
		}
		
		String s = "$UBX: Message Class: " + messageClass + " Message ID: " + messageID + " Size: " + payloadSize
				+ " Payload Contents: " + payloadString + " /UBX$";

		return s;

	}
	
	

	public byte[] getPayload() {

		return this.payload;
	}

	public byte[] getByteArray() {
		return this.message;
	}

	public byte[] getChecksum() {
		byte[] checksum = new byte[2];

		checksum[0] = message[message.length - 2];
		checksum[1] = message[message.length - 1];

		/*
		 * System.out.println("Calculate Cheksum: " + (ckd_a & 0xFF) + " " + (ckd_b &
		 * 0xFF) + " Sent Checksum: " + (cks_a & 0xFF) + " " + (cks_b & 0xFF));
		 */

		return checksum;
	}

}

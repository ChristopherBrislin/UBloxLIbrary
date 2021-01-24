import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.EnumSet;

public class UBloxMessage {

	MessageClass messageClass;
	MessageID messageID;
	short payloadSize;

	
	int payloadIndex;
	byte[] message;
	byte[] payload;

	boolean validMessage = false;

	public void parseMessage(byte[] data) {
		// this.message =data;
		

		int startIndex =0;

		for (int i = 0; i < data.length; i++) {

			
			if (data[i] == -75 && data[i + 1] == 0x62) {
				
				startIndex = i;
				validMessage = true;
				break;
			}else {
				validMessage = false;
				//System.out.println("Non UBX message");
			}
			
		}
		
		if(validMessage) {
		
		this.payloadSize = getShort(data[startIndex +4], data[startIndex +5]);
		
		message = new byte[6 + payloadSize + 2];
		
		for (int k = 0; k < message.length; k++) {
			this.message[k] = data[k + startIndex];
			
		}
		//System.out.println("array built");
		if (validChecksum(message)) {
			
			
			EnumSet.allOf(MessageID.class).forEach(messageID -> {
				
				if (message[2] == messageID.getMessageClass().getByteVal()) {
					
					if (message[3] == messageID.getByteVal()) {
						this.messageClass = messageID.getMessageClass();
						this.messageID = messageID;

						
						this.payloadIndex = 6;
						getMessage();
						
						
						}
					}
			

			});
		}
		else {
			System.out.println("$UBX: Error - checksum fail");
			for (byte val : message) {
				System.out.print((val & 0xFF) + " ");
			}
		}
			
		 

		// valid message
		
		}else {
			//non UBX message
		}
		
		

	}


	

	public short getShort(byte a, byte b) {
		byte[] temp = { a, b };
		return ByteBuffer.wrap(temp).order(ByteOrder.LITTLE_ENDIAN).getShort();

	}

	public void getMessage() {

		
			System.out.println("$UBX: Message Class: " + messageClass + " Message ID: " + messageID + " Size: "
					+ payloadSize + " Payload Contents: " + getPayload() + " /UBX$");

		

		validMessage = false;

	}

	public String getPayload() {
		String s = "";

		for(int i = payloadIndex; i<(payloadIndex+payloadSize); i++) {
			s += " " + (message[i]&0xFF);
		}

		return s;

	}

	public boolean validChecksum(byte[] data) {
		
		
		byte ckd_a = 0;
		byte ckd_b = 0;

		

		for (int i = 2; i < data.length - 2; i++) {

			ckd_a += data[i];
			ckd_b += ckd_a;
		}

		int cks_b = data[data.length-1];
		int cks_a = data[data.length-2];

		System.out.println("Calculate Cheksum: " + (ckd_a & 0xFF) + " " + (ckd_b & 0xFF) + " Sent Checksum: "
				+ (cks_a & 0xFF) + " " + (cks_b & 0xFF));

		return (ckd_a == cks_a && ckd_b == cks_b);
	}

}

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * 
 */

/**
 * Christopher Brislin 24 Jan 2021 UBlox
 */
public class UBXConnection {

	UBXMessage message;
	InputStream in;
	OutputStream out;
	
	/*
	*To be implemented - input/output stream handling for more 
	*connection methods. 
	*
	*/
	/*
	
	public void builder(InputStream in, OutputStream out) {
		this.in = in;
		this.out = out;

		Thread first = Thread.currentThread();

		Thread t = new Thread() {
			public void run() {
				synchronized (first) {

				}
			}
		};

		t.start();

	}
	*/

	public void bytesIn(byte[] bytesIn) {
		message = null;
		try {
			parseBytes(bytesIn);
		} catch (UBXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void parseBytes(byte[] data) throws UBXException {

		int messageSize;
		byte[] byteMessage;
		
		for (int i = 0; i < data.length; i++) {
			if (data[i] == -75 && data[i + 1] == 0x62) {
				
				
				// UBX header found.
				//Message size should be payload size  + 2 sync bytes, 1 class byte, 1 ID byte, 
				//2 payload Size bytes, the payload size N bytes long, and 2 checksum bytes;
				
				messageSize = shortFromBytes(data[i + 4], data[i + 5]) + 8;

				if (data.length != (messageSize)) {
					// Clip the array and re-index.
					byteMessage = new byte[messageSize];
					System.arraycopy(data, i, byteMessage, 0, (messageSize));
					
					if(validChecksum(byteMessage)) {
						message = new UBXMessage(byteMessage);
					}
					
					break;

				} else if (i == 0) {
					// If the inbound byte[] is the correct size and indexed correctly
					// just set equal.
					
					if(validChecksum(data)) {
						message = new UBXMessage(data);
						break;
					}else {
						//Checksum fail
						throw new UBXException("Checksum failed: ");
					}
					
				} 
				

			}
			// Not UBX Message;
		}

	}

	public UBXMessage next() {

		return this.message;

	}

	private short shortFromBytes(byte a, byte b) {
		byte[] temp = { a, b };
		return ByteBuffer.wrap(temp).order(ByteOrder.LITTLE_ENDIAN).getShort();

	}

	public void send(byte[] message) throws IOException {

	}

	private boolean validChecksum(byte[] data) {

		byte ckd_a = 0;
		byte ckd_b = 0;

		for (int i = 2; i < data.length - 2; i++) {

			ckd_a += data[i];
			ckd_b += ckd_a;
		}

		int cks_b = data[data.length - 1];
		int cks_a = data[data.length - 2];


		return (ckd_a == cks_a && ckd_b == cks_b);
	}

}

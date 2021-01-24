import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

/**
 * 
 */

/**
 * Christopher Brislin
 * 23 Jan 2021
 * UBlox
 */
public class Main {
	static boolean connected = false;
	
	static boolean notSent = true;
	
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		
		
		System.out.println("Starting port monitor...");
		
		SerialPort port = SerialPort.getCommPorts()[0];
		
		while(!connected){
			for(SerialPort ports: SerialPort.getCommPorts()) {
				if(ports.getDescriptivePortName().contains("u-blox")) {
					
				port = ports;
				connected = true;
				System.out.println(port.getDescriptivePortName() +" detected: connecting...");
				buildPort(port);
				
				
				break;
				}
				
			}
			
		
			
		}
		
		System.out.println("Terminating...");
		
		
		
		
		

	}
	
	public static void buildPort(SerialPort port) {
		
		long timeNow = System.currentTimeMillis();
		
		
		
		
		
		/*
		byte[] portConfig = new byte[]{(byte)181, 0x62, 0x0A, 0x04, 0x00, 0x00,  0x0E, 0x34};
		byte[] body = new byte[]{0x06, 0x71, 0x28, 0x00, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00, 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 ,(byte) 0xE8 , 0x03 , 0x00 , 0x00 , (byte)0xD0 , 0x07 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00};
		
		byte check_a=0;
		byte check_b = 0;
		
		for(byte val:body) {
			check_a += val;
			check_b += check_a;
		}
		
		byte[] checksum = {check_a, check_b};
		
		byte[]message = new byte[header.length+body.length+checksum.length];
		System.arraycopy(header, 0, message, 0, header.length);
		System.arraycopy(body, 0, message, header.length, body.length);
		System.arraycopy(checksum, 0, message, header.length+body.length, checksum.length);
		*/
		byte[] body = new byte[]{0x00 , 0x00 , 0x01 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 ,(byte) 0xE8 , 0x03 , 0x00 , 0x00 , (byte)0xD0 , 0x07 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00};
							//	.0xB5 , 0x62 , 0x06 , 0x71 , 0x28 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x9F , 0x93
		
		MessageBuilder cfgMsg = new MessageBuilder();
		
		
		
		
		MessageBuilder test = new MessageBuilder();
		
		/*
		byte[] test2 = test.builder(MessageID.TMODE2).bodyBuilder()
			.unsignedByte((byte) 0x01)
			.unsignedByte((byte) 0x00)
			.unsignedShort((short)0x00)
			.signedLong(0)
			.signedLong(0)
			.signedLong(0)
			.unsignedLong(0)
			.unsignedLong(180)
			.unsignedLong(10000)
			.buildBody()
			.build();
			*/
		byte[] test2 = test.builder(MessageID.TMODE3).bodyBuilder()
				.unsignedByte((byte)0x00)
				.unsignedByte((byte) 0x00)
				.unsignedShort((short) 0x01)
				.signedLong(0)
				.signedLong(0)
				.signedLong(0)
				.signedByte((byte) 0)
				.signedByte((byte)0)
				.signedByte((byte)0)
				.unsignedByte((byte)0)
				.unsignedLong(0)
				.unsignedLong(180)
				.unsignedLong(200000)
				.unsignedByte((byte)0x00)
				.unsignedByte((byte) 0x00)
				.unsignedByte((byte)0x00)
				.unsignedByte((byte) 0x00)
				.unsignedByte((byte)0x00)
				.unsignedByte((byte) 0x00)
				.unsignedByte((byte)0x00)
				.unsignedByte((byte) 0x00)
				.buildBody()
				.build();
		
		byte[] test3 = cfgMsg.builder(MessageID.INF).bodyBuilder()
				.unsignedByte((byte)0x00)
				.buildBody()
				.build();
				
		
		for(byte val: test3) {
			System.out.print((val&0xFF) + " ");
		}
		
		System.out.println();
		
		byte[]message = cfgMsg.builder(MessageID.MON_VER).build();
		
		for(byte val:message) {
			System.out.print((val&0xFF)+" ");
		}
		
		port.setComPortTimeouts(SerialPort.TIMEOUT_NONBLOCKING, 500 , 500); 

		port.setBaudRate(115200);
		port.openPort();
		
		
		
		
		if(port.isOpen())System.out.println("Connected!");
		//int data;
		
		UBloxConnection connection = new UBloxConnection();
		connection.builder(port.getInputStream(), port.getOutputStream());
		
		
		 
		port.addDataListener(new SerialPortDataListener() {
			
			
			@Override
			public int getListeningEvents() {
				return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
			} // Returns listening event when data AVAILABLE

			@Override
			public void serialEvent(SerialPortEvent event) {
				if (event.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE) {
					return; // if the event is not the correct type return.
				}

				
				byte[] newData = new byte[port.bytesAvailable()];
				port.readBytes(newData, newData.length);
				
				System.out.print(new String(newData, StandardCharsets.UTF_8));
				
				UBloxMessage ubxMessage = new UBloxMessage();
				ubxMessage.parseMessage(newData);
				
				if(notSent) {
				port.writeBytes(test3, test3.length);
				notSent = false;
				}
				
				
					
						
				
			
				
				
				
				
																					// array and append it.
			}
		});
	}
	
	

}

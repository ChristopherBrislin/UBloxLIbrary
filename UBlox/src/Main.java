import java.nio.charset.StandardCharsets;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

/**
 * 
 */

/**
 * Christopher Brislin 23 Jan 2021 UBlox
 */
public class Main {
	static boolean connected = false;

	static boolean notSent = true;
	static long lastTime;

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		lastTime = System.currentTimeMillis();

		try {

			System.out.println("Starting port monitor...");

			SerialPort port = SerialPort.getCommPorts()[0];

			while (!connected) {
				for (SerialPort ports : SerialPort.getCommPorts()) {
					if (ports.getDescriptivePortName().contains("u-blox")) {

						port = ports;
						connected = true;
						System.out.println(port.getDescriptivePortName() + " detected: connecting...");
						buildPort(port);

						break;
					}

				}

			}

		} catch (Throwable ex) {
			ex.printStackTrace();
		}

	}

	public static void buildPort(SerialPort port) {

		/*
		 * byte[] body = new byte[]{0x06, 0x71, 0x28, 0x00, 0x00, 0x00, 0x01, 0x00,
		 * 0x00, 0x00, 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00,
		 * 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 ,(byte) 0xE8 ,
		 * 0x03 , 0x00 , 0x00 , (byte)0xD0 , 0x07 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 ,
		 * 0x00 , 0x00 , 0x00 , 0x00 , 0x00};
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		// byte[] body = new byte[]{0x00 , 0x00 , 0x01 , 0x00 , 0x00 , 0x00 , 0x00 ,
		// 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 ,
		// 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 ,(byte) 0xE8 , 0x03 , 0x00 , 0x00 ,
		// (byte)0xD0 , 0x07 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 ,
		// 0x00 , 0x00};
		// .0xB5 , 0x62 , 0x06 , 0x71 , 0x28 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 ,
		// 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 ,
		// 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 ,
		// 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 , 0x00 ,
		// 0x00 , 0x00 , 0x9F , 0x93

		MessageBuilder test = new MessageBuilder();

		UBXMessage message = test.builder(MessageID.TMODE3).bodyBuilder().unsignedByte((byte) 0x00)
				.unsignedByte((byte) 0x00).unsignedShort((short) 0x01).signedLong(0).signedLong(0).signedLong(0)
				.signedByte((byte) 0).signedByte((byte) 0).signedByte((byte) 0).unsignedByte((byte) 0).unsignedLong(0)
				.unsignedLong(180).unsignedLong(200000).unsignedByte((byte) 0x00).unsignedByte((byte) 0x00)
				.unsignedByte((byte) 0x00).unsignedByte((byte) 0x00).unsignedByte((byte) 0x00).unsignedByte((byte) 0x00)
				.unsignedByte((byte) 0x00).unsignedByte((byte) 0x00).buildBody().build();

		UBXMessage configRTCM = new MessageBuilder().builder(MessageID.MSG).bodyBuilder().unsignedByte((byte) 0xF5)
				.unsignedByte((byte) 0x05).unsignedByte((byte) 0x01).buildBody().build();

		UBXMessage svin = new MessageBuilder().builder(MessageID.SVIN).build();

		System.out.println(message.getMessageString());

		port.setComPortTimeouts(SerialPort.TIMEOUT_NONBLOCKING, 1000, 1000);
		port.setBaudRate(57600);
		port.openPort();

		if (port.isOpen())
			System.out.println("Connected!");

		UBXConnection connection = new UBXConnection();

		try {

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


					UBXMessage ubxMessage = new UBXMessage();
					connection.bytesIn(newData);

					if ((ubxMessage = connection.next()) != null) {
						System.out.println(ubxMessage.getMessageString());
					} else {

						System.out.print(new String(newData, StandardCharsets.UTF_8));

					}

					if (notSent) {
						port.writeBytes(configRTCM.getByteArray(), configRTCM.getByteArray().length);
						notSent = false;
					}

					if (!notSent && (System.currentTimeMillis() > (lastTime + 800))) {

						port.writeBytes(svin.getByteArray(), svin.getByteArray().length);
						lastTime = System.currentTimeMillis();
					}

				}
			});
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 */

/**
 * Christopher Brislin
 * 24 Jan 2021
 * UBlox
 */
public class UBloxConnection {
	
	InputStream in;
	OutputStream out;
	ReentrantLock readLock;
	
	public void builder(InputStream in, OutputStream out) {
		this.in = in;
		this.out = out;
	}
	
	public byte[] next() throws IOException, InterruptedException {
		byte[] message;
		
		while(!(in.available() > 0)) {
			
		}
		
		
		message = new byte[in.available()];
		message = in.readAllBytes();
		
		return message;
		
		
	}
	
	public void send(byte[] message) throws IOException {
		out.write(message, 0, message.length);
		out.flush();
	}

}

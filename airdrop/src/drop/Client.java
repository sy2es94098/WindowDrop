package drop;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Set;
import java.util.HashSet;

import dns.NeighborDiscovery;
import dns.UserInfo;

public class Client {
	private FileInputStream fis;
	private DataOutputStream dos;
	private Socket socket;
	private byte[] sendByte;
	
	public boolean connect(String ipAddr) {
		try {
			while (true) {
				socket = new Socket(ipAddr, 1234);
				break;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean sendFile(String fileName) {
		try {
			int length = 0;
			
			File file = new File(fileName);
			fis = new FileInputStream(file);
			dos = new DataOutputStream(socket.getOutputStream());
			sendByte = new byte[1024];
			
			while ((length = fis.read(sendByte)) > 0) {
				dos.write(sendByte, 0, length);
				dos.flush();
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean closeClient() {
		try {
			fis.close();
			dos.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}

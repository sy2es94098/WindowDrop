package drop;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private DataInputStream dis;
	private Socket socket;
	private static FileOutputStream fos;
	private int port;
	private byte[] getByte;
	
	public void createServer(int port) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					ServerSocket ss = new ServerSocket(port);
					socket = ss.accept();
					
					receiveFile("test.mp4");
					closeServer();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Server create success");
			}
		}).start();
	}
	
	public boolean listen(String fileName) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true)
				{
					if(receiveFile(fileName) == true);
					break;
				}
			}}).start();
		return true;
	}
	
	public boolean receiveFile(String fileName) {
		try {
			getByte = new byte[1024];
			int length =0;
			dis = new DataInputStream(socket.getInputStream());
			File file = new File(fileName);
			fos = new FileOutputStream(file);
			
			while((length = dis.read(getByte))>0)
			{
				fos.write(getByte,0,length);
				fos.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean closeServer() {
		try {
			dis.close();
			fos.close();
	        socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	 
}

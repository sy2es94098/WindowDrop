import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Set;
import java.util.HashSet;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;

import dns.UserInfo;
import dns.NeighborDiscovery;
import drop.Server;
import drop.Client;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String receiveFile = "test.txt";
		Server server = new Server();
		server.createServer(1234);
		
        JmDNS jmdnsRegister = null;
		try {
			jmdnsRegister = JmDNS.create(InetAddress.getLocalHost(), "jmdnsRegister");
		} catch (UnknownHostException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        ServiceInfo serviceInfo = ServiceInfo.create("_test._tcp.local.", "bbb", 6666, "path=index.html");
        // service register
        try {
			jmdnsRegister.registerService(serviceInfo);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

        Runtime.getRuntime().addShutdownHook(
            new Thread(new Runnable() {

                @Override
                public void run() {
                    jmdnsRegister.unregisterAllServices();
                }
            }
        ));

        JmDNS jmdnsDiscover = null;
		try {
			jmdnsDiscover = JmDNS.create(InetAddress.getLocalHost(), "jmdnsDiscover");
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        // service discover
        NeighborDiscovery discover;
		try {
			discover = new NeighborDiscovery(jmdnsDiscover);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        Set<UserInfo> neighbors = NeighborDiscovery.getNeighbors();
		
		String sendFile = "D:\\Desktop\\drop\\2\\這到底什麼閃現 2分鐘版.mp4";
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Client client = new Client();
		if(client.connect(neighbors))
		{
			System.out.println("Client create success");
		}
		
		if(client.sendFile(sendFile))
		{
			System.out.println(sendFile + " is sended");
		}
		if(client.closeClient())
		{
			System.out.println("client closed");
		}
		
		/*if(server.receiveFile(receiveFile))
		{
			System.out.println(receiveFile+ " received");
		}
		if(server.closeServer()) {
			System.out.println("server closed");
		}*/
	}

}

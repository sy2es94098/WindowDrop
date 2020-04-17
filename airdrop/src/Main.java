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

public class Main {
    public static void main(String[] args) {
        try {


            Server server = new Server();
            server.createServer(1234);

            JmDNS jmdnsRegister = JmDNS.create(InetAddress.getLocalHost(), "jmdnsRegister");
            ServiceInfo serviceInfo = ServiceInfo.create("_test._tcp.local.", "bbb", 6666, "path=index.html");
            // service register
            jmdnsRegister.registerService(serviceInfo);

            Runtime.getRuntime().addShutdownHook(
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        jmdnsRegister.unregisterAllServices();
                    }
                }
            ));

            JmDNS jmdnsDiscover = JmDNS.create(InetAddress.getLocalHost(), "jmdnsDiscover");
            // service discover
            NeighborDiscovery dicover = new NeighborDiscovery(jmdnsDiscover);

            /*new Thread(new Runnable() {
                public void run() {
                    try {
                        // service register
                        jmdns.registerService(serviceInfo);
                        // service discover
                        new NeighborDiscovery(jmdns);
                    } catch(UnknownHostException e) {
                        e.printStackTrace();
                    } catch(IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            jmdns.registerService(serviceInfo);
            Thread.sleep(10000);
            // service discover
            new NeighborDiscovery(jmdns);*/

            while(true) {
                try {
                    server.receiveFile("test.mp4");
                    break;
                } catch(Exception e){
                    continue;
                }
            }

            if(server.closeServer()) {
                System.out.println("server closed");
            }   
            
            Set<UserInfo> neighbors = NeighborDiscovery.getNeighbors();

        } catch(UnknownHostException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        } 
    }
}
package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Set;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import javax.swing.*;
import dns.UserInfo;
import dns.NeighborDiscovery;
import drop.Client;
import drop.Server;


public class Gui{

	//static Page Page1 = new Page();
	//static Page Page2 = new Page();
	//static Page Page3 = new Page();
	//static Page Page4 = new Page();
    private static Set<UserInfo> neighbors;

	static String username;
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		
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
        
		
		
		JFrame frame = new JFrame("Title");
        frame.setSize(1280, 765);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        frame.getContentPane().setLayout(null);
        JButton button1 = new JButton("其他使用者");
        JButton button2 = new JButton("傳送檔案");
        JButton button3 = new JButton("聊天室");
        JButton button4 = new JButton("測試網速");
         
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);

        button1.setSize(180, 180);
        button2.setSize(180, 180);
        button3.setSize(180, 180);
        button4.setSize(180, 180);
        
        button1.setLocation(0, 0);
        button2.setLocation(0, 180);
        button3.setLocation(0, 360);
        button4.setLocation(0, 540);
        
        Font font = new Font("標楷體", Font.BOLD, 25);
        button1.setFont(font);
        button2.setFont(font);
        button3.setFont(font);
        button4.setFont(font);
        
        //button1.addActionListener(Page1);
        //button2.addActionListener(Page2);
        //button3.addActionListener(Page3);
        //button4.addActionListener(Page4);
        
        button1.setBackground(Color.decode("#484891"));
        button1.setForeground(Color.white);
        button2.setBackground(Color.decode("#484891"));
        button2.setForeground(Color.white);
        button3.setBackground(Color.decode("#484891"));
        button3.setForeground(Color.white);
        button4.setBackground(Color.decode("#484891"));
        button4.setForeground(Color.white);
        
        JTextField textField_p0 = new JTextField();
        JLabel lblNewLabel_p0 = new JLabel("請輸入使用者名稱", Label.RIGHT);
    	JButton p0_confirm = new JButton("確定");
    	frame.add(lblNewLabel_p0);
    	frame.add(textField_p0);
    	frame.add(p0_confirm);
    	
    	textField_p0.setColumns(10);
    	textField_p0.setSize(200, 30);
    	textField_p0.setLocation(950, 0);
    	
    	Font font_text = new Font("標楷體", Font.PLAIN, 15);
    	lblNewLabel_p0.setBounds(820, 0, 200, 30);
    	lblNewLabel_p0.setFont(font_text);
    	
    	p0_confirm.setSize(100, 28);
    	p0_confirm.setLocation(1150, 0);
    	p0_confirm.setFont(font_text);
    	
    	p0_confirm.addActionListener(new ActionListener() {
    		@Override
            public void actionPerformed(ActionEvent e) {
    			username = textField_p0.getText();
    			lblNewLabel_p0.setText("您好，" + username);
    			textField_p0.setVisible(false);
    			p0_confirm.setVisible(false);
    			lblNewLabel_p0.setBounds(1100, 0, 150, 30);
            }
    	});

    	Font font_content = new Font("標楷體", Font.BOLD, 20);
    	JButton bu1 = new JButton("尋找附近使用者");
    	frame.add(bu1);
    	bu1.setLocation(200, 270);
    	bu1.setSize(200, 200);
    	bu1.setBackground(Color.decode("#D94600"));
        bu1.setForeground(Color.white);
    	bu1.setVisible(false);
    	bu1.setFont(font_content);
    	
    	JButton bu1_1 = new JButton();
    	frame.add(bu1_1);
    	bu1_1.setSize(200, 200);
    	bu1_1.setBackground(Color.decode("#F28500"));
        bu1_1.setForeground(Color.white);
    	bu1_1.setVisible(false);
    	bu1_1.setFont(font_content);
    	
    	JButton bu1_2 = new JButton();
    	frame.add(bu1_2);
    	bu1_2.setSize(200, 200);
    	bu1_2.setBackground(Color.decode("#F28500"));
        bu1_2.setForeground(Color.white);
    	bu1_2.setVisible(false);
    	bu1_2.setFont(font_content);
    	
    	JButton bu1_3 = new JButton();
    	frame.add(bu1_3);
    	bu1_3.setSize(200, 200);
    	bu1_3.setBackground(Color.decode("#F28500"));
        bu1_3.setForeground(Color.white);
    	bu1_3.setVisible(false);
    	bu1_3.setFont(font_content);
    	
    	JButton bu1_4 = new JButton();
    	frame.add(bu1_4);
    	bu1_4.setSize(200, 200);
    	bu1_4.setBackground(Color.decode("#F28500"));
        bu1_4.setForeground(Color.white);
    	bu1_4.setVisible(false);
    	bu1_4.setFont(font_content);
    	
    	JButton bu1_5 = new JButton();
    	frame.add(bu1_5);
    	bu1_5.setSize(200, 200);
    	bu1_5.setBackground(Color.decode("#F28500"));
        bu1_5.setForeground(Color.white);
    	bu1_5.setVisible(false);
    	bu1_5.setFont(font_content);
    	
    	JLabel la2 = new JLabel("檔案接收者為...", Label.RIGHT);
    	la2.setBounds(350, 100, 200, 30);
    	la2.setFont(font_content);
    	la2.setVisible(false);
    	frame.add(la2);
    	
    	JButton bu2 = new JButton("確定");
    	frame.add(bu2);
    	bu2.setLocation(650, 80);
    	bu2.setSize(90, 60);
    	bu2.setBackground(Color.decode("#D94600"));
        bu2.setForeground(Color.white);
    	bu2.setVisible(false);
    	bu2.setFont(font_content);
    	
    	JButton bu4 = new JButton("測試網速");
    	frame.add(bu4);
    	bu4.setLocation(300, 80);
    	bu4.setSize(200, 60);
    	bu4.setBackground(Color.decode("#D94600"));
        bu4.setForeground(Color.white);
    	bu4.setVisible(false);
    	bu4.setFont(font_content);
    	
    	JLabel la4 = new JLabel("結果：", Label.RIGHT);
    	la4.setBounds(350, 200, 200, 30);
    	la4.setFont(font_content);
    	la4.setVisible(false);
    	frame.add(la4);
    	
    	button1.addActionListener(new ActionListener() {
    		@Override
            public void actionPerformed(ActionEvent e) {
                bu1.setVisible(true);
                bu1_1.setVisible(false);
    			bu1_2.setVisible(false);
    			bu1_3.setVisible(false);
    			bu1_4.setVisible(false);
    			bu1_5.setVisible(false);
    			
                bu1.addActionListener(new ActionListener() {
            		@Override
                    public void actionPerformed(ActionEvent e) {
            			bu1_1.setLocation(500, 60);
            			bu1_2.setLocation(800, 60);
            			bu1_3.setLocation(650, 280);
            			bu1_4.setLocation(500, 500);
            			bu1_5.setLocation(800, 500);
            			bu1_1.setVisible(true);
            			bu1_2.setVisible(true);
            			bu1_3.setVisible(true);
            			bu1_4.setVisible(true);
            			bu1_5.setVisible(true);
            			
            			neighbors = NeighborDiscovery.getNeighbors();
            			for (UserInfo neighbor : neighbors) {
            				bu1_1.setText(neighbor.getHostAddr());
            			}
            			
            			
                    }
            	});
                
                bu1_1.addActionListener(new ActionListener() {
            		@Override
                    public void actionPerformed(ActionEvent e) {
            			String sendFile = "D:\\Desktop\\code.txt";
            			String ipAddr = bu1_1.getText();
            			
            			if (ipAddr.length() > 0) {
            				Client client = new Client();
                			if(client.connect(ipAddr))
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
            			}
            			
            			
            			
                    }
            	});
                
                bu2.setVisible(false);
                la2.setVisible(false);
                bu4.setVisible(false);
                la4.setVisible(false);
            }
    	});
    	
    	
    	button2.addActionListener(new ActionListener() {
    		@Override
            public void actionPerformed(ActionEvent e) {
    			bu2.setVisible(true);
                la2.setVisible(true);
                bu1_1.setLocation(230, 150);
                bu1_2.setLocation(430, 150);
                bu1_3.setLocation(630, 150);
                bu1_4.setLocation(830, 150);
                bu1_5.setLocation(1030, 150);
                bu1_1.setVisible(true);
    			bu1_2.setVisible(true);
    			bu1_3.setVisible(true);
    			bu1_4.setVisible(true);
    			bu1_5.setVisible(true);
                
                bu1.setVisible(false);
                
                bu4.setVisible(false);
                la4.setVisible(false);
            }
    	});
    	
    	button4.addActionListener(new ActionListener() {
    		@Override
            public void actionPerformed(ActionEvent e) {
    			bu4.setVisible(true);
    			la4.setVisible(true);
                System.out.println("vvv");
                bu1.setVisible(false);
                bu1_1.setVisible(false);
    			bu1_2.setVisible(false);
    			bu1_3.setVisible(false);
    			bu1_4.setVisible(false);
    			bu1_5.setVisible(false);
    			bu2.setVisible(false);
                la2.setVisible(false);
            }
    	});
    	
    }
}

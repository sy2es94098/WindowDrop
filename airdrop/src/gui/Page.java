package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Page extends JPanel implements ActionListener{
	
	//private JPanel jp = new JPanel();
	
	JFrame frame1 = new JFrame();
	
	public void actionPerformed(ActionEvent event){
		
		//JFrame frame1 = new JFrame();
	    	frame1.setSize(1280, 765);
	        frame1.setLocationRelativeTo(null);
	        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame1.setVisible(true);
	        frame1.getContentPane().setLayout(null);
	     
	    String cmd = event.getActionCommand();
	    
	    if (cmd.equals("��L�ϥΪ�"))
	    {
	    	
	        
	    	JButton bu1 = new JButton("ans");
	    	bu1.setSize(180, 180);
	    	
	    	frame1.add(bu1);
	    	bu1.setLocation(500, 250);
	    	bu1.setSize(200, 200);

	    	System.out.println("1");
	    }
	    else if (cmd.equals("�ǰe�ɮ�"))
	    {
	    	System.out.println("2");
	    }
	    else if (cmd.equals("��ѫ�"))
	    {
	    	System.out.println("3");
	    }
	    else if (cmd.equals("���պ��t"))
	    {
	    	System.out.println("4");
	    }
	    /*
	    else if (cmd.equals("�T�w"))
	    {
	  	   username = textField_p0.getText();
	  	   lblNewLabel_p0.setText("�z�n�A" + username);
	    }
	    */
	    
	}
}

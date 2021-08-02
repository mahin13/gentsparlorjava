package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import Repository.*;
import Entity.*;
public class SecondFrame extends JFrame implements ActionListener
{
	JLabel imgLabel;
	JButton loutBtn,Wbtn, Mbtn, btnService,btnProduct;
	JPanel panel;
	ImageIcon img1;
	Font myFont6,myFont7,myFont8,myFont9;
	
	User user;
	
	public SecondFrame(User user)
	{
		super("Home Page");
		this.setSize(1800, 1500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		this.user = user;
		
		
		panel = new JPanel();
		panel.setLayout(null);
		myFont6 = new Font("Cambria",Font.BOLD, 42);
		myFont7 = new Font("Elephent",Font.BOLD, 42);
		myFont8 = new Font("Arial", Font.BOLD, 42);
		myFont9 = new Font("Elephent", Font.BOLD, 30);
		
	
		
		loutBtn = new JButton("LOGOUT");
		loutBtn.setBounds(1500,80,250,80);
		loutBtn.setBackground(Color.YELLOW);
		loutBtn.setForeground(Color.BLACK);
		loutBtn.setFont(myFont7);
		loutBtn.addActionListener(this);
		panel.add(loutBtn);
		
		Mbtn = new JButton("MANAGER");
		Mbtn.setBounds(680,250,320,80);
		Mbtn.setBackground(Color.GREEN);
		Mbtn.setForeground(Color.WHITE);
		Mbtn.setFont(myFont6);
		Mbtn.addActionListener(this);
		panel.add(Mbtn);
		
		Wbtn = new JButton("WORKER");
		Wbtn.setBounds(680,450,320,80);
		Wbtn.setBackground(Color.CYAN);
		Wbtn.setForeground(Color.WHITE);
		Wbtn.setFont(myFont7);
		Wbtn.addActionListener(this);
		panel.add(Wbtn);
		
		btnProduct = new JButton("Product");
		btnProduct.setBounds(680,650,320,80);
		btnProduct.setBackground(Color.BLUE);
		btnProduct.setForeground(Color.WHITE);
		btnProduct.setFont(myFont7);
		btnProduct.addActionListener(this);
		panel.add(btnProduct);
		
		btnService = new JButton("SERVICE");
		btnService .setBounds(680,850,320,80);
		btnService .setBackground(Color.BLACK);
		btnService .setForeground(Color.WHITE);
		btnService .setFont(myFont7);
		btnService .addActionListener(this);
		panel.add(btnService );
		
		img1 = new ImageIcon("Sbackground.jpg");
		imgLabel = new JLabel(img1);
		imgLabel.setBounds(0, 0, 1800, 1000);
		panel.add(imgLabel);
		
		this.add(panel);
		
				
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(loutBtn.getText().equals(command))
		{
			GentsParlor gp = new GentsParlor();
			gp.setVisible(true);
			this.setVisible(false);
		}
		
		else if(command.equals(Mbtn.getText()))
		{
			if(user.getStatus()==0)
			{
				ManagerFrame mf = new ManagerFrame(user);
				mf.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		
		else if(command.equals(Wbtn.getText()))
		{ if(user.getStatus()==1  || user.getStatus()==0)
			{
				WorkerFrame wf = new WorkerFrame(user);
				wf.setVisible(true);
				this.setVisible(false);
		}}
		else if(command.equals(btnProduct.getText()))
		
			{if(user.getStatus()==1  || user.getStatus()==0){
				ProductFrame pf = new ProductFrame(user);
				pf.setVisible(true);
			this.setVisible(false);}
			}
		
			
		else if(command.equals(btnService.getText()))
		
			{if(user.getStatus()==1  || user.getStatus()==0){
				ServiceFrame sf = new ServiceFrame(user);
				sf.setVisible(true);
			this.setVisible(false);}
			}
		
	}
		
	
}
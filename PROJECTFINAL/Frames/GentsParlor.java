package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Entity.*;
import Repository.*;
public class GentsParlor extends JFrame implements MouseListener, ActionListener
{
	ImageIcon img,icon;
	JLabel userLabel, passLabel, imgLabel;
	JTextField userTF;
	JPasswordField passPF;
	JButton loginBtn, exitBtn,showPassBtn;
	JRadioButton r1, r2, r3;
	JCheckBox c1, c2, c3;
	ButtonGroup bg1;
	JComboBox combo;
	JPanel panel;
	Color myColor;
	Font myFont,myFont2,myFont3,myFont4;
	
	public GentsParlor()
	{
		super("CO3 GENTS PARLOR");
		this.setSize(1800, 1500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		icon=new ImageIcon(getClass().getResource("img2.png"));
		this.setIconImage(icon.getImage());
		
		
		myColor = new Color(200, 230, 140);
		myFont = new Font("Cambria",Font.BOLD, 42);
		myFont2 = new Font("Elephent",Font.BOLD, 42);
		myFont3 = new Font("Arial", Font.BOLD, 42);
		myFont4 = new Font("Elephent", Font.BOLD, 30);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor);
		
		userLabel = new JLabel("User Name : ");
		userLabel.setBounds(570, 615, 380, 70);
		userLabel.setFont(myFont2);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(820, 615, 440, 70);
		userTF.setBackground(Color.BLACK);
		userTF.setForeground(Color.WHITE);
		userTF.setFont(myFont);
		panel.add(userTF);
		
		passLabel = new JLabel("Password : ");
		passLabel.setBounds(570, 725, 380, 70);
		passLabel.setFont(myFont3);
		panel.add(passLabel);
		
		passPF = new JPasswordField();
		passPF.setBounds(820, 725, 440, 70);
		passPF.setBackground(Color.BLACK);
		passPF.setForeground(Color.WHITE);
		passPF.setFont(myFont);
		panel.add(passPF);
		
		showPassBtn = new JButton("Show");
		showPassBtn.setBounds(1280,725,120,70);
		showPassBtn.setBackground(Color.BLACK);
		showPassBtn.setForeground(Color.WHITE);
		showPassBtn.setFont(myFont4);
		showPassBtn.addMouseListener(this);
		panel.add(showPassBtn);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(820, 845, 200, 80);
		//loginBtn.addMouseListener(this);
		loginBtn.addActionListener(this);
		loginBtn.setBackground(Color.BLUE);
		loginBtn.setFont(myFont3);
		loginBtn.setForeground(Color.WHITE);
		
	
		panel.add(loginBtn);
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(1060, 845, 200, 80);
		exitBtn.setFont(myFont3);
		exitBtn.setForeground(Color.WHITE);
		exitBtn.setBackground(Color.RED);
		exitBtn.addMouseListener(this);
	    exitBtn.addActionListener(this);
		;
		
		panel.add(exitBtn);
		

		img = new ImageIcon("background.jpg");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(0, 0, 1800, 1000);
		panel.add(imgLabel);
		
		this.add(panel);
		
		
}
		public void actionPerformed(ActionEvent ae)
	   {
		String command = ae.getActionCommand();
		
		if(command.equals(loginBtn.getText()))
		{
			UserRepo ur = new UserRepo();
			User user = ur.getUser(userTF.getText(), passPF.getText());
			
			if(user != null)
			{
				if(user.getStatus() == 0 || user.getStatus() == 1)
				{
					SecondFrame sf = new SecondFrame(user);
					sf.setVisible(true);
					this.setVisible(false);
				}
				else if(user.getStatus() == 2)
				{
					
				}
				else{}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Invaild Id or Password");
			}
			
		}
		
		
		else if(exitBtn.getText().equals(command))
		{
			System.exit(0);
		}
		else
		{
			
		}
	}
	
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me)
	{
		passPF.setEchoChar((char)0);
	}
	public void mouseReleased(MouseEvent me)
	{
		passPF.setEchoChar('*');
	}
	public void mouseEntered(MouseEvent men){
		if(men.getSource() == loginBtn)
		{
			loginBtn.setBackground(Color.BLUE);
			loginBtn.setForeground(Color.WHITE);
		}
		else if(men.getSource() == exitBtn)
		{
			exitBtn.setBackground(Color.BLUE);
			exitBtn.setForeground(Color.WHITE);
		}
		else
		{
			
	}}
	public void mouseExited(MouseEvent me){if(me.getSource() == loginBtn)
		{
			loginBtn.setBackground(Color.GREEN);
			loginBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource() == exitBtn)
		{
			exitBtn.setBackground(Color.RED);
			exitBtn.setForeground(Color.BLACK);
		}
		else
		{
			
	}}
	
}
	
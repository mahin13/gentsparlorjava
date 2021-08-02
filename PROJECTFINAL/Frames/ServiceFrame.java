package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


import Repository.*;
import Entity.*;
public class ServiceFrame extends JFrame implements ActionListener
{
	private JLabel imgLabel,imgLabelempIdLabel, empIdLabel,empNameLabel, empDesignationLabel,empDurationLabel;
	private JTextField empIdTF, empNameTF, empDesignationTF,empDurationTF;
	private JPanel panel;
	private JTable empTable;
	private ImageIcon img4;
	private SecondFrame sf;
    private JScrollPane empTableSP;
	private JButton loutBtn,BackBtn,loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn;
	private Font myFont7,myFont8;
	
	private User user;
	private ServiceRepo ser;
	private UserRepo ur;
	
	public ServiceFrame(User user)
	{
		super("SERVICE FRAME");
		this.setSize(1800, 1500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		
		this.user = user;
		
		ser = new ServiceRepo();
		ur = new UserRepo();
		panel = new JPanel();
		panel.setLayout(null);
		
		
		String data[][] = {{"", "", "", ""}};
		
		String head[] = {"serviceId", "sname", "sprice", "serviceDuration"};
		myFont7 = new Font("Elephent",Font.BOLD, 42);
        myFont8 = new Font("Cambria",Font.BOLD, 32);

        empTable = new JTable(data,head);
		empTableSP = new JScrollPane(empTable);
		empTableSP.setBounds(700, 100, 750, 550);
		empTable.setEnabled(false);
		panel.add(empTableSP);		
		loutBtn = new JButton("LOGOUT");
		loutBtn.setBounds(1500,80,250,80);
		loutBtn.setBackground(Color.YELLOW);
		loutBtn.setForeground(Color.BLACK);
		loutBtn.setFont(myFont7);
		loutBtn.addActionListener(this);
		panel.add(loutBtn);
		
		BackBtn = new JButton("BACK");
		BackBtn.setBounds(1500,220,200,70);
		BackBtn.setBackground(Color.YELLOW);
		BackBtn.setForeground(Color.BLACK);
		BackBtn.setFont(myFont7);
		BackBtn.addActionListener(this);
		panel.add(BackBtn);
		
		
		empIdLabel = new JLabel("ID :");
		empIdLabel.setBounds(100,240,200,30);
		empIdLabel.setForeground(Color.BLACK);
		empIdLabel.setFont(myFont7);
		panel.add(empIdLabel);
		
		empIdTF = new JTextField();
		empIdTF.setBounds(320,240,350,70);
        empIdTF.setBackground(Color.BLACK);
		empIdTF.setForeground(Color.WHITE);
		empIdTF.setFont(myFont8);
		panel.add(empIdTF);
		
		empNameLabel = new JLabel("Name :");
		empNameLabel.setBounds(100,350,200,30);
		empNameLabel.setForeground(Color.BLACK);
		empNameLabel.setFont(myFont7);
		panel.add(empNameLabel);
		
		empNameTF = new JTextField();
		empNameTF.setBounds(320,350,350,70);
		empNameTF.setBackground(Color.BLACK);
		empNameTF.setForeground(Color.WHITE);
		empNameTF.setFont(myFont8);
		panel.add(empNameTF);
		
		empDesignationLabel = new JLabel("Price: ");
		empDesignationLabel.setBounds(100,460,250,30);
		empDesignationLabel.setForeground(Color.BLACK);
		empDesignationLabel.setFont(myFont7);
		panel.add(empDesignationLabel);
		
		empDesignationTF = new JTextField();
		empDesignationTF.setBounds(320,460,350,70);
		empDesignationTF.setBackground(Color.BLACK);
		empDesignationTF.setForeground(Color.WHITE);
		empDesignationTF.setFont(myFont8);
		panel.add(empDesignationTF);
		
		
		empDurationLabel = new JLabel("Duration: ");
		empDurationLabel.setBounds(100,570,250,30);
		empDurationLabel.setForeground(Color.BLACK);
		empDurationLabel.setFont(myFont7);
		panel.add(empDurationLabel);
		
		empDurationTF = new JTextField();
		empDurationTF.setBounds(320,570,350,70);
		empDurationTF.setBackground(Color.BLACK);
		empDurationTF.setForeground(Color.WHITE);
		empDurationTF.setFont(myFont8);
		panel.add(empDurationTF);
		
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,700,150,80);
		loadBtn.setBackground(Color.CYAN);
		loadBtn.setForeground(Color.BLACK);
		loadBtn.setFont(myFont8);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.setBounds(300,700,150,80);
		insertBtn.setBackground(Color.GREEN);
		insertBtn.setForeground(Color.BLACK);
		insertBtn.setFont(myFont8);
		insertBtn.addActionListener(this);
		panel.add(insertBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(500,700,150,80);
		updateBtn.setBackground(Color.BLUE);
		updateBtn.setForeground(Color.WHITE);
		updateBtn.setFont(myFont8);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(100,800,150,80);
		deleteBtn.setBackground(Color.ORANGE);
		deleteBtn.setForeground(Color.BLACK);
		deleteBtn.setFont(myFont8);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		panel.add(deleteBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(300,800,150,80);
		refreshBtn.setBackground(Color.ORANGE);
	    refreshBtn.setForeground(Color.BLACK);
		refreshBtn.setFont(myFont8);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(1200,700,200,80);
	    getAllBtn.setBackground(Color.GREEN);
	    getAllBtn.setForeground(Color.WHITE);
		getAllBtn.setFont(myFont8);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		/*img4 = new ImageIcon("SEbackground.jpg");
		imgLabel = new JLabel(img4);
		imgLabel.setBounds(0, 0, 1800, 1000);
		panel.add(imgLabel);*/
		
		this.add(panel);		
		panel.setBackground(Color.PINK);
				
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		if(command.equals(loadBtn.getText()))
		{
			if(!empIdTF.getText().equals("") || !empIdTF.getText().equals(null))
			{
				Service e = ser.searchService(empIdTF.getText());
				if(e!= null)
				{
					empNameTF.setText(e.getsname());
					empDesignationTF.setText(e.getPrice()+"");
					empDurationTF.setText(e.getServiceDuration()+"");
					
					empIdTF.setEnabled(false);
					empNameTF.setEnabled(true);
					empDesignationTF.setEnabled(true);
					empDurationTF.setEnabled(true);
					
					updateBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		else if(command.equals(insertBtn.getText()))
		{
			Service s = new Service();
			User u = new User();
			
			
			s.setServiceId(empIdTF.getText());
			s.setName(empNameTF.getText());
			s.setPrice(Double.parseDouble(empDesignationTF.getText()));
			s.setServiceDuration(Double.parseDouble(empDurationTF.getText()));
			
			u.setUserId(empIdTF.getText());
		
			if(((empDesignationTF.getText()).equals("Service")) || ((empDesignationTF.getText()).equals("service")))
			{
				u.setStatus(0);
			}
			else
			{
				u.setStatus(1);
			}
			
			ser.insertInDB(s);
			ur.insertUser(u);
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+empIdTF.getText()+"");
			
			empIdTF.setText("");
			empNameTF.setText("");
			empDesignationTF.setText("");
			empDurationTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		else if(command.equals(refreshBtn.getText()))
		{
			empIdTF.setText("");
			empNameTF.setText("");
			empDesignationTF.setText("");
			empDurationTF.setText("");
			
			empIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			Service e = new Service();
			
			e.setServiceId(empIdTF.getText());
			e.setName(empNameTF.getText());
			e.setPrice(Double.parseDouble(empDesignationTF.getText()));
			e.setServiceDuration(Double.parseDouble(empDurationTF.getText()));
			
			ser.updateInDB(e);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			empIdTF.setText("");
			empNameTF.setText("");
			empDesignationTF.setText("");
			empDurationTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			empIdTF.setEnabled(true);
			empNameTF.setEnabled(true);
			empDesignationTF.setEnabled(true);
			empDurationTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			ser.deleteFromDB(empIdTF.getText());
			ur.deleteUser(empIdTF.getText());
		
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			empIdTF.setText("");
			empNameTF.setText("");
			empDesignationTF.setText("");
			empDurationTF.setText("");
			
			empIdTF.setEnabled(true);
			empNameTF.setEnabled(true);
			empDesignationTF.setEnabled(true);
			empDurationTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = ser.getAllService();
			String head[] = {"serviceId", "sname", "sprice", "serviceDuration"};
			
			panel.remove(empTableSP);
			
			empTable = new JTable(data,head);
			empTable.setEnabled(false);
			empTableSP = new JScrollPane(empTable);
			empTableSP.setBounds(700, 100, 750, 550);
			panel.add(empTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		
		
		else if(loutBtn.getText().equals(command))
		{
			GentsParlor gp = new GentsParlor();
			gp.setVisible(true);
			this.setVisible(false);
		}
		else if(BackBtn.getText().equals(command))
		{
			SecondFrame sf = new SecondFrame(user);
			sf.setVisible(true);
			this.setVisible(false);
		}
		
		else
		{
			
		}
	}
		
	
}
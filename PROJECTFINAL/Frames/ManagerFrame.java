package Frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import Repository.*;
import Entity.*;
public class ManagerFrame extends JFrame implements ActionListener
{
	private JLabel imgLabel,imgLabelempIdLabel, empIdLabel,empNameLabel, empDesignationLabel, empSalaryLabel;
	private JTextField empIdTF, empNameTF, empDesignationTF, empSalaryTF;
	private JPanel panel;
	private JTable empTable;
	private JScrollPane empTableSP;
	private ImageIcon img3;
	private SecondFrame sf;
	private JButton loutBtn,BackBtn,loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn;
	private Font myFont7,myFont8;


	private User user;
	private ManagerRepo mr;
	private UserRepo ur;
	public ManagerFrame(User user)
	{
		super("WORKER FRAME");
		this.setSize(1800, 1500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		mr = new ManagerRepo();
		ur = new UserRepo();
		panel = new JPanel();
		panel.setLayout(null);
		
		
		String data[][] = {{"", "", "", ""}};
		
		String head[] = {"Id", "Name", "Designation", "Salary"};
		
		myFont7 = new Font("Elephent",Font.BOLD, 42);	
		myFont8 = new Font("Cambria",Font.BOLD, 32);
		
		img3 = new ImageIcon("Mbackground.jpg");
		imgLabel = new JLabel(img3);
		imgLabel.setBounds(0, 0, 1800, 1000);
		panel.add(imgLabel);
		
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
		empIdLabel.setBounds(100,200,100,30);
		empIdLabel.setForeground(Color.BLACK);
		empIdLabel.setFont(myFont8);
		panel.add(empIdLabel);
		
		empIdTF = new JTextField();
		empIdTF.setBounds(320,200,300,50);
		empIdTF.setFont(myFont7);
		panel.add(empIdTF);
		
		empNameLabel = new JLabel("Name :");
		empNameLabel.setBounds(100,300,100,30);
		empNameLabel.setForeground(Color.BLACK);
		empNameLabel.setFont(myFont8);
		panel.add(empNameLabel);
		
		empNameTF = new JTextField();
		empNameTF.setBounds(320,300,300,50);
		empNameTF.setFont(myFont7);
		panel.add(empNameTF);
		
		empDesignationLabel = new JLabel("Designation: ");
		empDesignationLabel.setBounds(100,400,200,30);
		empDesignationLabel.setForeground(Color.BLACK);
		empDesignationLabel.setFont(myFont8);
		panel.add(empDesignationLabel);
		
		empDesignationTF = new JTextField();
		empDesignationTF.setBounds(320,400,300,50);
		empDesignationTF.setFont(myFont7);
		panel.add(empDesignationTF);
		
		empSalaryLabel = new JLabel("Salary: ");
		empSalaryLabel.setBounds(100,500,200,40);
		empSalaryLabel.setForeground(Color.BLACK);
		empSalaryLabel.setFont(myFont8);
		panel.add(empSalaryLabel);
		
		empSalaryTF = new JTextField();
		empSalaryTF.setBounds(320,500,300,50);
		empSalaryTF.setFont(myFont7);
		panel.add(empSalaryTF);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,700,150,80);
		loadBtn.setBackground(Color.CYAN);
		loadBtn.setForeground(Color.BLACK);
		loadBtn.setFont(myFont8);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.setBounds(300,700,150,80);
		insertBtn.setBackground(Color.PINK);
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
		deleteBtn.setBackground(Color.RED);
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
		
		
		
		
		this.add(panel);		
				
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loadBtn.getText()))
		{
			if(!empIdTF.getText().equals("") || !empIdTF.getText().equals(null))
			{
				Manager m = mr.searchManager(empIdTF.getText());
				if(m!= null)
				{
					empNameTF.setText(m.getMName());
					empDesignationTF.setText(m.getMdesignation());
					empSalaryTF.setText(m.getMSalary()+"");
					
					empIdTF.setEnabled(false);
					empNameTF.setEnabled(true);
					empDesignationTF.setEnabled(true);
					empSalaryTF.setEnabled(true);
					
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
			Manager m = new Manager();
			User u = new User();
			Random rd = new Random();
			int x = rd.nextInt(9999999)+10000000;
			
			m.setMID(empIdTF.getText());
			m.setMName(empNameTF.getText());
			m.setMdesignation(empDesignationTF.getText());
			m.setMSalary(Double.parseDouble(empSalaryTF.getText()));
			
			u.setUserId(empIdTF.getText());
			u.setPassword(x+"");
			
			if(((empDesignationTF.getText()).equals("Manager")) || ((empDesignationTF.getText()).equals("Manager")))
			{
				u.setStatus(0);
			}
			else
			{
				u.setStatus(1);
			}
			
			mr.insertInDB(m);
			ur.insertUser(u);
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+empIdTF.getText()+"and Password: "+x);
			
			empIdTF.setText("");
			empNameTF.setText("");
			empDesignationTF.setText("");
			empSalaryTF.setText("");
			
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
			empSalaryTF.setText("");
			
			empIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			Manager e = new Manager();
			
			e.setMID(empIdTF.getText());
			e.setMName(empNameTF.getText());
			e.setMdesignation(empDesignationTF.getText());
			e.setMSalary(Double.parseDouble(empSalaryTF.getText()));
			
			mr.updateInDB(e);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			empIdTF.setText("");
			empNameTF.setText("");
			empDesignationTF.setText("");
			empSalaryTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			empIdTF.setEnabled(true);
			empNameTF.setEnabled(true);
			empDesignationTF.setEnabled(true);
			empSalaryTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			mr.deleteFromDB(empIdTF.getText());
			ur.deleteUser(empIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			empIdTF.setText("");
			empNameTF.setText("");
			empDesignationTF.setText("");
			empSalaryTF.setText("");
			
			empIdTF.setEnabled(true);
			empNameTF.setEnabled(true);
			empDesignationTF.setEnabled(true);
			empSalaryTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = mr.getAllManager();
			String head[] = {"mid", "mname", "designation", "msalary"};
			
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
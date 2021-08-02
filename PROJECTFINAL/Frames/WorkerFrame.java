package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Repository.*;
import Entity.*;

public class WorkerFrame extends JFrame implements ActionListener
{
	private JLabel imgLabel,imgLabelempIdLabel, empIdLabel,empNameLabel, empDesignationLabel, empSalaryLabel;
	private JTextField empIdTF, empNameTF, empDesignationTF, empSalaryTF;
	private JPanel panel;
	private JButton loutBtn,BackBtn,loadBtn,refreshBtn, getAllBtn;
	private ImageIcon img2;
	private JTable empTable;
	private JScrollPane empTableSP;
	private SecondFrame sf;
	private Font myFont8,myFont7;
	private User user;
	private WorkerRepo wr;
	private UserRepo ur;
	
	public WorkerFrame(User user)
	{
		super("WORKER FRAME");
		this.setSize(1800, 1500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.user = user;
		wr = new WorkerRepo();
		ur = new UserRepo();
		panel = new JPanel();
		panel.setLayout(null);
		String data[][] = {{"", "", "", "",""}};
		
		String head[] = {"Id", "Name", "Designation", "Salary","ServiceDuration"};
		myFont7 = new Font("Arial",Font.BOLD, 32);	
		myFont8 = new Font("Elephent",Font.BOLD, 42);	
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
		
		empTable = new JTable(data,head);
		empTableSP = new JScrollPane(empTable);
		empTableSP.setBounds(700, 100, 750, 550);
		empTable.setEnabled(false);
		panel.add(empTableSP);
		
		empIdLabel = new JLabel("ID :");
		empIdLabel.setBounds(50,200,100,30);
		empIdLabel.setForeground(Color.BLACK);
		empIdLabel.setFont(myFont8);
		panel.add(empIdLabel);
		
		empIdTF = new JTextField();
		empIdTF.setBounds(320,200,300,50);
		empIdTF.setFont(myFont7);
		empIdTF.setBackground(Color.BLACK);
		empIdTF.setForeground(Color.WHITE);
		panel.add(empIdTF);
		
		empNameLabel = new JLabel("Name :");
		empNameLabel.setBounds(50,300,150,50);
		empNameLabel.setForeground(Color.BLACK);
		empNameLabel.setFont(myFont8);
		panel.add(empNameLabel);
		
		empNameTF = new JTextField();
		empNameTF.setBounds(320,300,300,50);
		empNameTF.setFont(myFont7);
	    empNameTF.setBackground(Color.BLACK);
		empNameTF.setForeground(Color.WHITE);
		panel.add(empNameTF);
		
		empDesignationLabel = new JLabel("Designation: ");
		empDesignationLabel.setBounds(50,400,280,50);
		empDesignationLabel.setForeground(Color.BLACK);
		empDesignationLabel.setFont(myFont8);
		panel.add(empDesignationLabel);
		
		empDesignationTF = new JTextField();
		empDesignationTF.setBounds(320,400,300,50);
		empDesignationTF.setFont(myFont7);
		empDesignationTF.setBackground(Color.BLACK);
		empDesignationTF.setForeground(Color.WHITE);
		panel.add(empDesignationTF);
		
		empSalaryLabel = new JLabel("Salary: ");
		empSalaryLabel.setBounds(50,500,200,50);
		empSalaryLabel.setForeground(Color.BLACK);
		empSalaryLabel.setFont(myFont8);
		panel.add(empSalaryLabel);
		
		empSalaryTF = new JTextField();
		empSalaryTF.setBounds(320,500,300,50);
		empSalaryTF.setBackground(Color.BLACK);
		empSalaryTF.setForeground(Color.WHITE);
		empSalaryTF.setFont(myFont7);
		panel.add(empSalaryTF);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,700,150,80);
		loadBtn.setBackground(Color.CYAN);
		loadBtn.setForeground(Color.BLACK);
		loadBtn.setFont(myFont8);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(300,700,200,80);
		refreshBtn.setBackground(Color.ORANGE);
	    refreshBtn.setForeground(Color.BLACK);
		refreshBtn.setFont(myFont8);
		refreshBtn.addActionListener(this);
		panel.add(refreshBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(1200,700,200,80);
	    getAllBtn.setBackground(Color.GREEN);
	    getAllBtn.setForeground(Color.WHITE);
		getAllBtn.setFont(myFont8);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		/*img2 = new ImageIcon("Wbackground.jpg");
		imgLabel = new JLabel(img2);
		imgLabel.setBounds(0, 0, 1800, 1000);
		panel.add(imgLabel);*/
		
		this.add(panel);		
				
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		
		
		if(command.equals(loadBtn.getText()))
		{
			if(!empIdTF.getText().equals("") || !empIdTF.getText().equals(null))
			{
				Workers e = wr.searchWorker(empIdTF.getText());
				if(e!= null)
				{
					empNameTF.setText(e.getWName());
					empDesignationTF.setText(e.getWdesignation());
					empSalaryTF.setText(e.getWSalary()+"");
					
					empIdTF.setEnabled(false);
					empNameTF.setEnabled(true);
					empDesignationTF.setEnabled(true);
					empSalaryTF.setEnabled(true);
					
				
					refreshBtn.setEnabled(true);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
	
		
		else if(command.equals(refreshBtn.getText()))
		{
			empIdTF.setText("");
			empNameTF.setText("");
			empDesignationTF.setText("");
			empSalaryTF.setText("");
			
			empIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = wr.getAllWorkers();
			String head[] = {"workerId", "wname", "wesignation", "wsalary"};
			
			panel.remove(empTableSP);
			
			empTable = new JTable(data,head);
			empTable.setEnabled(false);
			empTableSP = new JScrollPane(empTable);
			empTableSP.setBounds(700, 100, 750, 550);
			panel.add(empTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
	
		
		else if(loadBtn.getText().equals(command))
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
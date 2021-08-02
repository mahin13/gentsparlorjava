package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Repository.*;
import Entity.*;

public class ProductFrame extends JFrame implements ActionListener
{
	private JLabel imgLabel,imgLabelempIdLabel, empIdLabel,empNameLabel, empDesignationLabel,empCountLabel;
	private JTextField empIdTF, empNameTF, empDesignationTF,empCountTF;
	private JPanel panel;
	private JTable empTable;
	private JScrollPane empTableSP;
	private JButton loutBtn,BackBtn,loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn;
	private ImageIcon img5;
	private SecondFrame sf;
	private Font myFont7,myFont8;
	
	private User user;
	private ProductRepo pr;
	private UserRepo ur;
	
	public ProductFrame(User user)
	{
		super("Product FRAME");
		this.setSize(1800, 1500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.user = user;
	    pr = new ProductRepo();
		ur = new UserRepo();
		panel = new JPanel();
		panel.setLayout(null);
		String data[][] = {{"", "", "", ""}};
		
		String head[] = {"productId", "pname", "count", "price"};
		
		myFont7 = new Font("Elephent",Font.BOLD, 42);
	    myFont8 = new Font("Cambria",Font.BOLD, 32);		
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
		empIdLabel.setBounds(100,160,200,30);
		empIdLabel.setForeground(Color.BLACK);
		empIdLabel.setFont(myFont7);
		panel.add(empIdLabel);
		
		empIdTF = new JTextField();
		empIdTF.setBounds(320,180,350,70);
		empIdTF.setFont(myFont8);
		panel.add(empIdTF);
		
		empNameLabel = new JLabel("Name :");
		empNameLabel.setBounds(100,290,200,30);
		empNameLabel.setForeground(Color.BLACK);
		empNameLabel.setFont(myFont7);
		panel.add(empNameLabel);
		
		empNameTF = new JTextField();
		empNameTF.setBounds(320,280,350,70);
		empNameTF.setFont(myFont8);
		panel.add(empNameTF);
		
		empCountLabel = new JLabel("Count :");
		empCountLabel.setBounds(100,400,200,30);
		empCountLabel.setForeground(Color.BLACK);
		empCountLabel.setFont(myFont7);
		panel.add(empCountLabel);
		
		empCountTF = new JTextField();
		empCountTF.setBounds(320,380,350,70);
		empCountTF.setFont(myFont8);
		panel.add(empCountTF);
		
		empDesignationLabel = new JLabel("Price: ");
		empDesignationLabel.setBounds(100,500,250,30);
		empDesignationLabel.setForeground(Color.BLACK);
		empDesignationLabel.setFont(myFont7);
		panel.add(empDesignationLabel);
		
		empDesignationTF = new JTextField();
		empDesignationTF.setBounds(320,480,350,70);
		empDesignationTF.setFont(myFont8);
		panel.add(empDesignationTF);
		
		
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
		
		
		/*img5 = new ImageIcon("Pbackground.jpg");
		imgLabel = new JLabel(img5);
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
				Product e = pr.searchProduct(empIdTF.getText());
				if(e!= null)
				{
					empNameTF.setText(e.getName());
					empCountTF.setText(e.getCount()+"");
					empDesignationTF.setText(e.getPrice()+"");
					
					empIdTF.setEnabled(false);
					empNameTF.setEnabled(true);
					empCountTF.setEnabled(true);
					empDesignationTF.setEnabled(true);
					
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
			Product p = new Product();
			User u = new User();
			
			
			p.setProductId(empIdTF.getText());
			p.setName(empNameTF.getText());
			p.setCount(Double.parseDouble(empCountTF.getText()));
			p.setPrice(Double.parseDouble(empDesignationTF.getText()));
			
		
			
			
			
			pr.insertInDB(p);
			ur.insertUser(u);
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+empIdTF.getText()+"");
			
			empIdTF.setText("");
			empNameTF.setText("");
			empCountTF.setText("");
			empDesignationTF.setText("");
			
			
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
			empCountTF.setText("");
			
			empIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			Product e = new Product();
			
			e.setProductId(empIdTF.getText());
			e.setName(empNameTF.getText());
			e.setCount(Double.parseDouble(empDesignationTF.getText()));
			e.setPrice(Double.parseDouble(empCountTF.getText()));
			
			pr.updateInDB(e);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			empIdTF.setText("");
			empNameTF.setText("");
			empDesignationTF.setText("");
			empCountTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			empIdTF.setEnabled(true);
			empNameTF.setEnabled(true);
			empDesignationTF.setEnabled(true);
			empCountTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			pr.deleteFromDB(empIdTF.getText());
			ur.deleteUser(empIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			empIdTF.setText("");
			empNameTF.setText("");
			empCountTF.setText("");
			empDesignationTF.setText("");
			
			
			empIdTF.setEnabled(true);
			empNameTF.setEnabled(true);
			empCountTF.setEnabled(true);
			empDesignationTF.setEnabled(true);
			
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = pr.getAllProduct();
			String head[] = {"productId", "pname", "count", "price"};
			
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
package Entity;

import java.lang.*;


public class Manager
{   private String mid;
	private String mname;
	private String designation;
    private double msalary;
	
	public Manager()
	{
		System.out.println("Empty M");
	}
	public Manager(String mid,String mname,String designation,double msalary)
	{
		this.mid = mid;
		this.mname = mname;
		this.designation = designation;
		this.msalary = msalary;
	}
	public void setMID(String mid){this.mid=mid;}
	public void setMName(String mname)
	{
		this.mname = mname;
	}
	public void setMdesignation(String designation){this.designation = designation;}
	public void setMSalary(double msalary)
	{
	this.msalary = msalary;	
	}
	public String getMID(){return mid;}
	public String getMName(){return mname;}
	public String getMdesignation(){return designation;}
	public double getMSalary(){return msalary;}
	
	
}
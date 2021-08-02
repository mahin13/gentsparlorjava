package Entity;

import java.lang.*;


public class Workers 
{
	private String workerId;
	private String wname;
	private String wdesignation;
	private double wsalary;

	
	

	
	public Workers()
	{
		System.out.println("Empty W");
	}
	public Workers(String workerId,String wname,String wdesignation,double wsalary)
	{
		this.workerId = workerId;
		this.wname = wname;
		this.wdesignation = wdesignation;
		this.wsalary = wsalary;
	
	}
	
	
	public void setWorkerId(String workerId)
	{
		this.workerId = workerId;
	}
	
	

	public void setWName(String wname)
	{
		this.wname = wname;
	}
	public void setWdesignation(String wdesignation){this.wdesignation = wdesignation;}
	public void setWSalary(double wsalary)
	{
	this.wsalary = wsalary;	
	}
	
	
	public String getWorkerId(){return workerId;}
	public String getWName(){return wname;}
	public String getWdesignation(){return wdesignation;}
	public double getWSalary(){return wsalary;}




}
package Entity;

import java.lang.*;


public class Service
{
	private String serviceId;
	private String sname;
	private double sprice;
	private double serviceDuration;
	
	public Service()
	{
		System.out.println("Empty S");
	}
	public Service(String serviceId,String sname,double sprice,double serviceDuration)
	{
		this.serviceId = serviceId;
		this.sname = sname;
		this.sprice = sprice;
		this.serviceDuration = serviceDuration;
		
	}
	
	public void setServiceId(String serviceId)
	{
		this.serviceId = serviceId;
	}
	public void setName(String sname)
	{
		this.sname = sname;
	}
	public void setPrice(double sprice)
	{
		this.sprice = sprice;
	}
	public void setServiceDuration(double serviceDuration)
	{
		this.serviceDuration = serviceDuration;
	}
	
	
	
	public String getServiceId(){return serviceId;}
	public String getsname(){return sname;}
	public double getPrice(){return sprice;}
	public double getServiceDuration(){return serviceDuration;}
	
	
}
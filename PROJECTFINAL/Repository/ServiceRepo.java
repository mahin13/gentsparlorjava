package Repository;

import java.lang.*;
import java.util.ArrayList;
import Entity.*;
import Interface.*;

public class ServiceRepo implements IServiceRepo
{
	DatabaseConnection dbc;
	
	public ServiceRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Service se)
	{
		String query = "INSERT INTO service VALUES ('"+se.getServiceId()+"','"+se.getsname()+"','"+se.getPrice()+"',"+se.getServiceDuration()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDB(String serviceId)
	{
		String query = "DELETE from service WHERE serviceId='"+serviceId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateInDB(Service se)
	{
		String query = "UPDATE service SET sname='"+se.getsname()+"',  sprice = "+se.getPrice()+",serviceDuration = "+se.getServiceDuration()+" WHERE serviceId='"+se.getServiceId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Service searchService(String serviceId)
	{
		Service se = null;
		String query = "SELECT `sname`,`sprice`, `serviceduration` FROM `service` WHERE `serviceId`='"+serviceId+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String sname = dbc.result.getString("sname");
				double sprice = dbc.result.getDouble("sprice");
				double serviceDuration = dbc.result.getDouble("serviceDuration");
				
		
				
				
				se = new Service();
			    se.setServiceId(serviceId);
				se.setName(sname);
				se.setPrice(sprice);
				se.setServiceDuration(serviceDuration);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return se;
	}
	public String[][] getAllService()
	{
		ArrayList<Service> ar = new ArrayList<Service>();
		String query = "SELECT * FROM service;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String serviceId = dbc.result.getString("serviceId");
				String sname = dbc.result.getString("sname");
				double sprice = dbc.result.getDouble("sprice");
				double serviceDuration = dbc.result.getDouble("serviceDuration");
				
				Service ser = new Service(serviceId,sname,sprice,serviceDuration);
				ar.add(ser);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][4];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Service)obj[i]).getServiceId();
			data[i][1] = ((Service)obj[i]).getsname();
			data[i][2] = (((Service)obj[i]).getPrice())+"";
			data[i][3] = (((Service)obj[i]).getServiceDuration())+"";
		}
		return data;
	}
}













































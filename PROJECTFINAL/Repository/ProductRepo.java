package Repository;

import java.lang.*;
import java.util.ArrayList;
import Entity.*;
import Interface.*;

public class ProductRepo implements IProductRepo
{
	DatabaseConnection dbc;
	
	public ProductRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Product p)
	{
		String query = "INSERT INTO product VALUES ('"+p.getProductId()+"','"+p.getName()+"','"+p.getCount()+"',"+p.getPrice()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDB(String productId)
	{
		String query = "DELETE from product WHERE productId='"+productId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateInDB(Product p)
	{
		String query = "UPDATE product SET pname='"+p.getName()+"', count = '"+p.getCount()+"', price= "+p.getPrice()+" WHERE productId='"+p.getProductId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Product searchProduct(String productId)
	{
		Product prd = null;
		String query = "SELECT `pname`, `count`, `price` FROM `product` WHERE `productId`='"+productId+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String pname = dbc.result.getString("pname");
				int count = dbc.result.getInt("count");
				double price = dbc.result.getDouble("price");
		
				
				
				prd = new Product();
				prd.setProductId(productId);
				prd.setName(pname);
				prd.setCount(count);
				prd.setPrice(price);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return prd;
	}
	public String[][] getAllProduct()
	{
		ArrayList<Product> ar = new ArrayList<Product>();
		String query = "SELECT * FROM product;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String productId = dbc.result.getString("productId");
				String pname = dbc.result.getString("pname");
				int count = dbc.result.getInt("count");
				double price = dbc.result.getDouble("price");
				
				Product p = new Product(productId,pname,count,price);
				ar.add(p);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][4];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Product)obj[i]).getProductId();
			data[i][1] = ((Product)obj[i]).getName();
			data[i][2] = ((Product)obj[i]).getCount()+"";
			data[i][3] = (((Product)obj[i]).getPrice())+"";
		}
		return data;
	}
}













































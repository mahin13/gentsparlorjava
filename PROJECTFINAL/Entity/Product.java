package Entity;

import java.lang.*;


public class Product
{
	private String productId;
	private String pname;
	private double count;
	private double price;
	
	public Product()
	{
		System.out.println("Empty P");
	}
	public Product(String productId,String pname,double count,double price)
	{
		this.productId = productId;
		this.pname = pname;
		this.count = count;
		this.price = price;
	}
	
	public void setProductId(String productId)
	{
		this.productId = productId;
	}
	
	public void setName(String pname)
	{
		this.pname = pname;
	}
	public void setCount(double count)
	{
		this.count = count;
	}
	public void setPrice(double price)
	{
	    this.price = price;	
	}
	
	public String getProductId(){return productId;}
	public String getName(){return pname;}
	public double getCount(){return count;}
	public double getPrice(){return price;}
	
}
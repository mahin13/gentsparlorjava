package Interface;
import java.lang.*;

import Entity.*;

public interface IProductRepo
{
	public void insertInDB(Product p);
	public void deleteFromDB(String productId);
	public void updateInDB(Product p);
	public Product searchProduct(String productId);
	public String[][] getAllProduct();
}
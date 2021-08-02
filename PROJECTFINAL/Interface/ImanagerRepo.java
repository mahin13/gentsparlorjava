package Interface;
import java.lang.*;

import Entity.*;

public interface ImanagerRepo
{
	public void insertInDB(Manager m);
	public void deleteFromDB(String mid);
	public void updateInDB(Manager m);
	public Manager searchManager(String mid);
	public String[][] getAllManager();
	

}
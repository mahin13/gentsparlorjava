package Interface;
import java.lang.*;

import Entity.*;

public interface IServiceRepo
{
	public void insertInDB(Service se);
	public void deleteFromDB(String serviceId);
	public void updateInDB(Service s);
	public Service searchService(String serviceId);
	public String[][] getAllService();
	
}
package Interface;
import java.lang.*;

import Entity.*;

public interface IWorkerRepo
{
	public Workers searchWorker(String workerId);
	public String[][] getAllWorkers();

}
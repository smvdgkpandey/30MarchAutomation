package GenericUtility;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface PropertyUtility {
	
	
	public String getDataFromProperty(String key) throws FileNotFoundException, IOException;

}

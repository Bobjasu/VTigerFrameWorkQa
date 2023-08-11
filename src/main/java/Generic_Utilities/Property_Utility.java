package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Property_Utility 
{
	/**
	 * this method is used for login to application
	 * @param Key
	 * @return
	 * @throws Throwable
	 * @author utsab
	 */
	public String getkeyValue(String Key) throws Throwable
	{
		FileInputStream fi=new FileInputStream("./src/test/resources/commondata.properties.txt");
		Properties prop=new Properties();
		prop.load(fi);
		String Value = prop.getProperty(Key);
		return Value;
		
	}

}

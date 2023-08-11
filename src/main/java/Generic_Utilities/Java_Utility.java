package Generic_Utilities;

import java.util.Date;
import java.util.Random;

public class Java_Utility {
	/**
	 * this method is used to generate unique value
	 * @return
	 * @author utsab
	 */
	public int getRanDomNum()
	{
		Random ran=new Random();
		int ranNum = ran.nextInt(1000);
		return ranNum;	
	}
	/**
	 * used to get system date and time IST format
	 * @return
	 * @author utsab
	 */
	public String getSystemDateAndTime()
	{
		Date date=new Date();
		return date.toString();
	}
	/**
	 * used to get date in YYYY-MM-DD format
	 * @return
	 * @author utsab
	 */
	public String getSystemDateWithFormat()
	{
		Date date=new Date();
		String dateAndTime = date.toString();
		
		String YYYY = dateAndTime.split("")[5];
		String DD = dateAndTime.split("")[2];
		int MM = date.getMonth()+1;
		
		String finalFormat = YYYY+"-"+MM+"-"+DD;
		return finalFormat;
		
	}

}

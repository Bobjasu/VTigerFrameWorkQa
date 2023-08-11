package Practice;

import org.testng.annotations.Test;



public class TestNGPractice {
	
	    @Test(priority = 1)
		public void createContact()
		{
			System.out.println("created");
			
		}
		
	    @Test (priority = 2)
		public void modifyContact()
		{
			System.out.println("modified");
		}
		
	    @Test(priority=3)
		public void deleteContact()
		{
			System.out.println("deleted");
		}
	}


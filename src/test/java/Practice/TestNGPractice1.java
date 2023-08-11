package Practice;

import org.testng.annotations.Test;

public class TestNGPractice1 {
	@Test(priority = 1)
	public void createContact()
	{
		System.out.println("Contact is created");
		int[] a= {1,2,3};
		System.out.println(a[2]);
	}
	@Test(invocationCount = 2)
	public void modifyContact()
	{
		System.out.println("Contact is modified");
	}
	@Test(dependsOnMethods = "createContact")
	public void deleteContact()
	{
		System.out.println("Contact is deleted");
	}

}

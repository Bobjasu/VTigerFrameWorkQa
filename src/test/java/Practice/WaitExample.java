package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WaitExample {
	public static void main(String[] args) 
	{
		String key="webdriver.chrome.driver";
		String value = "./src/main/resources/chromedriver.exe";
		
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.actitime.com/login.do");
		
		driver.findElement(By.name("username")).sendKeys("admin",Keys.TAB,"manager",Keys.ENTER);
		
	}

}

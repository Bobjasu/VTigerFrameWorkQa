package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXpath {
	public static void main(String[] args) throws Throwable 
	{
	      String key = "webdriver.chrome.driver";
	      String value = "src/main/resources/chromedriver.exe";
	      
	      System.setProperty(key, value);
	      WebDriver driver=new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	      
	      driver.get("https://www.flipkart.com/");
	      driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
	      WebElement Search_tf = driver.findElement(By.xpath("//input[@name='q']"));
	      Search_tf.sendKeys("iphone");
	      Search_tf.sendKeys(Keys.ENTER);
	      WebElement price = driver.findElement(By.xpath("//div[.='APPLE iPhone 14 (Midnight, 128 GB)']/../..//div[@class='_30jeq3 _1_WHN1']"));
	      String cost = price.getText();
	      System.out.println("The Price of the phone is "+cost);
	      
	}


}

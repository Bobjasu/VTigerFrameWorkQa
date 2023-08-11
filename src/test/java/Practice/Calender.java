package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {
	public static void main(String[] args) throws Throwable {
		String key = "webdriver.chrome.driver";
		String value = "src/main/resources/chromedriver.exe";
		
		
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[@class='ic_circularclose_grey']")).click();
		
		
		//from
		String srcCity = "New Delhi, India";
		WebElement src = driver.findElement(By.xpath("//input[@id='fromCity']"));
		src.sendKeys("'"+srcCity+"'");
		driver.findElement(By.xpath("//p[.='"+srcCity+"']")).click();
		
		//To
		String destCity = "Des Moines, United States";
		WebElement dest = driver.findElement(By.xpath("//input[@id='toCity']"));
		dest.sendKeys("'"+destCity+"'");
		driver.findElement(By.xpath("//p[.='"+destCity+"']")).click();
		
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//span[@class='lbl_input latoBold appendBottom10']")).click();
		//Dynamic xpath
		String month = "February 2023";
		String date = "25";
		WebElement departure = driver.findElement(By.xpath("//div[text()='"+month+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']"));
	    departure.click();	
	}

}

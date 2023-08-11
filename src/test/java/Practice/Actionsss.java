package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actionsss {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("");
		WebElement ele = driver.findElement(null);
		
		WebElement src = driver.findElement(null);
		WebElement dest = driver.findElement(null);
		
		//mouseover
		Actions act=new Actions(driver);
		act.moveToElement(ele);
		
		//double click
		act.doubleClick().build().perform();
		
		//rightclick
		act.contextClick().perform();
		
		//drag and drop
		act.dragAndDrop(src, dest);
		
	}

}

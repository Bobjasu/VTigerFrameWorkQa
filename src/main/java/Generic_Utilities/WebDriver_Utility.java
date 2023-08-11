package Generic_Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utility
{
	/**
	 * wait for page to load before idenfying any synchronized element in DOM
	 * @author utsab
	 */
	public void waitForElementInDOM(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	/**
	 * it's an Explicitly wait Always wait for Page to be loaded & available in GUI
	 * @param driver
	 * @param PartailPageURL
	 * @author utsab
	 */
	public void waitForPage(WebDriver driver,String PartailPageURL)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.urlContains(PartailPageURL));
	}
	/**
	 * after every action it will wait for next action to perform
	 * @param driver
	 * @author utsab
	 */
	public void scriptTimeOut(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}
	/**
	 * used to maximize browser
	 * @param driver
	 * @author utsab
	 */
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * used to wait for element to be clickable in GUI and check for specific element for every 500 miliseconds
	 * @param driver
	 * @param Element
	 * @param pollingTime
	 * @author utsab
	 */ 
	public void waitForElementWithCustomTimeOut(WebDriver driver,WebElement Element,int pollingTime)
	{
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}
	/**
	 * used to switch to any Window based on window Title
	 * @param driver
	 * @param PartialWindowTitle
	 */
	public void switchToWindow(WebDriver driver,String PartialWindowTitle)
	{
		Set<String> allId = driver.getWindowHandles();
		Iterator<String> it = allId.iterator();
		while(it.hasNext())
		{
			String wid = it.next();
			driver.switchTo().window(wid);
			if(driver.getTitle().contains(PartialWindowTitle))
			{
				break;
			}	
		}
	}
	/**
	 * used to switch to AlertWindow and Accept(click on ok button)
	 * @param driver
	 * @author utsab
	 */
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	 }
	/**
	 * used to switch to alert window and dismiss(click on cancel button)
	 * @param driver
	 * @author utsab
	 */
	public void swithToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * used to swich to frame window based on Index
	 * @param driver
	 * @param index
	 * @author utsab
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * used to swich to frame window based on text
	 * @param driver
	 * @param id_name_Attribute
	 * @author utsab
	 */
	public void swichToFrame(WebDriver driver,String id_name_Attribute)
	{
		driver.switchTo().frame(id_name_Attribute);
	}
	/**
	 * used to select the value from the dropdown based on index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	 }
	/**
	 * used to select the value from dropdown based on text
	 * @param element
	 * @param text
	 * @author utsab
	 */
	public void select(WebElement element,String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * used to place mouse cursor on specific element
	 * @param driver
	 * @param element
	 * @author utsab
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * used to right click on the element
	 * @param driver
	 * @param element
	 * @author utsab
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * used to double click on element
	 * @param driver
	 * @param element
	 * @author utsab
	 */
	public void doubleClickOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick().build().perform();
	}
	/**
	 * used to drag a element from sourse and drop in destination 
	 * @param driver
	 * @param src
	 * @param dest
	 * @author utsab
	 */
	public void DragAndDropElement(WebDriver driver,WebElement src,WebElement dest)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(src, dest);
	}
	/**
	 * used to move element by giving co-ordinate value
	 * @param driver
	 * @param x
	 * @param y
	 * @author utsab
	 */
	public void moveByOffset(WebDriver driver,int x,int y)
	{
		Actions act=new Actions(driver);
		act.moveByOffset(x, y).click().perform();
	 }
	/**
	 * used to take screenshot
	 * @param driver
	 * @param src
	 * @param dest
	 * @author utsab
	 * @throws Throwable 
	 */
	public void takesScreenshot(WebDriver driver,File dest) throws Throwable
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, dest);
	}

    }

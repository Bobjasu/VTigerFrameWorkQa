package Generic_Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementationClass implements ITestListener {

	WebDriver driver;
	public void onTestFailure(ITestResult result) {
		String testData = result.getMethod().getMethodName();
		
		System.out.println("-----execute---------");
		
        //TakesScreenshot ts=(TakesScreenshot)driver;
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE); 
		File dest=new File("./ScreenShot"+testData+".png");
		
		try {
			FileUtils.copyFile(src, dest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

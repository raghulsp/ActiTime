package generic;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements IAutoConst {
	public WebDriver driver;
	
	static {
		System.setProperty(CHROME_KEY,CHROME_VALUE);
	}
	@BeforeMethod
	public void openApp() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
		driver.get(APP_URL);
	}
	@AfterMethod
//	receiving the status of the last executed test method
	public void closeApp(ITestResult i) {
//		int status=iTestResult.getStatus();
//		String name=iTestResult.getName();
		if(i.getStatus()==1) {
			Reporter.log("Test "+i.getName()+" is PASS",true);
		}
		else {
			Reporter.log("Test "+i.getName()+" is FAIL/SKIP",true);
			AutoLib.getPhoto(driver,IMG_PATH+i.getName()+".png");			
		}
		driver.close();
	}
}
package TestClasses;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ReportWrongInfo.Report;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass1 extends Report{

Report test1=new Report();
@BeforeClass
	public void setup() {
		try {
		DesiredCapabilities cab= new DesiredCapabilities(); 
		cab.setCapability("deviceName", "ASUS_ZENFONE"); 
		cab.setCapability("udid", "J7AAB760J077KYZ"); 
		cab.setCapability("platformName", "Android"); 
		cab.setCapability("platformVersion", "9"); 
		cab.setCapability("appPackage", "com.nobroker.app"); 
		cab.setCapability("automationName", "UiAutomator1"); 
		cab.setCapability("appActivity", "com.nobroker.app.activities.NBSplashScreen"); 
		/*URL url;
		url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cab);
		driver.launchApp();*/
}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}		
@Test
public void testNoBroker() throws InterruptedException
{
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("http://google.com");
	/*
	driver.launchApp();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	System.out.println("Successfully executed");
	test1.wrongInfoReport();*/
}

}

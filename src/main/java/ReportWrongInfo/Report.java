package ReportWrongInfo;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sun.javafx.scene.traversal.Direction;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import javafx.util.Duration;
import sun.java2d.DefaultDisposerRecord;

public class Report {
	 public static AndroidDriver<WebElement> driver;
	 
public void wrongInfoReport() throws InterruptedException{
//WebElement ContinueBtn = driver.findElement(By.id("com.nobroker.app:id/layout1"));

	Thread.sleep(6000);

	driver.navigate().back();
WebElement AllowBtn = driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
//waitForElementLoad("permission_allow_button");
for (int i = 0; i < 3; i++) {
	AllowBtn = driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
 if(AllowBtn.isDisplayed())
	{
		AllowBtn.click();
	}
}
driver.findElement(By.id("com.nobroker.app:id/buyLayoutText")).click();
WebElement searchBtn= driver.findElement(By.id("com.nobroker.app:id/searchEditHome"));
searchBtn.click();
driver.findElement(By.id("com.nobroker.app:id/localityAutoCompleteTxt")).sendKeys("Marathahalli");
waitUntilElementDisappear("com.nobroker.app:id/loading_indicator");
driver.findElement(By.id("com.nobroker.app:id/logo")).click();
driver.findElement(By.id("com.nobroker.app:id/localityAutoCompleteTxt")).click();
driver.findElement(By.id("com.nobroker.app:id/localityAutoCompleteTxt")).sendKeys("HSR Layout");
waitUntilElementDisappear("com.nobroker.app:id/loading_indicator");
driver.findElement(By.id("com.nobroker.app:id/logo")).click();
driver.findElement(By.id("com.nobroker.app:id/nearByRadio")).click();
driver.findElement(By.id("com.nobroker.app:id/bhktwo")).click();
driver.findElement(By.id("com.nobroker.app:id/bhkthree")).click();
driver.findElement(By.id("com.nobroker.app:id/searchProperty")).click();

waitForElementLoad("com.nobroker.app:id/property_cost2");
swipe(Direction.DOWN);
swipe(Direction.DOWN);
driver.findElement(By.id("com.nobroker.app:id/sub_title")).click();

WebElement ele=driver.findElement(By.id("com.nobroker.app:id/tv_report_wrong_info"));
swipeToElement(ele);
ele.click();
login("1237567899", "nobroker123");
List<WebElement> lst= driver.findElements(By.xpath("//android.widget.CheckBox"));
for (int i = 0; i < lst.size(); i++) {
	lst.get(i).click();
}
driver.findElement(By.id("com.nobroker.app:id/btn_report")).click();
WebElement configDropdown = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'3 BHK')]"));
swipeToElement(configDropdown);
configDropdown.click();
driver.findElement(By.xpath("//android.widget.TextView[7]")).click();
driver.findElement(By.id("com.nobroker.app:id/edt_others")).sendKeys("Test");
driver.findElement(By.xpath("com.nobroker.app:id/btn_save")).click();

String expected= driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Thank you')")).getText();

Assert.assertEquals("Thank You for the feedback", expected);
}

public void waitForElementLoad(String Element_id){
	try {
WebDriverWait wait = new WebDriverWait(driver, 30);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Element_id)));
	}catch (Exception e) {
		// TODO: handle exception
	}
}
public void waitUntilElementDisappear(String Element_id)
{
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.ignoring(StaleElementReferenceException.class)
            .ignoring(NoSuchElementException.class)
            .until(ExpectedConditions.invisibilityOfElementLocated(By.id(Element_id)));

}
public void swipe(Direction direction) throws InterruptedException
{
	System.out.println("swipeScreen(): dir: '" + direction + "'");
    final int ANIMATION_TIME = 200;
    final int PRESS_TIME = 201; 
Thread.sleep(5000);
    int edgeBorder = 10; 
    PointOption pointOptionStart, pointOptionEnd;
    Dimension dims = driver.manage().window().getSize();
    pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
	 switch (direction) {
	     case DOWN: // center of footer
         pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
         break;
     case UP: // center of header
         pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
         break;
	 }
}
public void swipeToElement(WebElement ele)
{
	try {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(ele0))");

    } catch (Exception e) {
        System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
        return;
    }
}
public void login(String PhoneNumber, String password)
{
		WebElement phNum = driver.findElement(By.id("com.nobroker.app:id/et_signup_phone"));
		phNum.clear();
		phNum.sendKeys(PhoneNumber);
		waitUntilElementDisappear("android:id/message");
		 driver.findElement(By.id("com.nobroker.app:id/rb_signup_pwd")).click();
		 
		 WebElement pwd= driver.findElement(By.id("com.nobroker.app:id/et_signup_pwd"));
		 pwd.click();
		 pwd.sendKeys(password);
		 driver.navigate().back();
		 driver.findElement(By.id("com.nobroker.app:id/btn_signup")).click();

}
}
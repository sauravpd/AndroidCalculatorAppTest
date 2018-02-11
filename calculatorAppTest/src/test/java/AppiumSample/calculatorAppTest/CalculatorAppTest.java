package AppiumSample.calculatorAppTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
/**
 * Calculator App Test using appium
 * @author Saurav
 *
 */
public class CalculatorAppTest 
{
	public AppiumDriver<MobileElement> driver;
	DesiredCapabilities desiredCapabilities;
	public static Logger LOG = Logger.getLogger(CalculatorAppTest.class);

	@BeforeClass
	public void setUp() throws MalformedURLException 
	{

		LOG.info("setUp");

		PropertyConfigurator.configure(System.getProperty("user.dir") + File.separator + "resources" + File.separator + "log4j.properties");

		desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir") +"/AndroidCalculator.apk");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
	}

	@Test
	public void calculatorTest()
	{
		LOG.info("calculatorTest");

		driver.findElement(By.id("com.android2.calculator3:id/cling_dismiss")).click();
		driver.findElement(By.id("com.android2.calculator3:id/digit2")).click();
		driver.findElement(By.id("com.android2.calculator3:id/plus")).click();
		driver.findElement(By.id("com.android2.calculator3:id/digit4")).click();
		driver.findElement(By.id("com.android2.calculator3:id/equal")).click();
		driver.findElement(By.id("com.android2.calculator3:id/plus")).click();
		driver.findElement(By.id("com.android2.calculator3:id/digit4")).click();
		driver.findElement(By.id("com.android2.calculator3:id/equal")).click();
	}

	@AfterClass
	public void tearDown() 
	{
		LOG.info("tearDown");

		driver.quit();
	}
}

package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;


public class Base {
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver InitializeDriver() throws IOException
	{
 prop=new Properties();
 FileInputStream fis=new FileInputStream("C:\\\\Users\\\\welcome\\\\eclipse-workspace\\\\InsuranceCoverage\\\\src\\\\main\\\\java\\\\resources\\\\Globaldata.properties");
 prop.load(fis);
 String browsername=prop.getProperty("Browser");
  if(browsername.equalsIgnoreCase("chrome"))
 {
	  ChromeOptions Chrome_cap=new ChromeOptions();
	  Chrome_cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	  Chrome_cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
      System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\welcome\\\\Downloads\\\\chromedriver_win32 (2)\\\\chromedriver.exe");
	  driver=new ChromeDriver(Chrome_cap);
	  }
 else if(browsername.equalsIgnoreCase("firefox"))
 {
	 System.setProperty("webdriver.gecko.driver","C:\\Users\\welcome\\Downloads\\geckodriver-v0.21.0-win32\\geckodriver.exe");
	 driver=new FirefoxDriver();
 }
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.manage().window().maximize();	
 return driver;
	}
	public void getScreenshot(String result) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\Users\\welcome\\InsuranceCoverage\\"+result+"Screens.jpg"));
	}
}
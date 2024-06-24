package testBase;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties p;


	@BeforeClass (groups= {"Sanity" , "Regression"})
	@Parameters({"browser","os"})
	public void setup( String br,String os) throws IOException

	{
		//loading properties file
		 FileReader file=new FileReader(".//src//test//resources//config.properties");
		 p=new Properties();
		 p.load(file);


		//loading log4j file
		logger=LogManager.getLogger(this.getClass());//Log4j
         
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities	cap=	new DesiredCapabilities();
			
			
			if(os.equalsIgnoreCase("windows"))
			{
				cap.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				cap.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("No Matching os");
				return;
			}
		
		
		
		switch(br.toLowerCase())
		{
		case "chrome": cap.setBrowserName("chrome"); break;
		case "edge": cap.setBrowserName("MicrosoftEdge"); break;
		default: System.out.println("No matching browser"); return;
		}
  
		
		driver=new RemoteWebDriver(new URL (" http://192.168.1.11:4444/wd/hub"),cap);
		
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
		//launching browser based on condition
		switch(br.toLowerCase())
		{
		case "chrome": driver=new ChromeDriver(); break;
		case "edge": driver=new EdgeDriver(); break;
		default: System.out.println("No matching browser..");
					return;
		}}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
		
	@AfterClass (groups= {"Sanity","Regression"})
	public void tearDown()
	{
		driver.close();
	}
	

	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}

	public String randomAlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(3);
		String num=RandomStringUtils.randomNumeric(3);

		return (str+"@"+num);
	}
	
   public String captureScreen(String tname) throws IOException
   {
	   String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	   
	   TakesScreenshot takesscreenshot =	   (TakesScreenshot) driver;
	File source = takesscreenshot.getScreenshotAs(OutputType.FILE );
	 String destination=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
	 

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
	
	
	
   	


   }
}

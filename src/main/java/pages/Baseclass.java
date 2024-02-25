package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Baseclass {

public  WebDriver driver;
	
	public void initilizebrowser(String Browsername) throws InterruptedException 
	{
			
			if(Browsername.contains("chrome"))
			{
				driver= new ChromeDriver();
			}
			else if(Browsername.equalsIgnoreCase("edge"))
			{
				driver=new EdgeDriver();
			}
			else if(Browsername.equalsIgnoreCase("Firefox")) 
			{
				driver= new FirefoxDriver();
			}
			
			Thread.sleep(1000);
			driver.manage().window().maximize();
			driver.get("https://demoqa.com/automation-practice-form");
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
	}
		
}
	


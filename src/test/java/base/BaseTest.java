package base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver ;
	
	public static Properties pr  = new Properties();
	public static Properties lc  = new Properties();
	public static FileReader fr ;
	public static FileReader fr1;

	@BeforeMethod
	public void setUp() throws IOException {
		if (driver == null) {
			 fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
			 fr1 = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");
			
			pr.load(fr);
			lc.load(fr1);
		}
		if (pr.getProperty("browser").equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			 driver.get(pr.getProperty("testurl"));
			 driver.manage().window().maximize();
			 
			 ChromeOptions option = new ChromeOptions();
	            option.addArguments("--remote-allow-origins=*");

	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver(option);
		}
		else if(pr.getProperty("browser").equalsIgnoreCase("firefox")){
			WebDriverManager.chromedriver().setup();
			 driver = new FirefoxDriver();
			 driver.get(pr.getProperty("testurl"));
			 driver.manage().window().maximize();
		}
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}

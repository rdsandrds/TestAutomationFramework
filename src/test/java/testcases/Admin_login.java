package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadxlsData;


public class Admin_login extends BaseTest{
    @Test(dataProviderClass=ReadxlsData.class,dataProvider="rcpdata")
	public static void LoginTest(String username, String pass) throws InterruptedException {
		
		
		driver.findElement(By.xpath(lc.getProperty("email_field"))).clear();
		driver.findElement(By.xpath(lc.getProperty("email_field"))).sendKeys(username);
		driver.findElement(By.xpath(lc.getProperty("pwd_field"))).clear();
		driver.findElement(By.xpath(lc.getProperty("pwd_field"))).sendKeys(pass);
		//Thread.sleep(4000);
		driver.findElement(By.xpath(lc.getProperty("next_button"))).click();
		//Thread.sleep(4000);
		driver.findElement(By.xpath(lc.getProperty("login_next_button"))).click();
		//Thread.sleep(4000);
		}
    
	
	
}

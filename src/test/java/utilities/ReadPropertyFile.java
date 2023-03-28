package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	
	public static void main (String[] args) throws IOException {
		FileReader fr = new FileReader("C:\\Users\\RSolunke\\eclipse-workspace\\RCP_workspace\\TestAutomationFramework\\src\\test\\resources\\configfiles\\config.properties");
	    Properties pr = new Properties();
	    pr.load(fr);
	  System.out.println(pr.getProperty("browser"));
	  System.out.println(pr.getProperty("testurl"));
	}
}

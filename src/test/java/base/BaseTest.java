package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver dr;
	public static Properties prop=new Properties();
	public static Properties loc=new Properties();
	public static FileReader fr;
	public static FileReader frl;
	public static WebDriverWait wait;
	
	
	@BeforeMethod
	public void setUp() throws IOException {
		
			fr=new FileReader(System.getProperty("user.dir")+"/src/test/resources/configfiles/config.properties");
			frl=new FileReader(System.getProperty("user.dir")+"/src/test/resources/configfiles/locators.properties");
			prop.load(fr);
			loc.load(frl);
			
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			dr=new ChromeDriver();
			dr.manage().window().maximize();
			wait=new WebDriverWait(dr,Duration.ofSeconds(10));
			dr.get(prop.getProperty("testurl"));
			
		}
		
	}
	
	@AfterMethod
	public void tearDown() {
		dr.close();
		
	}
	

}

package task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Exam {	
	private WebDriver driver;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\alex1\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		// 1 - get URL
		driver.get("https://ek.ua/ua/list/122/pr-1358/");
	}
	
	@Test
	public void categoryTesting() {
		
		// 2 - check that actual URL = expected URL
		String actualUrl = "https://ek.ua/ua/list/122/pr-1358/";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		
		// 3 - get number of items on page
		 WebElement phones = driver.findElement(By.xpath("/html/body/div[5]/table/tbody/tr/td[1]/div[2]/span[2]"));
		
		// 4 - sort by popular
		driver.get("https://ek.ua/ua/ek-list.php?katalog_=122&order_=pop&presets_=1358");
		
		// 5 - check that actual URL is expected
		actualUrl = "https://ek.ua/ua/ek-list.php?katalog_=122&order_=pop&presets_=1358";
		expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		
		// 6 - get number of items on page
		 WebElement popPhones = driver.findElement(By.xpath("/html/body/div[5]/table/tbody/tr/td[1]/div[2]/span[2]"));
		
		 // 7 - check that phones numbers are equal
		 if (phones.getText() == popPhones.getText()) {
			 System.out.println("numbers are equal");
			 
		 } else {
			 System.out.println("numbers are not equal");
		 }		 
	}		
	
	@AfterTest
	public void terminateBrowser() {
		driver.quit();
	}
	
}

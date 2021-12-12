package seleniumTest;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

//业务逻辑层
public class SearchAword {
	
	public static void searchAWord(ChromeDriver driver,String url,String keyword,String assertElementDisplayed) throws InterruptedException{
		  driver.get(url);
		  driver.findElement(By.id("kw")).sendKeys(keyword);
		  driver.findElement(By.id("su")).click();
		  
		  TimeUnit.SECONDS.sleep(3);
		  assertTrue(driver.findElement(By.xpath(assertElementDisplayed)).isDisplayed());
		  
	  }

}

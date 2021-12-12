package testng01;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;



public class SeleniumTestDemo {
	WebDriver driver = new ChromeDriver();
	
	
	@Test
	public void testcase01(){
		List<WebElement> links = new ArrayList<WebElement>();
		links = driver.findElements(By.className("mnav"));
		int s = links.size();
		assertEquals(s, 8);
	}

	@Test
	public void testCase002(){
		WebElement rearchField = driver.findElement(By.cssSelector("#kw"));
		rearchField.sendKeys("selenium");
		WebElement btn = driver.findElement(By.cssSelector("#su"));
		btn.click();
		this.waitMostTens(driver, By.cssSelector(".toindex:nth-child(1)"));
		String bdFront = driver.findElement(By.cssSelector(".toindex:nth-child(1)")).getText();
		
		Assert.assertEquals(bdFront, "百度首页");
		
	}
	
	@BeforeClass
	public void BeforeClass() {
		System.out.println("start");
	}

	@BeforeTest
	public void beforeTest() {
		driver.get("https://www.baidu.com");
		driver.manage().window().maximize();
	}

	//@AfterTest
	public void afterTest() {
		driver.findElement(By.xpath("//a[@id='result_logo']/img[1]")).click();
	}
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

	@SuppressWarnings("deprecation")
	public void waitMostTens(WebDriver driver, By by) {
		WebDriverWait driverWait = new WebDriverWait(driver, 10);
		try {
			driverWait.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

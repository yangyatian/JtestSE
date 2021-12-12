package dataFromoutSide;

import static org.testng.Assert.assertTrue;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import testUtil.DataSourceUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataFromOutside {
	private ChromeDriver driver;
	
	private String url;
	private String url2;
	@BeforeClass
	public void setUpAll(){
		driver = new ChromeDriver();
		Map<String, String> properties = DataSourceUtil.readProperties("configdata.properties");
		url = properties.get("search.url");
		
		Map<String, Object> yaml = DataSourceUtil.readYaml("configdata.yaml");
		Map<String, String> tmp = (Map<String, String>) yaml.get("search");
		url2 = tmp.get("url");
		
	}
	
	 @AfterClass
		public void tearDownAll(){
			driver.quit();
		}
	// csv数据分离
		@DataProvider(name = "forTestCase_0004")
		public Object[][] testDate4() {
		
			return DataSourceUtil.readCsv("test.csv");
		} 
		
		//from excel
		@DataProvider(name = "forTestCase_5")
		public Object[][] testDate5() {
			return DataSourceUtil.readExcel("test2.xlsx", "sheet1");
		} 
			
	// csv数据分离
	@Test(description = "search", dataProvider = "forTestCase_5")
	public void testCase4(String keyword) throws InterruptedException{
		driver.get(url);
		driver.findElement(By.id("kw")).sendKeys(keyword);
		driver.findElement(By.id("su")).click();
		TimeUnit.SECONDS.sleep(3);
		assertTrue(driver.findElement(By.xpath("//div[@title='百度热搜']//i[@class='c-icon icon-title_35rjV']")).isDisplayed());
		driver.quit();
	}

}

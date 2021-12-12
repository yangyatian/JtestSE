package seleniumTest;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider {
	//并发执行
	@DataProvider(name = "for search2",parallel=true)
	public Object[][] searchData() {
		return new Object[][] {
				new Object[] { "https://www.baidu.com", "selenium2" },
				new Object[] { "https://www.baidu.com", "测试2" } };
	}

	@Test(description="注解数据驱动",dataProvider = "for search2")
	public void testCase001(String url, String keyword)
			throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get(url);
		driver.findElement(By.id("kw")).sendKeys(keyword);
		driver.findElement(By.id("su")).click();

		TimeUnit.SECONDS.sleep(3);
		assertTrue(driver
				.findElement(
						By.xpath("//div[@title='百度热搜']//i[@class='c-icon icon-title_35rjV']"))
				.isDisplayed());

		TimeUnit.SECONDS.sleep(3);

		driver.quit();
	}
}

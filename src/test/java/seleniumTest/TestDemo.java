package seleniumTest;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static seleniumTest.SearchAword.searchAWord;

//用例层
public class TestDemo extends AbstractTestClass {

	String searchUrl = "https://www.baidu.com";
	String keyword = "selenium";
	String assertDisplayed = "//div[@title='百度热搜']//i[@class='c-icon icon-title_35rjV']";

	@DataProvider(name = "for search")
	public Object[][] searchData() {
		return new Object[][] {
				new Object[] { "https://www.baidu.com", "selenium" },
				new Object[] { "https://www.baidu.com", "测试" } };
	}

	@Test(description = "search something")
	public void testCase01() throws InterruptedException {
		searchAWord(driver, searchUrl, keyword, assertDisplayed);
		searchAWord(driver, searchUrl, "appium", assertDisplayed);

	}

	@Test(description = "search something2", dataProvider = "for search")
	public void testCase02(String url, String keyword)
			throws InterruptedException {
		searchAWord(driver, url, keyword, assertDisplayed);
		searchAWord(driver, url, keyword, assertDisplayed);
	}

	// testngxml数据驱动，需执行testngxml文件
	@Test(description = "search something")
	@Parameters({ "urls", "keywords" })
	public void testCase03(String urls, String keywords)
			throws InterruptedException {
		searchAWord(driver, urls, keywords, assertDisplayed);
		searchAWord(driver, urls, keywords, assertDisplayed);
	}
	  
}

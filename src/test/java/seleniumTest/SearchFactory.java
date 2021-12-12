package seleniumTest;

import static seleniumTest.SearchAword.searchAWord;

import org.testng.annotations.Test;

public class SearchFactory extends AbstractTestClass {
	private String urls;
	private String keywords;
	private String assertDisplayed;
	
	public SearchFactory(String urls,String keywords,String assertDisplayed) {
		this.urls=urls;
		this.keywords=keywords;
		this.assertDisplayed=assertDisplayed;
	}
	
	@Test(description="search something")
	  public void testCase04() throws InterruptedException {
		  searchAWord(driver, this.urls, this.keywords,this.assertDisplayed);
		  searchAWord(driver, this.urls, this.keywords,this.assertDisplayed); 
	  }

}

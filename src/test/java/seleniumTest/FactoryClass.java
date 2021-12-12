package seleniumTest;

import org.testng.annotations.Factory;

public class FactoryClass {

	@Factory
	public Object[] createTestClasses() {
		return new Object[] { new SearchFactory("http://www.baidu.com", "junit","//div[@title='百度热搜']//i[@class='c-icon icon-title_35rjV']"),
				new SearchFactory("http://www.baidu.com", "pytest","")
		};
	}
	
	@Factory(enabled=false)
	public Object[] createTestClasses2() {
		return new Object[] { new SearchFactory("http://www.baidu.com", "appium","//div[@title='百度热搜']//i[@class='c-icon icon-title_35rjV']")

		};
	}
	
	
}

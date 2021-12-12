package testng01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FirstClassTest {
	/*@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("++before test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("++after test");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("++before class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("++after class");
	}

	@BeforeGroups(groups = { "g1" })
	public void beforeGroups1() {
		System.out.println("++--before groups1");
	}

	@AfterGroups(groups = { "g1" })
	public void afterGroups1() {
		System.out.println("++--after groups1");
	}

	@BeforeGroups(groups = { "g2" })
	public void beforeGroups2() {
		System.out.println("++--before groups2");
	}

	@AfterGroups(groups = { "g2" })
	public void afterGroups2() {
		System.out.println("++--after groups2");
	}

	@BeforeMethod
	public void beforemethod() {
		System.out.println("++--before method");
	}

	@AfterMethod
	public void aftermethod() {
		System.out.println("++--after method");
	}*/

	/*@Test(groups = { "g1" }, dataProvider = "data")
	public void testcase1(String username, String passwd, String prompt) {
		System.out.println("如果输入：" + username + "," + passwd + ",提示" + prompt);
	}

	@DataProvider(name = "data")
	public Object[][] dataprovider1() {
		return new Object[][] { new Object[] { "空账号", "正确密码", "账号不能为空" },
				new Object[] { "正确密码", "空账号", "账号不能为空" },
				new Object[] { "账号不能为空", "空账号", "正确密码" } };
	}

	@Test(description = "测试用例2", groups = { "g2" })
	public void testcase2() {
		System.out.println("++--++ testcase2");
	}

	@Test(groups = { "g2" })
	public void testcase3() {
		System.out.println("++--++ testcase3");
	}

	@Test(groups = { "g1", "g2" })
	public void testcase4() {
		System.out.println("++--++ testcase4");
	}

	@Test(priority = 2)
	public void testcase5() {
		System.out.println("++--++ testcase5");
	}

	@Test(priority = 1)
	public void testcase6() {
		System.out.println("++--++ testcase5");
	}
*/
	/*@Test
	public void testcase7() {
		System.out.println("++--++ fristclasstest 的testcase7");
	}*/

	/*@Test
	public void testcase8() {
		System.out.println("++--++ testcase8");
		throw new RuntimeException("testcase8运行异常！");
	}

	@Test(groups = { "myGroups" })
	public void testcase9() {
		System.out.println("++--++ testcase9");
		throw new RuntimeException("testcase9运行异常！");
	}

	@Test(enabled = false)
	public void testcase10() {
		System.out.println("++--++ testcase10");
	}

	@Test(dependsOnMethods = { "testcase8" }, dependsOnGroups = { "myGroups" },alwaysRun = true)
	public void testcase11() {
		System.out.println("++--++ testcase11");
	}*/
	
/*	
	@Test(groups = {"mygroup"})
	public void testcase1() {
		System.out.println("testcase1");
		}
	@Test
	public void testcase2() {
		System.out.println("testcase2");
		}
	@Test(groups = {"mygroup"})
	public void testcase3() {
		System.out.println("testcase3");
		}
	@Test
	public void newtestcase1() {
		System.out.println("newtestcase1");
		}*/
	
	@Parameters({"myParam"})
	@Test
	public void testcase1(String param) {
		System.out.println("myParam的值是："+param);
		}
	
	
}

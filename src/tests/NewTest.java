package tests;

import org.openqa.selenium.server.SeleniumServer;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import com.thoughtworks.selenium.SeleneseTestCase;

public class NewTest extends SeleneseTestCase{
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
	  // start server
	  
	  SeleniumServer server = new SeleniumServer();
	  server.boot();
	  server.start();
	  
	  setUp("http://www.quikr.com","firefox");
	  selenium.setSpeed("2000");
	  
	  // start testing
	  selenium.open("/");
	  selenium.type("id=query", "xyz");
	  selenium.select("id=categoryId", "label=Goa");
	  selenium.click("css=input.search_button_sprite");
	  selenium.waitForPageToLoad("30000");
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
}



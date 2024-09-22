package Project.blazedemo.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import BasePage.BaseTest;
import Project.blazedemo.PageObject.blazedemoPageObject;


public class BlazedemoTestCase extends BaseTest {

	@Test
	public void vesas() throws InterruptedException, IOException {
		try {
			logger.info("Test started.");
			blazedemoPageObject blazedemo=new blazedemoPageObject(driver);
			blazedemo.selectDepartureCity("Boston");
			blazedemo.selectDestinationCity("Rome");
			blazedemo.clickfindFlight();
			blazedemo.clickchooseFlight();
			blazedemo.enterName("user");
			blazedemo.enterAddress("main city");
			blazedemo.enterCity("Test");
			blazedemo.enterState("Test2");
			blazedemo.enterZipCode("256986");
			blazedemo.selectCardType("American Express");
			blazedemo.enterCreditCardNumber("485726958648595");
			blazedemo.enterCreditCardMonth("05");
			blazedemo.enterCreditCardYear("27");
			blazedemo.enternameOnCard("UserTest");
			blazedemo.ClickPurchaseButton();

			Assert.assertTrue(blazedemo.verifySuccessfulMessage().getText().contains("Thank you for your purchase today!"));

		}catch (Exception e) {
			e.printStackTrace();
			// Capture screenshot for failed test
			captureScreen("Test_Failed");
			// Re-throw the exception to mark the test as failed
			throw e;
		} finally {
			// Close the WebDriver instance
			logger.info("Test completed.");
		}
	}
	
	@Test
	public void dropdownTest() {
		blazedemoPageObject blazedemo=new blazedemoPageObject(driver);
		
	}
}


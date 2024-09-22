package Project.blazedemo.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class blazedemoPageObject {

	WebDriver ldriver;
	// Constructor
	public blazedemoPageObject(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	//******************************
	
	
	//******************************
	
	
	//*********************** Locators page********************
	@FindBy(xpath="//select[@name='fromPort']")
	WebElement departureCityDropdown;

	@FindBy(xpath="//select[@name='toPort']")
	WebElement destinationCityDropdown;

	@FindBy(xpath="//input[@value='Find Flights']")
	WebElement findFlightButton;
	
	@FindBy(xpath="//tbody/tr[2]/td[1]/input[1]")
	WebElement chooseFlightButton;
	
	@FindBy(id="inputName")
	WebElement NameInput;
	
	@FindBy(id="address")
	WebElement addressInput;
	
	@FindBy(id="city")
	WebElement cityInput;
	
	@FindBy(id="state")
	WebElement stateInput;

	@FindBy(id="zipCode")
	WebElement zipCodeInput;
	
	@FindBy(id="cardType")
	WebElement cardTypeInput;
	
	@FindBy(id="creditCardNumber")
	WebElement creditCardNumberInput;
	
	@FindBy(id="creditCardMonth")
	WebElement creditCardMonthInput;
	
	@FindBy(id="creditCardYear")
	WebElement creditCardYearInput;
	
	@FindBy(id="nameOnCard")
	WebElement nameOnCardInput;
	
	@FindBy(xpath="//input[@value='Purchase Flight']")
	WebElement purchaseButton;
	
	@FindBy(xpath="//*[contains(text(), 'Thank you for your purchase today!')]")
	WebElement textVerify;
	
	public void selectDepartureCity(String optionText) {
		Select dropdown = new Select(departureCityDropdown);
		dropdown.selectByVisibleText(optionText);
	}

	public void selectDestinationCity(String optionText) {
		Select dropdown = new Select(destinationCityDropdown);
		dropdown.selectByVisibleText(optionText);
	}


	public void clickfindFlight() {
		findFlightButton.click();

	}
	
	public void clickchooseFlight() {
		chooseFlightButton.click();

	}
	
	public void enterName(String name) {
		NameInput.sendKeys(name);

	}
	
	public void enterAddress(String address) {
		addressInput.sendKeys(address);

	}
	
	public void enterCity(String city) {
		cityInput.sendKeys(city);

	}
	
	public void enterState(String state) {
		stateInput.sendKeys(state);

	}
	
	public void enterZipCode(String zip) {
		zipCodeInput.sendKeys(zip);

	}
	
	public void selectCardType(String optionText) {
		Select dropdown = new Select(cardTypeInput);
		dropdown.selectByVisibleText(optionText);
	}
	
	public void enterCreditCardNumber(String cardNumber) {
		creditCardNumberInput.sendKeys(cardNumber);

	}
	
	public void enterCreditCardMonth(String month) {
		creditCardMonthInput.sendKeys(month);

	}
	
	public void enterCreditCardYear(String year) {
		creditCardYearInput.sendKeys(year);

	}
	
	public void enternameOnCard(String nameOncard) {
		nameOnCardInput.sendKeys(nameOncard);

	}
	
	public void ClickPurchaseButton() {
		purchaseButton.click();

	}
	
	public WebElement verifySuccessfulMessage() {
		return textVerify;

	}
}
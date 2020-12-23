package stepdefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;
import util.utilities;

public class Steps extends MasterStepDefs{
	public WebDriver driver;

	public LandingPage lp;
	public LoginPage lop;
	public OrdersPage op;
	public ViewProducts vp;
	public utilities ut;
	public EditorderPage eop;
	

	@Before
	public void user_launch_the_browser(String strDevice) throws Throwable {
		
	//	ut.launchBrowser("chrome");

//		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
//
//		driver = new ChromeDriver();
//
//		driver.manage().window().maximize();
//
//		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable.extensions");
//		options.setExperimentalOption("useAutomationExtension", false);
	//	driver=pages.LaunchBrowser.setBrowser();
		initializeDriver(strDevice);

		lp = new LandingPage();

	}

	@After
	public void end() {

		driver.quit();
	}

	/*
	 * Scenario 1: Methods to check order creation functionality
	 */

	@Given("User launch the browser and navigate to the application")
	public void user_launch_the_browser_and_navigate_to_the_application() {

		driver.get("http://downloads.smartbear.com/samples/TestComplete10/WebOrders/Login.aspx");

	}

	@When("^on the landing page verifies Username Textbox, Password Textbox and Login button$")
	public void on_the_landing_page_verifies_username_textbox_password_textbox_and_login_button() {

		lp.usernameBoxad(driver);
		lp.passwordBoxad(driver);
		lp.loginBtnad(driver);

	}

	@When("^Login using the valid credentials such as username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void login_using_the_valid_credentials_such_as_username_as_and_password_as(String username,
			String password) {

		lp.usern(driver, username, password);

	}

	@When("^Verify the Welcome ‘USERNAME’ showing the name as needed$")
	public void verify_the_welcome_username_showing_the_name_as_needed() {

		lp.welcomeTextad(driver);

	}

	@When("^navigate to the Orders page$")
	public void navigate_to_the_orders_page() {
		lp.ordpgad(driver);

	}

	@When("^select any product from the list and enter the quantity as \"([^\"]*)\"$")
	public void select_any_product_from_the_list_and_enter_the_quantity_as(String quantity1) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		op.productad(driver);
		op.quantityad(driver, quantity1);

	}

	@When("^click the calculate button$")
	public void click_the_calculate_button() throws InterruptedException {
		Thread.sleep(3000);
		ut.screenshot(driver);
		op.calBtnad(driver);

	}

	@When("^Verify the value displayed correctly for the quantity and price$")
	public void verify_the_value_displayed_correctly_for_the_quantity_and_price() {
		op.verfqu(driver);
		op.verfpr(driver);

	}

	@When("^Enter the name as \"([^\"]*)\" and street as \"([^\"]*)\" and city as \"([^\"]*)\" and state as \"([^\"]*)\" and zip as \"([^\"]*)\" for the order$")
	public void enter_the_name_as_and_street_as_and_city_as_and_state_as_and_zip_as_for_the_order(String name,
			String street, String city, String state, String zip) {
		op.cstdetails(driver, name, street, city, state, zip);

	}

	@When("^Enter a dummy credit card details including cardnumber as \"([^\"]*)\" and expirydate as \"([^\"]*)\"$")
	public void enter_a_dummy_credit_card_details_including_cardnumber_as_and_expirydate_as(String cardnumber,
			String expirydate) throws InterruptedException {
		Thread.sleep(3000);
		ut.screenshot(driver);
		op.cstcarddet(driver, cardnumber, expirydate);

	}

	@When("^click process and verify the confirmation message$")
	public void click_process_and_verify_the_confirmation_message() {
		op.verconfirmation(driver);

	}

	@When("^navigate to View all orders$")
	public void navigate_to_view_all_orders() {
		op.viewordclk(driver);

	}

	@When("^verify the presence of the order placed$")
	public void verify_the_presence_of_the_order_placed() throws InterruptedException {
		Thread.sleep(3000);
		ut.screenshot(driver);
		lp.verorderad(driver);

	}

	/***************/
	@When("^edit the same order by changing expirydate as \"([^\"]*)\" and type to visa$")
	public void edit_the_same_order_by_changing_expirydate_as_and_type_to_visa(String expirydate1) {
		lp.editad(driver, expirydate1);
	}

	@Then("^verify the presence of updated order$")
	public void verify_the_presence_of_updated_order() throws InterruptedException {
		Thread.sleep(3000);
		ut.screenshot(driver);
		lp.verifyfnl(driver);
	}

	/*
	 * Scenario 2 Methods to check whether order can be edited or not
	 */

	@When("^on the landing pagee verifies Username Textbox, Password Textbox and Login button$")
	public void on_the_landing_pagee_verifies_username_textbox_password_textbox_and_login_button() {

		lp.usernameBoxad(driver);
		lp.passwordBoxad(driver);
		lp.loginBtnad(driver);

	}

	@When("^Login usingg the valid credentials such as username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void login_usingg_the_valid_credentials_such_as_username_as_and_password_as(String username,
			String password) {

		lp.usern(driver, username, password);

	}

	@When("^Verifyy the Welcome ‘USERNAME’ showing the name as needed$")
	public void verifyy_the_welcome_username_showing_the_name_as_needed() {

		lp.welcomeTextad(driver);

	}

	@When("^navigatee to the Orders page$")
	public void navigatee_to_the_orders_page() {
		lp.ordpgad(driver);

	}

	@When("^select anyy product from the list and enter the quantity as \"([^\"]*)\"$")
	public void select_anyy_product_from_the_list_and_enter_the_quantity_as(String quantity1) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		op.productad(driver);
		op.quantityad(driver, quantity1);

	}

	@When("^click thee calculate button$")
	public void click_thee_calculate_button() throws InterruptedException {
		Thread.sleep(3000);
		ut.screenshot(driver);
		op.calBtnad(driver);

	}

	@When("^Verify the valuee displayed correctly for the quantity and price$")
	public void verify_the_valuee_displayed_correctly_for_the_quantity_and_price() {
		op.verfqu(driver);
		op.verfpr(driver);

	}

	@When("^Enter the namee as \"([^\"]*)\" and street as \"([^\"]*)\" and city as \"([^\"]*)\" and state as \"([^\"]*)\" and zip as \"([^\"]*)\" for the order$")
	public void enter_the_namee_as_and_street_as_and_city_as_and_state_as_and_zip_as_for_the_order(String name,
			String street, String city, String state, String zip) {
		op.cstdetails(driver, name, street, city, state, zip);

	}

	@When("^Enter a dummy creditt card details including cardnumber as \"([^\"]*)\" and expirydate as \"([^\"]*)\"$")
	public void enter_a_dummy_creditt_card_details_including_cardnumber_as_and_expirydate_as(String cardnumber,
			String expirydate) throws InterruptedException {
		Thread.sleep(3000);
		ut.screenshot(driver);
		op.cstcarddet(driver, cardnumber, expirydate);

	}

	@When("^click process and verifyy the confirmation message$")
	public void click_process_and_verifyy_the_confirmation_message() {
		op.verconfirmation(driver);

	}

	@When("^navigate to Vieww all orders$")
	public void navigate_to_vieww_all_orders() {
		op.viewordclk(driver);

	}

	@When("^verify the presencee of the order placed$")
	public void verify_the_presencee_of_the_order_placed() throws InterruptedException {
		Thread.sleep(3000);
		ut.screenshot(driver);
		lp.verorderad(driver);

	}

	@When("^edit the samee order by changing expirydate as \"([^\"]*)\" and type to visa$")
	public void edit_the_samee_order_by_changing_expirydate_as_and_type_to_visa(String expirydate1) {
		lp.editad(driver, expirydate1);
	}

	@Then("^verify the presencee of updated order$")
	public void verify_the_presencee_of_updated_order() throws InterruptedException {
		Thread.sleep(3000);
		ut.screenshot(driver);
		lp.verifyfnl(driver);
	}

	@When("^User will edit the order created in last scenario$")
	public void user_will_edit_the_order_created_in_last_scenario() throws Throwable {
		Thread.sleep(3000);
		lp.navedit(driver);

	}

	/*
	 * @When("^user navigates to edit order page and verifies the page $")
	 * public void user_navigates_to_edit_order_page_and_verifies_the_page()
	 * throws Throwable { Thread.sleep(3000); eop.verfedit(driver);
	 * 
	 * }
	 */

	@And("^updates the zip code as \"([^\"]*)\" and city as \"([^\"]*)\"$")
	public void updates_the_zip_code_as_something_and_city_as_something(String city1, String zip1) throws Throwable {
		Thread.sleep(3000);
		eop.filledit(driver, city1, zip1);

	}

	@And("^Verify the updated details on view orders page$")
	public void verify_the_updated_details_on_view_orders_page() throws Throwable {
		Thread.sleep(3000);
		eop.vercityzip(driver);

	}

	@Then("^click on logout button and verify the same$")
	public void click_on_logout_button_and_verify_the_same() throws Throwable {
		Thread.sleep(3000);
		eop.lgout(driver);
		Thread.sleep(3000);
		lop.loginver(driver);

	}

	/*
	 * Scenario 3 To verify products and related information on products page.
	 */

	@When("^onn the landing pagee verifies Username Textbox, Password Textbox and Login button$")
	public void onn_the_landing_pagee_verifies_username_textbox_password_textbox_and_login_button() throws InterruptedException {
        Thread.sleep(2000);
		lp.usernameBoxad(driver);
		lp.passwordBoxad(driver);
		lp.loginBtnad(driver);

	}

	@And("^Loginn usingg the valid credentials such as username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void loginn_usingg_the_valid_credentials_such_as_username_as_and_password_as(String username,
			String password) {

		lp.usern(driver, username, password);

	}

	@And("^Verifyy the Welcome ‘USERNAME’ showing the name as neededd$")
	public void verifyy_the_welcome_username_showing_the_name_as_neededd() {

		lp.welcomeTextad(driver);

	}

	@And("^navigate to View all products page$")
	public void navigate_to_view_all_products_page() throws Throwable {
		Thread.sleep(2000);
		lp.viewprdnav(driver);
		
	}

	@And("^verify the products in the table$")
	public void verify_the_products_in_the_table() throws Throwable {
		Thread.sleep(3000);
		vp.tabverf(driver);
		
	}

	@Then("^clickk on logout button and verify the same$")
	public void clickk_on_logout_button_and_verify_the_same() throws Throwable {
		vp.logoutf(driver);
		
	}

}

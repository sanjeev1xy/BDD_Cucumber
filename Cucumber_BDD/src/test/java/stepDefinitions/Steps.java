package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.AddcustomerPage;
import PageObjects.LoginPage;
import io.cucumber.java.en.*;
import junit.framework.Assert;
//import cucumber.api.junit.Cucumber;
import io.cucumber.junit.Cucumber;

public class Steps extends BaseClass
{
	
	@Given("User Launch chrome browser")
	public void user_launch_chrome_browser() 
	{
	   System.setProperty("webdriver.chrome.driver", "D:\\Automation Framework\\Cucumber_BDD\\Drivers\\chromedriver.exe");
	   driver=new ChromeDriver();
	   lp=new LoginPage(driver);
	   driver.manage().window().maximize();
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) 
	{
	    driver.get(url);
	}

	@When("User enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String emailid, String password) throws InterruptedException 
	{
	    lp.setUserName(emailid);
	    lp.setPassowrd(password);
	    Thread.sleep(3000);
	}

	@When("click on Login")
	public void click_on_login() throws InterruptedException
	{
	    lp.clickLogin();
	    Thread.sleep(3000);
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException 
	{
	    if(driver.getPageSource().contains("Login was unsuccessful"))
	    {
	    	driver.close();
	    	Assert.assertTrue(false);
	    }
	    else
	    	
	    {
	    	Assert.assertEquals(title, driver.getTitle());
	    }
	    Thread.sleep(3000);
	}
	
	

//	@When("User click on log out link")
//	public void user_click_on_log_out_link() throws InterruptedException
//	{
//	    lp.clickLogout();
//	    Thread.sleep(5000);
//	}
//	
//
//	@Then("close browser")
//	public void close_browser() 
//	{
//	    driver.quit();
//	}

	// customer feature step definitions ...............
	
	
	@Then("User Can view Dashboard")
	public void user_can_view_dashboard()
	{
	    acp=new AddcustomerPage(driver);
	    Assert.assertEquals("Dashboard / nopCommerce administration", acp.getPageTitle());
	}
	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws InterruptedException 
	{
		Thread.sleep(3000);
	    acp.clickOnCustomerMenu();
	}
	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException
	{
		Thread.sleep(3000);
	   acp.clickOnCustomerMenuItem();
	}
	@When("Click on Add new button")
	public void click_on_add_new_button() throws InterruptedException 
	{
	    acp.clickOnAddnew();
	    Thread.sleep(2000);
	}
	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() 
	{
	    Assert.assertEquals("Add a new customer / nopCommerce administration", acp.getPageTitle());

	}
	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException
	{
	   String email= randomestring()+"@gmail.com";
	   acp.setEmail(email);
	   acp.setPassword("test123");
	   //Registered - Default
	   // The customer can not ve in both 'Guest'and 'Registered' customer roles
	   // Add the customer to 'Guest' or 'Registered' customer role
	   acp.setCustomerRoles("Guest");
	   Thread.sleep(3000);
	   acp.setManagerofVendor("Vendor 2");
	   acp.setGender("Male");
	   acp.setFirstName("Sanjeev");
	   acp.setLastName("Thakur");
	   acp.setDOB("05/06/1995");
	   acp.setCompanyName("busyQA");
	   acp.setAdminContent("This is for testing ........");
	   
	}
	@When("click on save button")
	public void click_on_save_button() throws InterruptedException 
	{
	   acp.clickOnSave();
	   Thread.sleep(3000);
	}
	@Then("User User can view confirmation message {string}")
	public void user_user_can_view_confirmation_message(String string)
	{
	    Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
	    		.contains("The new customer has been added successfully"));
	}

	
}

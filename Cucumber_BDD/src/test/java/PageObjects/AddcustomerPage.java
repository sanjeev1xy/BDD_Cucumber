package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddcustomerPage
{
public WebDriver driver;

public AddcustomerPage(WebDriver driver) 
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

//By linkCustomers_menu=By.xpath("//p[text()=' Customers']");

By linkCustomers_menu=By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");

By linkCustomers_menuitem=By.xpath("//p[text()=' Customers']");

By btnAddnew=By.xpath("//a[@class='btn btn-primary']");

By txtemail=By.xpath("//input[@id='Email']");

By texpassord=By.xpath("//input[@id='Password']");

By TxtCustomer_roles=By.xpath("(//div[@class='k-multiselect-wrap k-floatwrap'])[2]");

By listeditem_Administrtator =By.xpath("//li[contains(text() , 'Administrators')]");

By listeditem_Registered =By.xpath("//li[contains(text() , 'Registered')]");

By listeditem_Guest =By.xpath("//li[contains(text() , 'Guests')]");

By listeditem_Vendors =By.xpath("//li[contains(text() , 'Vendors')]");

By FirstName=By.xpath("//input[@id='FirstName']");

By LastName=By.xpath("//input[@id='LastName']");

By drpdownmanagerofvendor=By.xpath("//*[@id='VendorId']");

By MaleGender=By.id("Gender_Male");

By FemaleGender=By.id("Gender_Female");

By txtDOB=By.xpath("//input[@id='DateOfBirth']");

By txtComapanyName=By.xpath("//input[@id='Company']");

By AdminComment=By.xpath("//textarea[@id='AdminComment']");

By btnSave=By.xpath("//button[@name='save']");

// Actions Method 

public String getPageTitle()
{
	return driver.getTitle();
}

public void clickOnCustomerMenu()
{
	driver.findElement(linkCustomers_menu).click();
}

public void clickOnCustomerMenuItem()
{
	driver.findElement(linkCustomers_menuitem).click();
}

public void clickOnAddnew()
{
	driver.findElement(btnAddnew).click();
}

public void setEmail(String email)
{
	driver.findElement(txtemail).sendKeys(email);
}

public void setPassword(String password)
{
	driver.findElement(texpassord).sendKeys(password);
}

public void setCustomerRoles(String role)
{
	if(!role.equals("vendors"))
	{
		driver.findElement(By.xpath("//*[@id='SelectedCustomerRoleIds_taglist']"));
	}
	
	driver.findElement(TxtCustomer_roles).click();
	
	WebElement listitem;
	
	if(role.equals("Administrators"))
	{
		listitem=driver.findElement(listeditem_Administrtator);
	}
	
	else if(role.equals("Guest"))
	{
		listitem=driver.findElement(listeditem_Guest);
	}
	
	else if(role.equals("Registered"))
	{
		listitem=driver.findElement(listeditem_Registered);
	}
	
	else if(role.equals("Vendors"))
	{
		listitem=driver.findElement(listeditem_Vendors);
	}
	
	else
	{
		listitem=driver.findElement(listeditem_Guest);
	}
	
	
	listitem.click();
	
	JavascriptExecutor js =(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", listitem);
	
}

public void setManagerofVendor(String Value)
{
	Select drp=new Select(driver.findElement(drpdownmanagerofvendor));
	drp.selectByVisibleText(Value);
}

public void setGender(String gender)
{
	if(gender.equals("Male"))
	{
		driver.findElement(MaleGender).click();;
	}
	
	else if(gender.equals("Female"))
	{
		driver.findElement(FemaleGender).click();
	}
	
	else
	{
		driver.findElement(MaleGender).click(); // Default
	}
}

public void setFirstName(String fname)
{
	driver.findElement(FirstName).sendKeys(fname);
}

public void setLastName(String lname)
{
	driver.findElement(LastName).sendKeys(lname);
}

public void setDOB(String dob)
{
	driver.findElement(txtDOB).sendKeys(dob);
}

public void setCompanyName(String comname)
{
	driver.findElement(txtComapanyName).sendKeys(comname);
}

public void setAdminContent(String content)
{
	driver.findElement(AdminComment).sendKeys(content);
}

public void clickOnSave()
{
	driver.findElement(btnSave).click();
}
}
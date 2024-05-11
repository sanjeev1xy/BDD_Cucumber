package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
public WebDriver driver;

public LoginPage(WebDriver driver) 
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
    @FindBy(id="Email")
    @CacheLookup
     WebElement textemail;
    
    @FindBy(id="Password")
    @CacheLookup
    WebElement textpassowrd;
    
    @FindBy(xpath="//button[text()='Log in']")
    @CacheLookup
    WebElement buttonlogin;
    
    //@FindBy(linkText="Logout")
    @FindBy(xpath="(//a[@class='nav-link'])[2]")
    @CacheLookup
    WebElement logout;
    
    public void setUserName(String uname)
    {
    	textemail.clear();
    	textemail.sendKeys(uname);
    }
    
    public void setPassowrd(String pwd)
    {
    	textpassowrd.clear();
    	textpassowrd.sendKeys(pwd);
    }
    
    public void clickLogin()
    {
    	buttonlogin.click();
    }
    
    public void clickLogout()
    {
    	logout.click();
    }
    
//    public void cleanemailpassword()
//    {
//    	textemail.click();
//    	textemail.clear();
//    	textpassowrd.click();
//    	textpassowrd.clear();
//    }
}

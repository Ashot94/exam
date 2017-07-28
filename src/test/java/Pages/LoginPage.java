package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ash on 7/28/2017.
 */
public class LoginPage {
    @FindBy(xpath = "//*[@id=\"username\"]")
            WebElement loginEmailField;
    @FindBy(xpath = "//*[@id=\"password\"]")
            WebElement loginPasswordField;
    @FindBy(xpath = "//*[@id=\"login\"]")
            WebElement loginButton;

    WebDriver driver;
    String loginMail = "stdevqa5@stdevmail.com";
    String loginPassword = "STDev123";

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    public LoginPage fillEmailField(){
       loginEmailField.sendKeys(loginMail);
       return this;
    }
    public LoginPage fillPasswordField(){
        loginPasswordField.sendKeys(loginPassword);
        return this;
    }
    public LoginPage clickLogin(){
        loginButton.click();
        return this;
    }
}

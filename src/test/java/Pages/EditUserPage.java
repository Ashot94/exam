package Pages;

import Builders.UserBuilder;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

/**
 * Created by Ash on 7/28//2017.
 */
public class EditUserPage {
@FindBy(xpath = "/html/body/div/div[3]/section/div/div[2]/div[2]/div/div/div/div/label[2]/div")
WebElement enableEditingButton;
@FindBy(xpath = "//*[@id=\"first_name\"]")
WebElement firstNameField;
@FindBy(xpath = "//*[@id=\"last_name\"]")
WebElement lastNameField;
@FindBy(xpath = "//*[@id=\"Email_Address\"]")
WebElement emailField;
@FindBy(xpath = "/html/body/div/div[3]/section/div/div[2]/div[2]/div/form/fieldset/div[6]/div/label/span")
WebElement activeCheckBox;


    List<UserBuilder> users;
    WebDriver driver;
    public EditUserPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(this.driver,this);
    }
 public EditUserPage clickEnableEditingButton() throws InterruptedException {
     enableEditingButton.click();
     Thread.sleep(2000);

     return this;
 }
 public EditUserPage changeFirstName(String name) throws InterruptedException {
     firstNameField.sendKeys(Keys.DELETE);
     firstNameField.clear();
     firstNameField.sendKeys(name);
     return  this;
 }
    public EditUserPage changeLastNameField(String lastName) throws InterruptedException {
        lastNameField.sendKeys(Keys.DELETE);
       lastNameField.clear();
       lastNameField.sendKeys(lastName);
     return this;
    }
    public EditUserPage changeEmail(String eMail) throws InterruptedException {
        emailField.sendKeys(Keys.DELETE);
        emailField.clear();
        emailField.sendKeys(eMail);
        return  this;
    }
    public EditUserPage checkCkeckBox(){
     activeCheckBox.click();
     return this;
    }
}

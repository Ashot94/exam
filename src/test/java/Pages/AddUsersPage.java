package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ash on 7/28/2017.
 */
public class AddUsersPage {
    @FindBy(xpath = "//*[@id=\"first_name\"]")
    WebElement addUserFirstNameField;
    @FindBy(xpath = "//*[@id=\"last_name\"]")
    WebElement addAddUserLasttNameField;
    @FindBy(xpath = "/html/body/div/div[3]/section/div/div[2]/div[2]/div/form/div[3]/div/span/span[1]/span/ul/li")
    WebElement userMessagingTypeField;
    @FindBy(xpath = "//*[@id=\"select2-notification_type-y8-results\"]")
    List<WebElement> userMessageTypes;
    @FindBy(xpath = "//*[@id=\"Email_Address\"]")
    WebElement addUserEmailField;
    @FindBy(xpath = "/html/body/div[1]/div[3]/section/div/div[2]/div[2]/div/form/div[6]/div/label/span")
    WebElement promptUserToConfirmAccountCheckBox;
    @FindBy(id = "Active")
    WebElement activeCheckBox;
    @FindBy(xpath = "/html/body/div/div[3]/section/div/div[2]/div[2]/div/form/div[8]//*[@id=\"Cancel\"]")
    WebElement addUserCancelButton;
    @FindBy(xpath = "/html/body/div/div[3]/section/div/div[2]/div[2]/div/form/div[8]//*[@id=\"Save\"]")
    WebElement addUserSaveButton;
    @FindBy(xpath = "/html/body/div/div[3]/section/div/div[2]/div[2]/div/form/div[4]/div//*[@id=\"Add_Terms\"]")
    WebElement addNewNotificationTypeButton;
    @FindBy(xpath = "/html/body/div[1]/div[2]/ul/li/p")
    WebElement errorMessage;

    String userName;
    String userLastName;
    String userMail;
    String userPassword;
    String notificationTypeName;
    WebDriver driver;

    public AddUsersPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    public AddUsersPage setUserName(String name){
        this.userName=name;
        return this;
    }

    public AddUsersPage setUserLastName(String lastName){
        this.userLastName=lastName;
        return this;
    }

    public AddUsersPage setUserPassword(String password){
        this.userPassword=password;
        return this;
    }

    public AddUsersPage setUserMail(String mail){
        this.userMail=mail;
        return this;
    }
    public AddUsersPage addUserMessageTypes(int id) throws InterruptedException {

        addUserEmailField.sendKeys(Keys.CONTROL);

        return this;
    }
    public AddUsersPage fillAddUserFirstNameField(){
        addUserFirstNameField.sendKeys(userName);
        return this;
    }
    public AddUsersPage fillAddUserLastNameField(){
        addAddUserLasttNameField.sendKeys(userLastName);
        return this;
    }
    public AddUsersPage fillAddUserEmailField(){
        addUserEmailField.sendKeys(userMail);
        return this;
    }
    public AddUsersPage selectPromptUserToConfirmAccountCheckBox(){
        promptUserToConfirmAccountCheckBox.click();
        return this;
    }
    public AddUsersPage selectActiveCheckBox(){
        activeCheckBox.click();
        return this;
    }
    public AddUsersPage clickAddUserCancelButton(){
        addUserCancelButton.click();
        return this;
    }
    public AddUsersPage clickAddUserSaveButton(){
        addUserSaveButton.click();
        return this;
    }
    public AddUsersPage clickAddNewNotificationTypeButton() throws InterruptedException {
        addNewNotificationTypeButton.click();
        return this;
    }
    public String errorMessageText(){
       return errorMessage.getText();
    }
}

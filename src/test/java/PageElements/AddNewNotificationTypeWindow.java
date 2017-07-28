package PageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ash on 7/28/2017.
 */
public class AddNewNotificationTypeWindow {
    @FindBy(xpath = "//*[@id=\"terms_name\"]")
    WebElement nameField;
    @FindBy(xpath = "//*[@id=\"notificationPopup\"]/form/div[2]/div/label/span")
    WebElement isDefaultCheckBox;
    @FindBy(xpath = "//*[@id=\"save_notification\"]")
    WebElement saveButton;
    @FindBy(xpath = "//*[@id=\"notificationPopup\"]/button")
    WebElement closeButton;

    WebDriver driver;

   public AddNewNotificationTypeWindow(WebDriver driver){
       this.driver=driver;
       PageFactory.initElements(this.driver,this);
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
   }
   public AddNewNotificationTypeWindow fillNameField(String name){
       nameField.sendKeys(name);
       return this;
   }
   public AddNewNotificationTypeWindow selectIsDefaultCheckBox(){
       isDefaultCheckBox.click();
       return  this;
   }
   public AddNewNotificationTypeWindow clickSaveButton(){
       saveButton.click();
       return this;
   }
   public AddNewNotificationTypeWindow clickCloseButton(){
       closeButton.click();
       return this;
   }

}

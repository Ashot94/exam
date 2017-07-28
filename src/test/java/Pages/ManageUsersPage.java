package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ash on 7/28/2017.
 */
public class ManageUsersPage {
@FindBy(id = "Admin")
WebElement adminButton;
@FindBy(xpath = "//*[@id=\"Add_User\"]")
WebElement addUserButton;
@FindBy(xpath = "/html/body/div/div[2]/ul/li[2]/p")
WebElement successMessage;
@FindBy(xpath = "//*[@id=\"search_input\"]")
WebElement searchInput;
@FindBy(xpath = "//*[@id=\"Search\"]")
WebElement searchButton;
@FindBy(xpath = "//*[@id=\"mCSB_6_container\"]/table/tbody/tr/td[4]")
WebElement editButton;

WebDriver driver;

public ManageUsersPage(WebDriver driver){
    this.driver=driver;
    PageFactory.initElements(this.driver,this);
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}
public ManageUsersPage adminButtonClick() throws InterruptedException {
    Thread.sleep(1000);
    adminButton.click();
    return this;
}
public ManageUsersPage addUserButtonClick() throws InterruptedException{
    addUserButton.click();
    return this;
}
public String successMessageText(){
        return successMessage.getText();
    }
  public ManageUsersPage fillSearchInput(String mail) throws InterruptedException {
    Thread.sleep(1000);
    searchInput.sendKeys(mail);
    return  this;
  }
  public ManageUsersPage clickSearchButton(){
      searchButton.click();
      return  this;
  }
  public ManageUsersPage editButtonClick() throws InterruptedException {
      Thread.sleep(500);
      editButton.click();
      return this;
  }
}

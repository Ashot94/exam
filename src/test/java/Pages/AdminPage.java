package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ash on 7/28/2017.
 */
public class AdminPage {
    @FindBy(xpath = "//*[@id=\"Manage_Users\"]")
    WebElement manageUsersBtn;
    WebDriver driver;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void manageUsersBtnClick() throws InterruptedException {
        Thread.sleep(1000);
        manageUsersBtn.click();
    }
}

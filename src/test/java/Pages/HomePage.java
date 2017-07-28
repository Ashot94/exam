package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ash on 7/28/2017.
 */
public class HomePage {

    @FindBy(xpath = "//*[@id=\"Login\"]")
            WebElement homePageLoginBtn;

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    public void setHomePageLoginBtnClick(){
        homePageLoginBtn.click();
    }
}

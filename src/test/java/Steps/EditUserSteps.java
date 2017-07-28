package Steps;

import Pages.AdminPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ManageUsersPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Ash on 7/28/2017.
 */
public class EditUserSteps {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    AdminPage adminPage;
    ManageUsersPage manageUsersPage;
    public String homePageUrl= "http://c2s.codebnb.me/";

    public EditUserSteps(WebDriver driver){
        this.driver=driver;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        manageUsersPage = new ManageUsersPage(driver);
        adminPage = new AdminPage(driver);
    }
    public void Login(){
        driver.get(homePageUrl);
        homePage.setHomePageLoginBtnClick();
        loginPage.fillEmailField().fillPasswordField().clickLogin();
    }
    public void goToAddUserPage() throws InterruptedException {
        adminPage.manageUsersBtnClick();
        manageUsersPage.adminButtonClick();
    }

}

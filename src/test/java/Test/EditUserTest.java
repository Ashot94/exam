package Test;

import Builders.UserBuilder;
import Builders.UsersSave;
import Pages.AddUsersPage;
import Pages.EditUserPage;
import Pages.ManageUsersPage;
import Steps.EditUserSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ash on 7/28/2017.
 */
public class EditUserTest {
    WebDriver driver;
    EditUserSteps editUserSteps;
    AddUsersPage addUsersPage;
    ManageUsersPage manageUsersPage;
    EditUserPage editUserPage;
    ChromeOptions options;
    UsersSave savedUsers;
    List<UserBuilder> users ;
    int i;
    @BeforeClass
    public void goToHomePage() throws IOException, ClassNotFoundException {
        options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.addArguments("--start-maximized");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ash\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver(options);
        editUserSteps = new EditUserSteps(driver);
        addUsersPage = new AddUsersPage(driver);
        manageUsersPage = new ManageUsersPage(driver);
        editUserPage = new EditUserPage(driver);
        users = new ArrayList<UserBuilder>();
        savedUsers= new UsersSave();
        users= savedUsers.readFromFile("users");
        i=users.size()-1;

    }
    @AfterMethod
    public void doit(){
        driver.close();
        driver = new ChromeDriver(options);
        editUserSteps = new EditUserSteps(driver);
        addUsersPage = new AddUsersPage(driver);
        manageUsersPage = new ManageUsersPage(driver);
    }

    @Test
    public void editUser() throws InterruptedException {
        System.out.print(users.get(0).eMail);
        editUserSteps.Login();
        editUserSteps.goToAddUserPage();
        manageUsersPage.fillSearchInput(users.get(i--).eMail).clickSearchButton()
               .editButtonClick();
        editUserPage.clickEnableEditingButton().changeFirstName("saro").changeLastNameField("Miq")
                .changeEmail("araz@gmail.com").checkCkeckBox();
    }
@AfterClass
void closeDr(){
    driver.close();
}
}

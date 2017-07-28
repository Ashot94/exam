package Test;

import Builders.UserBuilder;
import Builders.UsersSave;
import PageElements.AddNewNotificationTypeWindow;
import Pages.AddUsersPage;
import Pages.ManageUsersPage;
import Steps.CreateUserSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ash on 7/28/2017.
 */
public class AddUserTest {
    WebDriver driver;
    CreateUserSteps createUserSteps;
    AddUsersPage addUsersPage;
    ManageUsersPage manageUsersPage;
    ChromeOptions options;

    AddNewNotificationTypeWindow addNewNotificationTypeWindow;
    UserBuilder user;
    List<UserBuilder> users = new ArrayList<UserBuilder>();

    @BeforeClass
    public void goToHomePage() {
        options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.addArguments("--start-maximized");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ash\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver(options);
        createUserSteps = new CreateUserSteps(driver);
        addUsersPage = new AddUsersPage(driver);
        manageUsersPage = new ManageUsersPage(driver);
        addNewNotificationTypeWindow = new AddNewNotificationTypeWindow(driver);
    }
    @AfterMethod
    public void doit(){
        driver.close();
        driver = new ChromeDriver(options);
        createUserSteps = new CreateUserSteps(driver);
        addUsersPage = new AddUsersPage(driver);
        manageUsersPage = new ManageUsersPage(driver);
        addNewNotificationTypeWindow = new AddNewNotificationTypeWindow(driver);
    }

    @Test
    public void createNewUserWithSameEmails () throws InterruptedException, IOException {
        UsersSave save= new UsersSave();
        save.writeToFile(users);
        user= users.get(0);
        createUserSteps.Login();
        createUserSteps.goToAddUserPage();
        addUsersPage.setUserName(user.name).setUserLastName(user.lastName)
                .setUserMail(user.eMail).setUserPassword(user.password);
        addUsersPage.fillAddUserFirstNameField().fillAddUserLastNameField()
                .fillAddUserEmailField();
        // addUsersPage.addUserMessageTypes(1);
        addUsersPage.clickAddNewNotificationTypeButton();
        addNewNotificationTypeWindow.fillNameField("aaa").selectIsDefaultCheckBox().clickSaveButton();
        addUsersPage.selectPromptUserToConfirmAccountCheckBox().selectActiveCheckBox();
        addUsersPage.clickAddUserSaveButton();
        Assert.assertTrue(addUsersPage.errorMessageText().equals("A user with that email already exists."));

    }

    @Test
    public void createNewUser () throws InterruptedException {
        user= new UserBuilder();
        users.add(user);
        createUserSteps.Login();
        createUserSteps.goToAddUserPage();
        addUsersPage.setUserName(user.name).setUserLastName(user.lastName)
                .setUserMail(user.eMail).setUserPassword(user.password);
        addUsersPage.fillAddUserFirstNameField().fillAddUserLastNameField()
                .fillAddUserEmailField();
        // addUsersPage.addUserMessageTypes(1);
        addUsersPage.clickAddNewNotificationTypeButton();
        addNewNotificationTypeWindow.fillNameField("aaa").selectIsDefaultCheckBox().clickSaveButton();
        addUsersPage.selectPromptUserToConfirmAccountCheckBox().selectActiveCheckBox();
        addUsersPage.clickAddUserSaveButton();
        Assert.assertTrue(manageUsersPage.successMessageText().equals("Successfully created a new Admin User"));

    }
@AfterClass
    void closeDr(){
        driver.close();
}

}

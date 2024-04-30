package register;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.MyAccountPage;
import pages.SignUpSignInPage;

@Epic("Automation Exercise using SHAFT")
@Feature("User Managment ")
@Story("Create New Account")

public class CreateAccountsTests {

    private final String timeStamp = String.valueOf(System.currentTimeMillis());
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;

    @Test(description = "Create Account Test - GUI")
    @Description("Create a new account using valid data, so the account will be created and the user logged in to the system with successfull message")
    public void createNewAccountTestGui() {
        new HomePage(driver).
                validateVisibiltyOfSigninButton()
                .clickSignInButton();
        new SignUpSignInPage(driver)
                .validateCreateAccountVisibility(testData.getTestData("Messages.Signup"))
                .createNewAccount(testData.getTestData("UserMail") + timeStamp + "@test.com");
        new CreateAccountPage(driver)
                .validateVisibilityOfCreateAccountInfo(testData.getTestData("Messages.AccountInfo"))
                .enterAccountInfo(testData.getTestData("Gender"), testData.getTestData("UserFirstName"),
                        testData.getTestData("UserLastName"), testData.getTestData("UserPassword"),
                        testData.getTestData("UserBirthDay"), testData.getTestData("UserBirthMonth"),
                        testData.getTestData("UserBirthYear"));
        new MyAccountPage(driver)
                .validateSuccessfulAlert(testData.getTestData("Messages.AccountCreated"));


    }

    ///////////////////////////////// Configurations \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    @BeforeClass(description = "Configure the Test Data")
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/CreateAccountTestData.json");
    }

    @BeforeMethod(description = "Setup Browser instance.")
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
        new HomePage(driver).navigate();
    }

    @AfterMethod(description = "TearDown Browser instance.")
    public void afterMethod() {
        driver.quit();
    }
}

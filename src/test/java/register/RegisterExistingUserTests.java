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
import pages.HomePage;

@Epic("Automation Exercise using SHAFT")
@Feature("User Management")
@Story("Register an Existing User")
public class RegisterExistingUserTests {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;

    @Test(description = "Register an Existing User - GUI")
    @Description("Register a User with Existing User with the same email, and An error message will be displayed")
    public void registerExistingUserTestGui() {
        new HomePage(driver).validateVisibiltyOfSigninButton()
                .clickSignInButton()
                .registerWithExistUser(testData.getTestData("ExistingUserMail"))
                .validateExistUserErrorMessage(testData.getTestData("Messages.AccountExist"));
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

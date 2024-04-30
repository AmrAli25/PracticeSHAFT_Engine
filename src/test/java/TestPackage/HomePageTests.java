package TestPackage;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTests {
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;

    @Epic("Open My shop homePage")
    @Story("Validate HomePage Title")
    @Description("Given I am on the HomePage page,\nThen the browser title should be 'My shop'.")
    @Test(description = "Check that HomePage Page Title is correct.")
    public void checkHomePageTitleIsCorrect() {
        new HomePage(driver).verifyBrowserTitleIsCorrect();
    }

    @Epic("Open MyShop homePage")
    @Story("Validate HomePage SignIn button")
    @Description("Given I am on the HomePage page,\nThen the SignIn button in HomePage should be present.")
    @Test(description = "Check that SignIn button is present.")
    public void validateVisibilityOfSignInButtonInHomePage() {
        new HomePage(driver).validateVisibiltyOfSigninButton();
    }

    @Epic("Open MyShop homePage")
    @Story("Validate HomePage Categories Section")
    @Description("Given I am on the HomePage page,\nThen the Categories section in HomePage should be present.")
    @Test(description = "Check that Categories section is present.")
    public void validateVisibilityOfCategoriesSectionInHomePage() {
        new HomePage(driver).validateVisibilityOfHomeCategoriesSection();
    }

    @BeforeMethod(description = "Setup Browser instance.")
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
        new HomePage(driver).navigate();
    }

    @AfterMethod(description = "Teardown Browser instance.")
    public void afterMethod() {
        driver.quit();
    }
}

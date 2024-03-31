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

    @Epic("Open catcher homePage")
    @Story("Validate HomePage Title")
    @Description("Given I am on the HomePage page,\nThen the browser title should be 'Catcher | HomePage'.")
    @Test(description = "Check that HomePage Page Title is correct.")
    public void checkHomePageTitleIsCorrect() {
        new HomePage(driver).verifyBrowserTitleIsCorrect();
    }

    @Epic("Open catcher homePage")
    @Story("Validate HomePage Sections")
    @Description("Given I am on the HomePage page,\nThen the sections in HomePage should be present.")
    @Test(description = "Check that Categories section is present.")
    public void validateCategoriesSectionInHomePage() {
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

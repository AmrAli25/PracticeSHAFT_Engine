package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MyAccountPage {

    // Variables
    private SHAFT.GUI.WebDriver driver;

    // Locators
    private By successAlert = By.cssSelector("p[class='alert alert-success']");

    // Constructor
    public MyAccountPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    /////////////////////////////// Validations \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    @Step("Validate that user was created successfully")
    public MyAccountPage validateSuccessfulAlert(String expectedAlert) {
        driver.verifyThat().element(successAlert).text().equalsIgnoringCaseSensitivity(expectedAlert).perform();
        return this;
    }

}

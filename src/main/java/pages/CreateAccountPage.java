package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CreateAccountPage {

    // Variables
    private SHAFT.GUI.WebDriver driver;

    // Locators
    private By createAccountHeader = By.cssSelector("div>h3[class='page-subheading']");
    private By firstNameInput = By.id("customer_firstname");
    private By lastNameInput = By.id("customer_lastname");
    private By passwordInput = By.id("passwd");
    private By daysInput = By.id("days");
    private By monthsInput = By.id("months");
    private By yearsInput = By.id("years");
    private By submitButton = By.id("submitAccount");

    // Constructor
    public CreateAccountPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By genderInput(String gender) {
        return By.id("id_gender" + gender);
    }

    //////////////////////////////////// Validations \\\\\\\\\\\\\\\\\\\\\\\\\\

    @Step("Validate on Visibility of create account fields ")
    public CreateAccountPage validateVisibilityOfCreateAccountInfo(String expectedText) {
        driver.verifyThat().element(createAccountHeader).text().equalsIgnoringCaseSensitivity(expectedText).perform();
        return this;
    }

    ////////////////////////////////// Actions \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    @Step("Enter account information")
    public MyAccountPage enterAccountInfo(String gender, String firstName, String lastName, String password, String days, String months, String years) {
        driver.element()
                .click(genderInput(gender))
                .type(firstNameInput, firstName)
                .type(lastNameInput, lastName)
                .type(passwordInput, password)
                .select(daysInput, days)
                .select(monthsInput, months)
                .select(yearsInput, years)
                .click(submitButton);
        return new MyAccountPage(driver);
    }


}

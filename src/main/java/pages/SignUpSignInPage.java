package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SignUpSignInPage {
    //variables
    private SHAFT.GUI.WebDriver driver;

    // Locators
    private By createAccountDiv = By.id("create-account_form");
    private By createAccountHeading = By.cssSelector("#create-account_form > h3[class='page-subheading']");
    private By emailFieldInput = By.id("email_create");
    private By createAccountButton = By.id("SubmitCreate");
    private By existAccountError = By.id("create_account_error");

    public SignUpSignInPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //////////////////////////////////// Validations \\\\\\\\\\\\\\\\\\\\\\\\\\
    @Step("Validate that the create account section is visible")
    public SignUpSignInPage validateCreateAccountVisibility(String expectedResults) {
        driver.verifyThat().element(createAccountDiv).exists().perform();
        driver.verifyThat().element(createAccountHeading).text().isEqualTo(expectedResults).perform();
        return this;
    }

    @Step("Validate that the error message for existed Account will be displayed")
    public SignUpSignInPage validateExistUserErrorMessage(String expectedMessage) {
        driver.verifyThat().element(existAccountError).text().isEqualTo(expectedMessage).perform();
        return this;
    }

    ////////////////////////////////// Actions \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @Step("Create new Account with email: {email}")
    public CreateAccountPage createNewAccount(String email) {
        driver.element().type(emailFieldInput, email).click(createAccountButton);
        return new CreateAccountPage(driver);
    }

    @Step("Register with existed account with email : {email}")
    public SignUpSignInPage registerWithExistUser(String email) {
        driver.element().type(emailFieldInput, email).click(createAccountButton);
        return this;
    }

}

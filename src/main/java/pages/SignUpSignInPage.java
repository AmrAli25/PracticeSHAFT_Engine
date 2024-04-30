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

    public SignUpSignInPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }
    //////////////////////////////////// Validations \\\\\\\\\\\\\\\\\\\\\\\\\\
    @Step("Validate that the create account section is visible")
    public SignUpSignInPage validateCreateAccountVisibility(String expectedResults){
        driver.verifyThat().element(createAccountDiv).exists().perform();
        driver.verifyThat().element(createAccountHeading).text().isEqualTo(expectedResults).perform();
        return this;
    }
    ////////////////////////////////// Actions \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @Step("Create new Account with email: {email}")
    public CreateAccountPage createNewAccount(String email){
        driver.element().type(emailFieldInput, email).click(createAccountButton);
        return new CreateAccountPage(driver);
    }

}

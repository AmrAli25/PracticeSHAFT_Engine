package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage {
    // Variables
    private SHAFT.GUI.WebDriver driver;
    private String url = System.getProperty("baseURL");

    //Locators
    private By categoriesSection = By.cssSelector("a[class='homefeatured']");
    private By signIn = By.cssSelector("a[class='login']");


    // Constructor
    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    ////////////////////////////////// Actions \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @Step("When I navigate to the HomePage page.")
    public HomePage navigate() {
        driver.browser().navigateToURL(url);
        return this;
    }

    @Step("Go to SingIn and SignUp page ")
    public SignUpSignInPage clickSignInButton() {
        driver.element().click(signIn);
        return new SignUpSignInPage(driver);
    }

    ///////////////////////////////////// Validations \\\\\\\\\\\\\\\\\\\\\\\\\\

    @Step("Then the browser title should be 'Catcher'.")
    public HomePage verifyBrowserTitleIsCorrect() {
        driver.verifyThat().browser().title().isEqualTo("My Shop");
        return this;
    }

    @Step("Validate the visibility of categories section ")
    public HomePage validateVisibilityOfHomeCategoriesSection() {
        driver.verifyThat().element(categoriesSection).isVisible().perform();
        return this;
    }

    @Step("Validate the visibility of Sign in button")
    public HomePage validateVisibiltyOfSigninButton() {
        driver.verifyThat().element(signIn).exists().perform();
        return this;
    }


}

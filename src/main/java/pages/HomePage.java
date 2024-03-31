package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage {
    // Variables
    private SHAFT.GUI.WebDriver driver;
    private String url = System.getProperty("baseURL");

    //Locators
    private By categoriesSection = By.cssSelector("div.categoriesItems");
    private By loginBtn = By.cssSelector("a[title=\"Login\"]");

    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("When I navigate to the HomePage page.")
    public HomePage navigate() {
        driver.browser().navigateToURL(url);
        return this;
    }

    @Step("Then the browser title should be 'Catcher'.")
    public HomePage verifyBrowserTitleIsCorrect() {
        driver.verifyThat().browser().title().isEqualTo("Catcher | Home Page");
        return this;
    }

    @Step("Validate the visibility of categories section ")
    public HomePage validateVisibilityOfHomeCategoriesSection() {
        driver.verifyThat().element(categoriesSection).exists().perform();
        return this;
    }
}

package onliner.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private String loginInputsLoc = "//input[@data-field=\"login\"]";
    private String submitButtonLoc = "//*[contains(text(), \"Войти\")]";


    private By loginPasswordLocator = By.xpath(loginInputsLoc);
    private By submitButtonLocator = By.xpath(submitButtonLoc);


    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage typeLogin(String login) {
        driver.findElements(loginPasswordLocator).get(0).sendKeys(login);
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElements(loginPasswordLocator).get(1).sendKeys(password);
        return this;
    }

    public SmsValidationPage submitLogin() {
        WebElement submitButton = driver.findElement(submitButtonLocator);
        System.out.println(submitButton.isDisplayed());
        submitButton.sendKeys(Keys.RETURN);
        return new SmsValidationPage(driver);
    }

    public SmsValidationPage loginAs(String login, String password) {
        typeLogin(login);
        typePassword(password);
        return submitLogin();
    }

}

package onliner.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SmsValidationPage {

    private By logoutButtonLocator = By.xpath("//*[contains(text(), \"Выйти\")]");
    private By logoutListLocator = By.xpath("//div[@data-bind=\"visible: $root.currentUser.id()\"]/div/a[@href=\"https://profile.onliner.by\"]");
    private By mainPageLocator = By.xpath("//a[@title=\"Onliner\"]");

    private final WebDriver driver;

    public SmsValidationPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage logout() {
        driver.findElement(logoutListLocator).click();
        WebElement logoutButton = driver.findElement(logoutButtonLocator);
        WebElement explicitWait = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(logoutButton));
        logoutButton.click();
        driver.findElement(mainPageLocator).click();
        return new HomePage(driver);
    }
}

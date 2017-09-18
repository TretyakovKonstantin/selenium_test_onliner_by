package onliner.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PopularCategoryPage {
    private WebDriver driver;
    private String name;

    By nameLocator = By.xpath("//div/div/h1");
    By logo = By.xpath("//a[@href=\"https://www.onliner.by/\"]");

    public PopularCategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public PopularCategoryPage(WebDriver driver, String name) {
        this.driver = driver;
        this.name = name;
    }

    public boolean checkPageName() {
        return name.equals(driver.findElement(nameLocator).getText());
    }

    public HomePage goToHomePage() {
        driver.findElement(logo).click();
        return new HomePage(driver);
    }
}

package onliner.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.regex.Pattern;

public class HomePage {

    private By loginBtn = By.xpath("//div[@onclick=\"MODELS.AuthController.showModalAuth()\"]");
    private By PopularElementNames = By.className("project-navigation__sign");

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage login() {
        driver.findElement(loginBtn).click();
        return new LoginPage(driver);
    }

    public PopularCategoryPage goToRandomPopularCategory() {
        List<WebElement> popularCategoryNames = driver.findElements(PopularElementNames);
        int randNum = (int) (Math.random() * (popularCategoryNames.size() - 2));
        String name = popularCategoryNames.get(randNum).getText();
        System.out.println(name);
        WebElement popularCategoryPageName = popularCategoryNames.get(randNum);
        WebElement popularCategoryPageLink = popularCategoryPageName.findElement(By.xpath("./../.."));
        popularCategoryPageLink.click();

        return new PopularCategoryPage(driver, name);
    }

    public void getAllOpinions() {
        Pattern pattern = Pattern.compile("");
        String[] pageSourceLines = driver.getPageSource().split("\n");
        System.out.println(pageSourceLines.length);
    }

}

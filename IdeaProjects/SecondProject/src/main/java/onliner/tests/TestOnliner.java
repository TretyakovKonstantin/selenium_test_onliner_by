package onliner.tests;

import onliner.forms.HomePage;
import onliner.forms.LoginPage;
import onliner.forms.PopularCategoryPage;
import onliner.forms.SmsValidationPage;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class TestOnliner {

    private WebDriver driver;
    private Properties props;

    @BeforeMethod
    public void initDrivers() {
        driver = Browser.getInstance().getDriver();
        driver.get("http://onliner.by/");
        props = Browser.getInstance().getProps();
    }

    @Test
    public void testOnlinerBy() {
        HomePage homePage = new HomePage(driver);
//        LoginPage loginPage = homePage.login();
//        SmsValidationPage smsValidationPage = loginPage.loginAs(props.getProperty("login"), props.getProperty("password"));
//        homePage = smsValidationPage.logout();

        PopularCategoryPage popularCategoryPage = homePage.goToRandomPopularCategory();
        popularCategoryPage.checkPageName();
        homePage = popularCategoryPage.goToHomePage();
        Assert.assertTrue(popularCategoryPage.checkPageName());
        homePage.getAllOpinions();
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
    }

}

package onliner.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Browser {
    private static Browser ourInstance = new Browser();

    public static Browser getInstance() {
        return ourInstance;
    }

    private WebDriver driver;
    private Properties props;

    public WebDriver getDriver() {
        return driver;
    }

    ;

    private Browser() {
        props = getProps();
        switch (props.getProperty("browser")) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
                driver = new ChromeDriver();
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
                File pathToBinary = new File("C:\\Users\\treti\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
                FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
                FirefoxProfile firefoxProfile = new FirefoxProfile();
                driver = new FirefoxDriver(ffBinary, firefoxProfile);
                break;

            case "edge":
                System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\MicrosoftWebDriver.exe");
                driver = new ChromeDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public Properties getProps() {
        try {
            InputStream input = new FileInputStream("src\\main\\resources\\config.properties");
            Properties props = new Properties();
            props.load(input);
            return props;
        } catch (IOException e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "Не удалось загрузить конфигурационный файл");
            System.exit(-1);
            return null;
        }
    }
}

package com.marriott.ui.driver;

import com.marriott.ui.config.SettingsReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.time.Duration;

public class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver createDriver() {

        String browser = SettingsReader.getBrowser().toLowerCase();
        WebDriver driver;

        switch (browser) {

            case "chrome":
                setChromeDriverPath();

                ChromeOptions chromeOptions = new ChromeOptions();

                if (SettingsReader.isHeadless()) {
                    chromeOptions.addArguments("--headless=new");
                }

                chromeOptions.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                setGeckoDriverPath();

                FirefoxOptions firefoxOptions = new FirefoxOptions();

                if (SettingsReader.isHeadless()) {
                    firefoxOptions.addArguments("-headless");
                }

                driver = new FirefoxDriver(firefoxOptions);
                break;

            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(SettingsReader.getImplicitWait()));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(SettingsReader.getPageLoadTimeout()));

        if (SettingsReader.isMaximize()) {
            driver.manage().window().maximize();
        }

        return driver;
    }

    private static void setChromeDriverPath() {
        String path = ".." + File.separator + "drivers" + File.separator + "linux" + File.separator + "chromedriver";
        validateDriverFile(path);
        System.setProperty("webdriver.chrome.driver", path);
    }

    private static void setGeckoDriverPath() {
        String path = ".." + File.separator + "drivers" + File.separator + "linux" + File.separator + "geckodriver";
        validateDriverFile(path);
        System.setProperty("webdriver.gecko.driver", path);
    }

    private static void validateDriverFile(String path) {
        File file = new File(path);

        if (!file.exists()) {
            throw new RuntimeException("Driver file not found: " + file.getAbsolutePath());
        }

        if (!file.canExecute()) {
            throw new RuntimeException("Driver file is not executable. Run: chmod +x " + file.getPath());
        }
    }
}
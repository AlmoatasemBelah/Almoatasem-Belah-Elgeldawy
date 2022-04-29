package DriverSingleton;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSingleton {
    static String chromePath = "D:\\Instabug\\src\\main\\resources\\chromedriver.exe";
    static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

    public static WebDriver setDriver(){
        try {
            System.setProperty("webdriver.chrome.driver", chromePath);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("use-fake-ui-for-media-stream");
            driver = new ChromeDriver(options);
            return driver;
        } catch (SessionNotCreatedException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

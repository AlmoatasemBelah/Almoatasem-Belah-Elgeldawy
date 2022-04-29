package BrowserActions;

import DriverSingleton.DriverSingleton;
import org.openqa.selenium.*;

public class browserActions {
    public static WebDriver getDriver(){
        return DriverSingleton.getDriver();
    }

    public static void setDriver(){
        DriverSingleton.setDriver();

    }
    public static void maximize(){
        getDriver().manage().window().maximize();
    }
    public static void navigate(String url){
        getDriver().get(url);
    }
    public static WebElement getElement(String element){
        return getDriver().findElement(By.cssSelector(element));
    }
    public static void Write(String element, String page){
        getDriver().findElement(By.cssSelector(element)).sendKeys(page);
    }
    public static String gettext(String element){
        return getDriver().findElement(By.cssSelector(element)).getText();
    }
    public static String getUrl(){
        return getDriver().getCurrentUrl();
    }
    public static boolean elementexist(String element){
        try {
            getDriver().findElement(By.cssSelector(element));
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }


    public static Rectangle getlocation(String element){
       Rectangle location =  getDriver().findElement(By.cssSelector(element)).getRect();
        return location;
    }
    public static void close(){
        getDriver().quit();
    }

}

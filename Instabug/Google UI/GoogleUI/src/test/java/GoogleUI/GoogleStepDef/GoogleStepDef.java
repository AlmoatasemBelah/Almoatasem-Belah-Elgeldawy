package GoogleUI.GoogleStepDef;

import BrowserActions.browserActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;

public class GoogleStepDef {
    @Given("Web browser is accessed")
    public void webBrowserIsAccessed() {
        browserActions.setDriver();
        browserActions.maximize();
    }

    @And("browser navigates to Google.com")
    public void browserNavigatesToGoogleCom() {
        browserActions.navigate("https://www.google.com");
    }

    @Given("Google website is opened")
    public void googleWebsiteIsOpened() {
        Assert.assertTrue(browserActions.getUrl().contains("google"));
    }

    @Then("Verify Google logo location")
    public void verifyGoogleLogoLocation() {
        int googleWidth = 272;
        int googleHeight = 92;
        int googleX= 547;
        int googleY = 60;
        Rectangle google= browserActions.getlocation("[class=\"lnXdpd\"]");
        Assert.assertEquals(google.width,googleWidth);
        Assert.assertEquals(google.height, googleHeight);
        Assert.assertEquals(google.x, googleX);
        Assert.assertEquals(google.y,googleY);
    }

    @And("Search box location")
    public void searchBoxLocation() {
        int widthSearch = 584;
        int heightSearch = 46;
        int xSearch = 391;
        int ySearch = 178;
        Rectangle searchGoogle = browserActions.getlocation("[class=\"RNNXgb\"]");
        Assert.assertEquals(widthSearch, searchGoogle.width);
        Assert.assertEquals(heightSearch, searchGoogle.height);
        Assert.assertEquals(xSearch, searchGoogle.x);
        Assert.assertEquals(ySearch, searchGoogle.y);
    }

    @And("Mic is displayed in its location")
    public void micIsDisplayedInItsLocation() {
        int micWidth= 24;
        int micHeight=24;
        int micX =934;
        int micY= 189;
        Assert.assertTrue(browserActions.getElement("[class=\"goxjub\"]").isDisplayed());
        Rectangle mic = browserActions.getlocation("[class=\"goxjub\"]");
        Assert.assertEquals(micWidth,mic.width);
        Assert.assertEquals(micHeight, mic.height);
        Assert.assertEquals(micX, mic.x);
        Assert.assertEquals(micY, mic.y);
    }

    @And("Mic is clickable")
    public void micIsClickable() {
        browserActions.getElement("[class=\"goxjub\"]").click();

    }

    @And("Arabic language option is available")
    public void arabicLanguageOptionIsAvailable() {
        browserActions.navigate("https://www.google.com");
        browserActions.getElement("[dir=\"rtl\"]").click();
        browserActions.getElement("[class=\"ly0Ckb\"]").click();
        while (true){
            if (browserActions.elementexist("[id=\"kbd\"]")){
                break;
            }
        }
        Assert.assertTrue(browserActions.getElement("[id=\"kbd\"]").isDisplayed());
    }

    @And("Google sign in is clickable")
    public void googleSignInIsClickable() {
        browserActions.navigate("https://www.google.com");
        browserActions.getElement("[class=\"gb_1 gb_2 gb_9d gb_9c\"]").click();
        Assert.assertTrue(browserActions.getElement("[type=\"email\"]").isDisplayed());
    }


    @Given("User enter {string} in search box")
    public void userEnterInSearchBox(String Data) {
        browserActions.Write("[name=\"q\"]",Data);

    }
    @Then("click on google submit")
    public void clickOnGoogleSubmit() {
        while (true){
            if (browserActions.getElement("[name=\"btnK\"]").isDisplayed())
                break;
        }
        browserActions.getElement("[name=\"btnK\"]").click();

    }

    @Then("click on first link shown in results page")
    public void clickOnFirstLinkShownInResultsPage() {
        browserActions.getElement("[class=\"LC20lb MBeuO DKV0Md\"]").click();

    }

    @Then("Get url of this page")
    public void getUrlOfThisPage() {
        Assert.assertEquals("https://www.youtube.com/",browserActions.getUrl());

    }
    @Then("Click on lucky button")
    public void clickOnLuckyButton() {
        while(true){
            if (browserActions.getDriver().findElement(By.cssSelector("[name=\"btnI\"]")).isDisplayed()){
                break;
            }
        }
        browserActions.getElement("[name=\"btnI\"]").click();
    }

    @Then("click on next page")
    public void clickOnNextPage() {
        while (true){
            if(browserActions.elementexist("[style=\"display:block;margin-left:53px\"]"))
                break;
        }
        browserActions.getElement("[style=\"display:block;margin-left:53px\"]").click();

    }

    @Given("User click on images")
    public void userClickOnImages() {
        browserActions.getElement("[data-pid=\"2\"]").click();
    }
    @Then("press enter")
    public void pressEnter() {
        browserActions.getElement("[class=\"z1asCe MZy1Rb\"]").click();
    }

    @Then("Verify filter bar is displayed")
    public void verifyFilterBarIsDisplayed() {
        boolean flag = browserActions.getElement("[jsname=\"haAclf\"]").isDisplayed();

    }

    @Then("show user location")
    public void showUserLocation() {
        Assert.assertEquals("Egypt",browserActions.gettext("[class=\"uU7dJb\"]"));
    }
    @After()
    public void close(){
        browserActions.close();
    }

}

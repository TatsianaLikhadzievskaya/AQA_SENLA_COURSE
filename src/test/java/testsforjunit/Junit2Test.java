package testsforjunit;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;
import utils.Log;

import static locators.MainPageLocators.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class Junit2Test {

    private WebDriver driver = Driver.getChromeDriver();

    @BeforeEach
    public void setUp(){

        Log.info("Open a.testaddressbook.com");
        driver.get("http://a.testaddressbook.com/sign_in");
        driver.manage().window().maximize();

        Log.info("Check the correctness of site page a.testaddressbook.com by URL");
        String currentURL = driver.getCurrentUrl();
        Assertions.assertEquals("http://a.testaddressbook.com/sign_in", currentURL, "This site is not testaddressbook or URL is not correct");

        Log.info("Login on a.testaddressbook.com");
        driver.findElement(SESSION_EMAIL).sendKeys("www@www.www");
        driver.findElement(SESSION_PASSWORD).sendKeys("wwwwww");
        driver.findElement(SIGN_IN).click();
    }

    @Step("Review address from the address list")
    @Severity(SeverityLevel.NORMAL)
    @Description("Review address list test")
    @Feature("Address list review")
    @Story("Review")
    @Epic("Address list")
    @Link("http://a.testaddressbook.com/addresses")
    @Issue("TC-004")
    @Test
    @Order(1)
    public void reviewAddressListTest(){
        Log.info("Transfer to Address List");
        driver.findElement(ADDRESS_LIST).click();

        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("http://a.testaddressbook.com/addresses", currentUrl, "could not show addresses");
    }

    @Step("Sign out from the addressbook")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Sign out test")
    @Feature("Signing out check")
    @Story("Sign out")
    @Epic("User signout")
    @Link("http://a.testaddressbook.com/sign_in")
    @Issue("TC-005")
    @Test
    @Order(2)
    public void signOutTest() {

        Log.info("Logout from a.testaddressbook.com");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(SIGN_OUT));
        driver.findElement(SIGN_OUT).click();

        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("http://a.testaddressbook.com/sign_in", currentUrl, "could not sign out");

    }

    @AfterAll
    public void tearDown(){

        Log.info("Close the current browser page");
        driver.quit();
    }
}

package testsforjunit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import utils.Driver;
import utils.Log;

import static locators.MainPageLocators.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class JunitTest {

    private WebDriver driver = Driver.getChromeDriver();

    @BeforeAll
    public void setUp(){

        Log.info("Open a.testaddressbook.com");
        driver.get("http://a.testaddressbook.com/sign_in");
        driver.manage().window().maximize();

        Log.info("Check the correctness of site page a.testaddressbook.com by Title");
        String pageTitle = driver.getTitle();
        Assertions.assertEquals("Address Book - Sign In", pageTitle, "This site is not testaddressbook or page title is not correct");

        Log.info("Login on a.testaddressbook.com");
        driver.findElement(SESSION_EMAIL).sendKeys("www@www.www");
        driver.findElement(SESSION_PASSWORD).sendKeys("wwwwww");
        driver.findElement(SIGN_IN).click();
    }

    @Test
    @Order(1)
    public void addAddressTest(){
        Log.info("Сreate new address page");
        driver.findElement(ADDRESS_LIST).click();
        driver.findElement(NEW_ADDRESS).click();
        driver.findElement(FIRST_NAME).sendKeys("Mary");
        driver.findElement(LAST_NAME).sendKeys("Jackson");
        driver.findElement(STREET_ADDRESS).sendKeys("499 Fort Washington Ave #APT 5A");
        driver.findElement(SECONDARY_ADDRESS).sendKeys("60 Gramercy Park N #2");
        driver.findElement(CITY).sendKeys("New York");
        driver.findElement(STATE).click();
        driver.findElement(OPTION_VALUE).click();
        driver.findElement(ZIP_CODE).sendKeys("10033");
        driver.findElement(INPUT_VALUE).click();
        driver.findElement(BIRTHDAY).sendKeys("03.03.1990");
        driver.findElement(ADDRESS_COLOR).sendKeys("#EE82EE");
        driver.findElement(AGE).sendKeys("31");
        driver.findElement( WEBSITE).sendKeys("https://www.postable.com/address-book");
        driver.findElement(CONTACT_PHONE).sendKeys("(212)737-2344");
        driver.findElement(INTEREST).click();
        driver.findElement(NOTES).sendKeys("Work details: (212) 928-6199, 60 Haven Ave, New York, New York(NY), 10032");
        driver.findElement(CREATE_ADDRESS).click();

        String pageNotice = driver.findElement(CREATED_NOTICE).getText();
        Assertions.assertEquals("Address was successfully created.", pageNotice, "not created");

        String pageName = driver.findElement(CREATED_FIRST_NAME).getText();
        Assertions.assertEquals("Mary", pageName, "created name is not correct");

        String pageWebsite = driver.findElement(CREATED_WEBSITE).getText();
        Assertions.assertEquals("https://www.postable.com/address-book", pageWebsite, "created website is not correct");

        String pagePhone = driver.findElement(CREATED_PHONE).getText();
        Assertions.assertEquals("(212)737-2344", pagePhone, "created phone is not correct");
    }

    @Test
    @Order(2)
    public void editAddress(){
        Log.info("Edit existing address page");
        driver.findElement(ADDRESS_LIST).click();
        driver.findElement(EDIT).click();
        driver.findElement(STREET_ADDRESS).clear();
        driver.findElement(STREET_ADDRESS).sendKeys("3225 Oakway Lane");
        driver.findElement(SECONDARY_ADDRESS).clear();
        driver.findElement(SECONDARY_ADDRESS).sendKeys("10900 Wilshire Blvd #1600");
        driver.findElement(CITY).clear();
        driver.findElement(CITY).sendKeys("Los Angeles");
        driver.findElement(STATE).click();
        driver.findElement(OPTION_VALUE2 ).click();
        driver.findElement(ZIP_CODE).clear();
        driver.findElement(ZIP_CODE).sendKeys("90024");
        driver.findElement(ADDRESS_COLOR).sendKeys("#0000FF");
        driver.findElement(WEBSITE).clear();
        driver.findElement(WEBSITE).sendKeys("https://secure.rolosync.com/");
        driver.findElement(CONTACT_PHONE).clear();
        driver.findElement(CONTACT_PHONE).sendKeys("(661)664-6428");
        driver.findElement(NOTES).clear();
        driver.findElement(NOTES).sendKeys("Permanent move to Los Angeles. New work details: (213)747-0819,2600 S Hoover St,Los Angeles, California(CA), 90007");
        driver.findElement(UPDATE_ADDRESS).click();

        String pageUpdateNotice = driver.findElement(UPDATED_NOTICE).getText();
        Assertions.assertEquals("Address was successfully updated.", pageUpdateNotice, "not updated");

        String pageUpdateCity = driver.findElement(UPDATED_CITY).getText();
        Assertions.assertEquals("Los Angeles", pageUpdateCity, "updated city is not correct");

        String pageUpdateWebsite = driver.findElement(CREATED_WEBSITE).getText();
        Assertions.assertEquals("https://secure.rolosync.com/", pageUpdateWebsite, "updated website is not correct");

        String pageUpdatePhone = driver.findElement(CREATED_PHONE).getText();
        Assertions.assertEquals("(661)664-6428", pageUpdatePhone, "updated phone is not correct");

    }


    @Test
    @Order(3)
    public void deleteAddress(){
        Log.info("Delete Address from the Address List");

        driver.findElement(ADDRESS_LIST).click();

        driver.findElement(DELETE_ADDRESS).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        String pageDeleteNotice = driver.findElement(DELETED_NOTICE).getText();
        Assertions.assertEquals("Address was successfully destroyed.", pageDeleteNotice, "not deleted");

    }

    @AfterAll
    public void tearDown(){

        Log.info("Close the current browser page");
        driver.quit();
    }

}






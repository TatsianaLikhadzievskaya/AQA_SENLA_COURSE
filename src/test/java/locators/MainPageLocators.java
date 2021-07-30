package locators;

import org.openqa.selenium.By;

public class MainPageLocators {

    public static final By SESSION_EMAIL = By.id("session_email");
    public static final By SESSION_PASSWORD = By.name("session[password]");
    public static final By SIGN_IN = By.cssSelector("input[value='Sign in']");
    public static final By SIGN_OUT = By.cssSelector("a[data-test='sign-out']");

    public static final By ADDRESS_LIST = By.cssSelector("a[href='/addresses']");
    public static final By NEW_ADDRESS = By.cssSelector("a[href='/addresses/new']");
    public static final By FIRST_NAME = By.name("address[first_name]");
    public static final By LAST_NAME = By.name("address[last_name]");
    public static final By STREET_ADDRESS = By.id("address_street_address");
    public static final By SECONDARY_ADDRESS = By.id("address_secondary_address");
    public static final By CITY = By.name("address[city]");
    public static final By STATE = By.cssSelector("select[name='address[state]']");

    public static final By OPTION_VALUE = By.cssSelector("option[value='NY']");
    public static final By ZIP_CODE = By.name("address[zip_code]");
    public static final By INPUT_VALUE = By.xpath("//input[@value='us']") ;
    public static final By BIRTHDAY = By.name("address[birthday]");
    public static final By ADDRESS_COLOR = By.id("address_color");
    public static final By AGE = By.id("address_age");
    public static final By WEBSITE = By.name("address[website]");
    public static final By CONTACT_PHONE = By.id("address_phone");
    public static final By INTEREST = By.xpath("//label[@for='address_interest_read']");
    public static final By NOTES = By.name("address[note]");
    public static final By CREATE_ADDRESS = By.xpath("//input[@value='Create Address']");

    public static final By EDIT = By.cssSelector("a[data-test='edit']");
    public static final By OPTION_VALUE2 = By.cssSelector("option[value='CA']");
    public static final By UPDATE_ADDRESS = By.xpath("//input[@value='Update Address']");

    public static final By DELETE_ADDRESS = By.cssSelector("a[data-confirm='Are you sure?']");

    public static final By CREATED_NOTICE = By.cssSelector("div[class='alert alert-notice']");
    public static final By CREATED_FIRST_NAME = By.cssSelector("span[class='col offset-1 offset-sm-0']");
    public static final By CREATED_WEBSITE = By.cssSelector("span[data-test='website']");
    public static final By CREATED_PHONE = By.cssSelector("span[data-test='phone']");

    public static final By UPDATED_NOTICE = By.xpath("//div[text()= 'Address was successfully updated.']");
    public static final By UPDATED_CITY = By.cssSelector("span[data-test='city']");

    public static final By DELETED_NOTICE = By.xpath("//div[text()= 'Address was successfully destroyed.']");

}



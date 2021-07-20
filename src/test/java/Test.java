import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class Test {
    public static void main(String[] args)  {
        System.setProperty("webdriver.chrome.driver", "E:\\webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://a.testaddressbook.com/sign_in");
        driver.manage().window().maximize();
        
        //Login
        driver.findElement(By.id("session_email")).sendKeys("www@www.www");
        driver.findElement(By.name("session[password]")).sendKeys("wwwwww");
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();

        //Add address
        driver.findElement(By.cssSelector("a[href='/addresses']")).click();
        driver.findElement(By.cssSelector("a[href='/addresses/new']")).click();
        driver.findElement(By.name("address[first_name]")).sendKeys("Mary");
        driver.findElement(By.name("address[last_name]")).sendKeys("Jackson");
        driver.findElement(By.id("address_street_address")).sendKeys("499 Fort Washington Ave #APT 5A");
        driver.findElement(By.id("address_secondary_address")).sendKeys("60 Gramercy Park N #2");
        driver.findElement(By.name("address[city]")).sendKeys("New York");
        driver.findElement(By.cssSelector("select[name='address[state]']")).click();
        driver.findElement(By.cssSelector("option[value='NY']")).click();
        driver.findElement(By.name("address[zip_code]")).sendKeys("10033");
        driver.findElement(By.xpath("//input[@value='us']")).click();
        driver.findElement(By.name("address[birthday]")).sendKeys("03.03.1990");
        driver.findElement(By.id("address_color")).sendKeys("#EE82EE");
        driver.findElement(By.id("address_age")).sendKeys("31");
        driver.findElement(By.name("address[website]")).sendKeys("https://www.postable.com/address-book");
        driver.findElement(By.id("address_phone")).sendKeys("(212)737-2344");
        driver.findElement(By.xpath("//label[@for='address_interest_read']")).click();
        driver.findElement(By.name("address[note]")).sendKeys("Work details: (212) 928-6199, 60 Haven Ave, New York, New York(NY), 10032");
        driver.findElement(By.xpath("//input[@value='Create Address']")).click();


        //Edit address
        driver.findElement(By.cssSelector("a[data-test='edit']")).click();
        driver.findElement(By.id("address_street_address")).clear();
        driver.findElement(By.id("address_street_address")).sendKeys("3225 Oakway Lane");
        driver.findElement(By.id("address_secondary_address")).clear();
        driver.findElement(By.id("address_secondary_address")).sendKeys("10900 Wilshire Blvd #1600");
        driver.findElement(By.name("address[city]")).clear();
        driver.findElement(By.name("address[city]")).sendKeys("Los Angeles");
        driver.findElement(By.cssSelector("select[name='address[state]']")).click();
        driver.findElement(By.cssSelector("option[value='CA']")).click();
        driver.findElement(By.name("address[zip_code]")).clear();
        driver.findElement(By.name("address[zip_code]")).sendKeys("90024");
        driver.findElement(By.id("address_color")).sendKeys("#0000FF");
        driver.findElement(By.name("address[website]")).clear();
        driver.findElement(By.name("address[website]")).sendKeys("https://secure.rolosync.com/");
        driver.findElement(By.id("address_phone")).clear();
        driver.findElement(By.id("address_phone")).sendKeys("(661)664-6428");
        driver.findElement(By.name("address[note]")).clear();
        driver.findElement(By.name("address[note]")).sendKeys("Permanent move to Los Angeles. New work details: (213)747-0819,2600 S Hoover St,Los Angeles, California(CA), 90007");
        driver.findElement(By.xpath("//input[@value='Update Address']")).click();

        //Transfer to Addresses List
        driver.findElement(By.cssSelector("a[data-test='list']")).click();

        //Delete address
        driver.findElement(By.cssSelector("a[data-confirm='Are you sure?']")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //Sign out
        driver.findElement(By.cssSelector("a[data-test='sign-out']")).click();

        driver.close();
        driver.quit();
    }
}

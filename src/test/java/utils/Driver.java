package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


import java.time.Duration;

public class Driver {

    private static WebDriver driver;

    private static void initializeChromeDriver(){
        System.setProperty("webdriver.chrome.driver", "E:\\webdriver\\chromedriver.exe");
    }

    public static WebDriver getChromeDriver(){
        initializeChromeDriver();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}

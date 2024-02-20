package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        options.addArguments("--start-fullscreen");
        driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public void navigateTo(String url){
        driver.navigate().to(url);
    }
}

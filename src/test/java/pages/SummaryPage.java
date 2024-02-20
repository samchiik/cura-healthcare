package pages;

import factory.Globals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SummaryPage {
    private final WebDriver driver;
    public static String url = Globals.BASE_URL + "appointment.php#summary";

    public SummaryPage(WebDriver driver) {
        this.driver = driver;
    }

    public By facility = By.id("facility");
    public WebElement getFacility(){return driver.findElement(facility);}
    public By readmission = By.id("hospital_readmission");
    public WebElement getReadmission(){return driver.findElement(readmission);}
    public By program = By.id("program");
    public WebElement getProgram(){return driver.findElement(program);}
    public By visitDate = By.id("visit_date");
    public WebElement getVisiteDate(){return driver.findElement(visitDate);}
    public By comment = By.id("comment");
    public WebElement getComment(){return driver.findElement(comment);}
}
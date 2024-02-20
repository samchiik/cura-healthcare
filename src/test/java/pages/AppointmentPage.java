package pages;

import factory.Globals;
import factory.data.Facilities;
import factory.data.HealtcareProgram;
import factory.data.Readmission;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AppointmentPage {
    private final WebDriver driver;
    public static String url = Globals.BASE_URL + "#appointment";

    public AppointmentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToPage(){ driver.navigate().to(url);}



    private Select getFacilitySelect(){ return new Select(driver.findElement(By.id("combo_facility")));}
    private WebElement getApplyToReadmission(){ return driver.findElement(By.id("chk_hospotal_readmission")); }
    private WebElement getMedicareRadioButton(){ return driver.findElement(By.id("radio_program_medicare")); }
    private WebElement getMedicaidRadioButton(){ return driver.findElement(By.id("radio_program_medicaid")); }
    private WebElement getNoneRadioButton(){ return driver.findElement(By.id("radio_program_none")); }
    private WebElement getVisiteDateField(){return driver.findElement(By.id("txt_visit_date")); }
    private WebElement getCommentField(){return driver.findElement(By.id("txt_comment")); }
    private WebElement getBookappointmentButton(){return driver.findElement(By.id("btn-book-appointment")); }

    public void selectFacility(Facilities facility){
        getFacilitySelect().selectByValue(facility.name);
    }

    public void selectApplyReadmission(Readmission readmission){
        if (readmission.apply) getApplyToReadmission().click();
    }

    public void selectHealthcareProgram(HealtcareProgram healtcareProgram){
        switch (healtcareProgram){
            case NONE -> getNoneRadioButton().click();
            case MEDICAID -> getMedicaidRadioButton().click();
            case MEDICARE -> getMedicareRadioButton().click();
        }
    }

    public void setDate(String date){
        getVisiteDateField().sendKeys(date);
    }
    public void clearDate() { getVisiteDateField().clear(); }

    public void setComment(String comment){
        if (comment != null) getCommentField().sendKeys(comment);
    }

    public void makeAppointment(String date){
        setDate(date);
        getBookappointmentButton().click();
    }

    public void makeAppointment(Facilities facility, Readmission applyToReadmission, HealtcareProgram healtcareProgram, String date, String comment){
        selectFacility(facility);
        selectApplyReadmission(applyToReadmission);
        selectHealthcareProgram(healtcareProgram);
        setDate(date);
        setComment(comment);
        getBookappointmentButton().click();
    }
}
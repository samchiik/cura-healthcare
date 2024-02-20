package testcases;

import factory.BaseTest;
import factory.data.Facilities;
import factory.data.HealtcareProgram;
import factory.data.Readmission;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AppointmentPage;
import pages.LoginPage;
import pages.SummaryPage;
import utils.DateUtil;
import utils.Verify;
import utils.VerifyInDriver;

public class AppointmentTest extends BaseTest {

    private LoginPage loginPage;
    private AppointmentPage appointmentPage;
    private VerifyInDriver verify;
    private SummaryPage summaryPage;

    @BeforeMethod
    private void injectDriver() {
        loginPage = new LoginPage(driver);
        appointmentPage = new AppointmentPage(driver);
        verify = new VerifyInDriver(driver);
        summaryPage = new SummaryPage(driver);

        loginPage.navigateToPage();
        loginPage.login();
    }

    @Test
    public void dateIsMandatory(){
        appointmentPage.makeAppointment(Facilities.TOKYO, Readmission.YES, HealtcareProgram.MEDICAID, "", "Comment");
        verify.url(AppointmentPage.url);
    }


    @Test(dataProvider = "appointments")
    public void workingCasesTest(Facilities facility, Readmission apply, HealtcareProgram healtcareProgram, String date, String comment) {
        appointmentPage.makeAppointment(facility, apply, healtcareProgram, date, comment);

        verify.elementIsPresent(summaryPage.facility);
        Verify.elementText(summaryPage.getFacility(), facility.name);

        verify.elementIsPresent(summaryPage.readmission);
        Verify.elementText(summaryPage.getReadmission(), apply.text);

        verify.elementIsPresent(summaryPage.program);
        Verify.elementText(summaryPage.getProgram(), healtcareProgram.name);

        verify.elementIsPresent(summaryPage.visitDate);
        Verify.elementText(summaryPage.getVisiteDate(), date);

        Verify.elementText(summaryPage.getComment(), comment);
    }

    @DataProvider(name = "appointments")
    public Object[][] dataProvider(){
        return new Object[][]{
                {Facilities.TOKYO, Readmission.YES, HealtcareProgram.MEDICAID, DateUtil.getToday(), ""}
                ,{Facilities.HONGKONG, Readmission.NO, HealtcareProgram.MEDICARE, DateUtil.getToday(), "Commentaire"}
                ,{Facilities.SEOUL, Readmission.YES, HealtcareProgram.NONE, DateUtil.getToday(), "Commentaire"}
        };
    }
}
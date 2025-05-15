package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class PageObjectsFormTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest(){
        registrationPage.openPage()
                .cleanBannersOnPage()
                .setFirsName("Mark")
                .setLastName("Avrelii")
                .setUserEmail("markhero@gmail.com")
                .setUserGender("Male")
                .setUserPhone("9774599362")
                .setDateOfBirth("11","January", "1991")
                .setUserSubjects("English")
                .chooseHobbies("Sports")
                .uploadFile("dude.png")
                .setCurrentAddress("Ватутина 4к1")
                .setStateAndCity("Rajasthan","Jaipur")
                .clickSubmitButton()
                .checkTableResultVisible()
                .checkResult("Student Name", "Mark Avrelii")
                .checkResult("Student Email", "markhero@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9774599362")
                .checkResult("Date of Birth", "11 January,1991")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Sport")
                .checkResult("Picture", "dude.png")
                .checkResult("Address", "Ватутина 4к1")
                .checkResult("State and City", "Rajasthan Jaipur");
    }

    @Test
    void checkOnlyRequeredFieldsTest(){
        registrationPage.openPage()
                .cleanBannersOnPage()
                .setFirsName("Mark")
                .setLastName("Avrelii")
                .setUserGender("Male")
                .setUserPhone("9774599362")
                .setDateOfBirth("11","January", "1991")
                .clickSubmitButton()
                .checkTableResultVisible()
                .checkResult("Student Name", "Mark Avrelii")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9774599362")
                .checkResult("Date of Birth", "11 January,1991");
    }

    @Test
    void checkEmailFieldWithoutDomainTest(){
        registrationPage.openPage()
                .cleanBannersOnPage()
                .setFirsName("Mark")
                .setLastName("Avrelii")
                .setUserEmail("markhero")
                .setUserGender("Male")
                .setUserPhone("9774599362")
                .setDateOfBirth("11","January", "1991")
                .clickSubmitButton()
                .checkTableResultUnvisible()
                .checkValidationEmailField();
    }
}

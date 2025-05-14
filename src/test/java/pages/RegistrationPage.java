package pages;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableResultComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    TableResultComponent tableResultComponent = new TableResultComponent();


    private static SelenideElement firstNameInput  = $("#firstName");
    private static SelenideElement lastNameInput  =  $("#lastName");
    private static SelenideElement userEmail = $("#userEmail");
    private static SelenideElement userGender =   $("#genterWrapper");
    private static SelenideElement userPhone =   $("#userNumber");
    private static SelenideElement birthInput =   $("#dateOfBirthInput");
    private static SelenideElement userSubjects =   $("#subjectsContainer");
    private static SelenideElement userSubjectsInput =   $("#subjectsInput");
    private static SelenideElement userHobbies =   $("#hobbiesWrapper");
    private static SelenideElement selectPicture =   $("#uploadPicture");
    private static SelenideElement addressInput =   $("textarea#currentAddress");
    private static SelenideElement setState =   $("#state");
    private static SelenideElement chooseStateOfList =   $(".css-26l3qy-menu");
    private static SelenideElement setCity =   $("#city");
    private static SelenideElement chooseCityOfList =   $(".css-26l3qy-menu");
    private static SelenideElement submitButton =   $("button#submit");
    private static String ERROR_BORDER_COLOR = "rgb(220, 53, 69)";

    CalendarComponent calendarComponent = new CalendarComponent();
    public RegistrationPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirsName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value){
        userEmail.setValue(value);
        return this;
    }

    public RegistrationPage setUserGender(String value) {
        userGender.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserPhone(String value) {
        userPhone.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        birthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setUserSubjects(String value) {
        userSubjects.click();
        userSubjectsInput.setValue(value);
        $$("#react-select-2-option-0").findBy(text("English")).click();
        return this;
    }

    public RegistrationPage chooseHobbies(String hobbies) {
        userHobbies.$(byText(hobbies)).click();
        return this;
    }

    public RegistrationPage uploadFile(String fileName) {
        selectPicture.uploadFromClasspath(fileName);
        return this;
    }
    public RegistrationPage setCurrentAddress(String address) {
        addressInput.scrollTo().click();
        addressInput.setValue(address);
        return this;
    }
    public RegistrationPage setStateAndCity(String state, String city) {
        setState.scrollTo().click();
        chooseStateOfList.$(byText(state)).click();
        setCity.click();
        chooseCityOfList.$(byText(city)).click();
        return this;
    }
    public RegistrationPage clickSubmitButton(){
        submitButton.click();
        return this;
    }
    public RegistrationPage checkTableResultVisible(){
        tableResultComponent.checkTableVisible();
        return this;
    }
    public RegistrationPage checkTableResultUnvisible(){
        tableResultComponent.checkTableUnvisible();
        return this;
    }

    public RegistrationPage checkResult(String key, String value){
        tableResultComponent.compareUserData(key,value);
        return this;
    }
    public RegistrationPage checkValidationEmailField(){
        userEmail.shouldHave(cssValue("border-color", ERROR_BORDER_COLOR));
        return this;
    }
}

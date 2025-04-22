import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class DemoQaTest {

    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void mainTest(){
//        File file = new File("src/test/testData/dude.png");
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        // Заполнение регистрационной формы
        $("#firstName").setValue("Mark");
        $("#lastName").setValue("Avrelius");
        $("#userEmail").setValue("markhero@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9774599362");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("January")).click();
        $(".react-datepicker__year-select").$(byText("1991")).click();
        $(".react-datepicker__day--011").click();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("E");
        $$("#react-select-2-option-0").findBy(text("English")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("dude.png");
        $("textarea#currentAddress").scrollTo().click();
        $("textarea#currentAddress").setValue("Ватутина 4к1");
        $("#state").scrollTo().click();
        $(".css-26l3qy-menu").$(byText("Rajasthan")).click();
        $("#city").click();
        $(".css-26l3qy-menu").$(byText("Jaipur")).click();

// Проверка формы
        $("button#submit").click();
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Mark Avrelius"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("markhero@gmail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9774599362"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("11 January,1991"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("English"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports, Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("dude.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Ватутина 4к1"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Rajasthan Jaipur"));
    }
}

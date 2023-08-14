import builder.LoginPageBuilder;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import po.LoginPage;

public class LoginTest extends BaseTest {
    @Test(groups = {"Smoke"}, dataProvider = "passwords")
    void loginToSitePassword(String password){
        new LoginPage().clickOnRegButton();

        LoginPage login = new LoginPageBuilder()
                .withUsername("Vikkor123")
                .withPassword(password)
                .build();

        login.clickEnter();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(new LoginPage().checkMessage())
                .as("Check Message")
                .isEqualTo("Введены неверные имя участника или пароль. Попробуйте ещё раз.");
        softly.assertAll();
    }


    @Test(groups = {"Smoke"}, dataProvider = "username")
    void loginToSiteUserName(String username){
        new LoginPage().clickOnRegButton();

        LoginPage login = new LoginPageBuilder()
                .withUsername(username)
                .withPassword("Panasonic2023")
                .build();

        login.clickEnter();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(new LoginPage().checkMessage())
                .as("Check Message")
                .isEqualTo("Введены неверные имя участника или пароль. Попробуйте ещё раз.");
        softly.assertAll();
    }


    @DataProvider(name = "passwords")
    public Object[][] getPasswords(){
        return new Object[][]{
                {"qwe213!!"},
                {"@343!@#"}
        };
    }

    @DataProvider(name = "username")
    public Object[][] getUsername(){
        return new Object[][]{
                {"Vikkor1232"},
               {"Vikkor123@"}
        };
    }
}
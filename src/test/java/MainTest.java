import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

import po.LoginPage;
import po.SearchPage;

public class MainTest extends WikipediaTest {
    SearchPage search =new SearchPage();
    LoginPage login = new LoginPage();
    @Test
    void shouldBeVisibleResultText(){
        search.clickOnSearch();
        search.fillText("Ubisoft");
        search.enterSearch();
        search.clickOnElement();
        assertEquals("Ubisoft", search.getTitle());
    }
    @Test
    void loginToSite(){
        login.clickOnRegButton();
        login.enterToSite("Vikkor123","Panasonic2023");
        assertEquals("Vikkor123", login.checkUserName());
    }
}


import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import po.SearchPage;

public class SearchTest extends BaseTest {

    @Test(groups = {"Regression"})
    void shouldBeVisibleResultText(String result){
        new SearchPage()
        .clickOnSearch()
        .fillText("Ubisoft")
        .enterSearch()
        .clickOnElement();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(new SearchPage().getTitle()).as("").isEqualTo("Ubisoft");
        softly.assertAll();
    }
}


import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static config.WebDriverInit.closeDriver;
import static config.WebDriverInit.getDriver;

public class WikipediaTest {
    WebDriver driver=null;
    @BeforeSuite
    public void setUp(){
        driver =getDriver();
        driver.get("https://ru.wikipedia.org/");
        driver.manage().window().setSize(new Dimension(1920,1080));
    }

    @AfterSuite
    public void tearDown(){
        closeDriver();
    }
}

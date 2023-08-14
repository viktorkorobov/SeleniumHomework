import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static config.WebDriverInit.closeDriver;
import static config.WebDriverInit.getDriver;

public class BaseTest {
    WebDriver driver=null;
    @BeforeSuite(groups = {"All","Smoke","Regression"})
    public void setUp(){
        driver =getDriver();
        driver.get("https://ru.wikipedia.org/");
        driver.manage().window().setSize(new Dimension(1920,1080));
    }

    @AfterSuite(groups = {"All","Smoke","Regression"})
    public void tearDown(){
        closeDriver();
    }
}

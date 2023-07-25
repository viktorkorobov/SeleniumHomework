import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.AssertJUnit.assertEquals;

public class MainTest {
    public static void main(String[] args){

        By search = By.xpath("//input[@name='search']");
        By result = By.xpath("//h1[@id='firstHeading']");
        By element1 = By.xpath("//div[@class='mw-search-results-container']//span");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://ru.wikipedia.org/");
        driver.manage().window().setSize(new Dimension(1920,1080));


        sendElement(driver,search,"Ubisoft");
        cliclEnter(driver,search);
        clickElement(driver,element1);

        assertEquals("Ubisoft", getTextFromElement(driver, result));

        driver.quit();
    }

    static void clickElement(WebDriver driver, By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(d -> d.findElement(locator)).click();
    }
    static void sendElement(WebDriver driver, By locator, String text){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(text);
    }
    static void cliclEnter(WebDriver driver, By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(d ->  d.findElement(locator)).sendKeys(Keys.ENTER);
    }
    static String getTextFromElement(WebDriver driver, By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(d -> d.findElement(locator)).getText();
    }
}

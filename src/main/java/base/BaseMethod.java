package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static config.WebDriverInit.*;

public class BaseMethod {
    public WebDriverWait getWit(){
        return new WebDriverWait(getDriver(), 10);
    }

    protected void click(By locator){
        getWit().until(d -> d.findElement(locator)).click();
    }
    protected void send(By locator, String text){
        getWit().until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(text);
    }
    protected void cliclEnter(By locator){
        getWit().until(d ->  d.findElement(locator)).sendKeys(Keys.ENTER);
    }
    protected String getTextFromElement(By locator){
        return getWit().until(d -> d.findElement(locator)).getText();
    }
}

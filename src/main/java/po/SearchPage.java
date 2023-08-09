package po;

import base.BaseMethod;
import org.openqa.selenium.By;

public class SearchPage extends BaseMethod {
    private final By search = By.xpath("//input[@name='search']");
    private final  By result = By.xpath("//h1[@id='firstHeading']");
    private final  By element1 = By.xpath("//div[@class='mw-search-results-container']//span");

    public void clickOnSearch(){
        click(search);
    }
    public void fillText(String text){
        send(search, text);
    }

    public void enterSearch() {
        cliclEnter(search);
    }
    public String getTitle(){
        return getTextFromElement(result);
    }
    public void clickOnElement(){
        click(element1);
    }
}

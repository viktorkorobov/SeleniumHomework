package po;

import base.BaseMethod;
import org.openqa.selenium.By;

public class LoginPage extends BaseMethod {
    private final By clickOnRegButton = By.xpath("//div//li[@id='pt-login']//span");
    private final  By login = By.xpath("//div//input[@id='wpName1']");

    private final  By password = By.xpath("//div//input[@id='wpPassword1']");

    private final  By enter = By.xpath("//div//button[@type='submit']");

    private final  By nameUser = By.xpath("//div //li[@id='pt-userpage']/a/span");

    public void clickOnRegButton(){
        click(clickOnRegButton);
    }

    public void enterToSite(String text1, String text2){
        send(login, text1);
        send(password, text2);
        cliclEnter(enter);
    }
    public String checkUserName(){
        return getTextFromElement(nameUser);
    }
}

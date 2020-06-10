package skreens.gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import skreens.AbstractPage;

public class GMailHomePage extends AbstractPage {

    @FindBy (xpath  = "//*[@class = 'h-c-header__cta']/ul[1]/li[2]")
    public WebElement buttonToComeIn_XPATH;



    public GMailHomePage(WebDriver webDriver) {
        super(webDriver);
    }


}

package skreens.trashmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import skreens.AbstractPage;

public class TrashMailAddressManagerPage extends AbstractPage{

    @FindBy (xpath = "//*[@id='gridview-1010']/table/tbody/tr[2]/td[4]/div")
    private WebElement disposable_XPATH;
    @FindBy (xpath = "//*[@id='gridview-1010']/table/tbody/tr[2]/td[5]/div")
    private WebElement domain_XPATH;
    @FindBy (id = "fe-add-btnInnerEl")
    public WebElement AddButton_ID;
    @FindBy (id = "fe-save-btnEl")
    public WebElement SaveButton_ID;


    public TrashMailAddressManagerPage(WebDriver webDriver) {
        super(webDriver);
    }


    public String getDisposableDomain (){
        String disposable = disposable_XPATH.getText();
        String domain = domain_XPATH.getText();
        return disposable+domain;
    }


}

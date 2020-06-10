package skreens.gmail;

import drivers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import skreens.AbstractPage;

import java.util.List;

public class GMailMyPage extends AbstractPage {

    @FindBy(xpath  = "//*[@class='Cp']//tr[1]")
    public WebElement firstEmail_XPATH;

    @FindBy(how = How.XPATH, using = "//div[@role='listitem']")
    private List<WebElement> mailList;

    public GMailMyPage(WebDriver webDriver) {
        super(webDriver);
    }
    public int getMailList() {
        return mailList.size();
    }
    public void confirmationBooking () throws InterruptedException {
        WebElement emailСonfirmation_XPATH = Driver.getDriver().findElement(
                By.xpath(String.format("//div[@role='listitem'][%d]", mailList.size())));
        Driver.scrollElement(emailСonfirmation_XPATH);
//        WebElement buttonСonfirmation_XPATH = Driver.getDriver().findElement(By.xpath(
//                String.format("//div[@role='listitem'][%d]//div[@class='gs']/div[3]//table[2]//table//tr[5]//a[@style='text-decoration:none']", mailList.size())));
        WebElement buttonСonfirmation1_XPATH = Driver.getDriver().findElement(By.xpath(
                String.format("//div[@role='listitem'][%d]//div[@class='gs']/div[3]//table[2]//table//tr[4]//a//a", mailList.size())));
        Driver.setTimeouts();
        buttonСonfirmation1_XPATH.click();
    }


}

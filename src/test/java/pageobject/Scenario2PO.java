package pageobject;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.PropertyUtils;

import java.io.IOException;

public class Scenario2PO extends BasePO {

    PropertyUtils propertyUtils = new PropertyUtils();


    public Scenario2PO(AppiumDriver driver) {
        super(driver);
    }
//

    @FindBy(className = "pipeWrap-sm")
    WebElement menuBtn;

    //    @FindBy(className = "linkNav")
//    @FindBy(xpath = "//*[@id=\"header\"]/section[3]/div/nav/div/div/div/div/div[1]/div/ul/li[2]/div/a")
    @FindBy(xpath = "//*[text()='Explore']")
    WebElement linkNavigator;

    @FindBy(xpath = "//*[text()='Shore Excursions']")
    WebElement shoreExcursions;

    @FindBy(xpath = "//*[@id='search_destinations']")
//    @FindBy(name = "destinations")
    WebElement dropDown;

    @FindBy(xpath = "//*[text()='Alaska Cruises']")
    WebElement alaskaCruises;

    @FindBy(xpath = "//*[text()='FIND EXCURSIONS']")
    WebElement findBtn;

    @FindBy(id = "showLeftPush")
    WebElement filter;

    @FindBy(xpath = "//*[@title='Port']")
    WebElement portFilter;

    @FindBy(xpath = "//*[@for='ports_VIC']")
    WebElement portVictoria;

    @FindBy(xpath = "//*[@id=\"sap-menu-left\"]/div/div[4]/ul[1]/li[2]/div/div/div[1]/ul/li[3]/a")
    WebElement doneBtn1;

    @FindBy(xpath = "//*[@title='Update Filter']")
    WebElement doneBtn2;

    @FindBy(xpath = "//*[@id=\"shorexExplore\"]/div[1]/section/div/div/div[1]/ul/li[1]/figure/figcaption/div[2]/ul/li[2]/h2/a")
    WebElement assertionByImage;

    public void loginTestPO() throws IOException, InterruptedException {

        propertyUtils.propLoginTestInfoFile();

        driver.get(propertyUtils.prop.getProperty("assignment.url"));

        menuBtn.click();
        Thread.sleep(5000);
        linkNavigator.click();
        shoreExcursions.click();
        dropDown.click();
        alaskaCruises.click();
        findBtn.click();
        filter.click();
        portFilter.click();
        portVictoria.click();
        doneBtn1.click();
        doneBtn2.click();
        assertionByImage.isDisplayed();


    }


}

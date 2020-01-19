package pageobject;

import io.appium.java_client.AppiumDriver;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.PropertyUtils;

import java.io.IOException;

public class Scenario2PO extends BasePO {

    PropertyUtils propertyUtils = new PropertyUtils();


    public Scenario2PO(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(className = "pipeWrap-sm")
    WebElement menuBtn;

    @FindBy(xpath = "//*[text()='Explore']")
    WebElement linkNavigator;

    @FindBy(xpath = "//*[text()='Shore Excursions']")
    WebElement shoreExcursions;

    @FindBy(xpath = "//*[@id='search_destinations']")
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
    WebElement assertionByPortName;


    WebDriverWait wait =new WebDriverWait(driver,20);

    public void loginTestPO() throws IOException, InterruptedException {


        propertyUtils.propLoginTestInfoFile();

        driver.get(propertyUtils.prop.getProperty("assignment.url"));

        wait.until(ExpectedConditions.visibilityOf(menuBtn));
        menuBtn.click();
        wait.until(ExpectedConditions.visibilityOf(linkNavigator));
        linkNavigator.click();
        wait.until(ExpectedConditions.visibilityOf(shoreExcursions));
        shoreExcursions.click();
        wait.until(ExpectedConditions.visibilityOf(dropDown));
        dropDown.click();
        alaskaCruises.click();
        findBtn.click();
        wait.until(ExpectedConditions.visibilityOf(filter));
        filter.click();
        portFilter.click();
        portVictoria.click();
        doneBtn1.click();
        wait.until(ExpectedConditions.visibilityOf(doneBtn2));
        doneBtn2.click();
        wait.until(ExpectedConditions.visibilityOf(assertionByPortName));
        Assert.assertEquals(assertionByPortName.getText(), "Butchart Gardens Evening & Victoria Highlights");


    }


}

package pageobject;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.PropertyUtils;

import java.io.IOException;

public class LoginPO extends BasePO {

    PropertyUtils propertyUtils = new PropertyUtils();


    public LoginPO(AppiumDriver driver) {
        super(driver);
    }
//

    @FindBy(className = "linkNav")
    WebElement linkNavigate;

    @FindBy(xpath = "//*[text()='Shore Excursions']")
    WebElement shoreExcursions;

    @FindBy(className = "chosen-single")
    WebElement dropDown;

    @FindBy(xpath = "//*[text()='Alaska Cruises']")
    WebElement alaskaCruises;

    @FindBy(xpath = "//*[text()='FIND EXCURSIONS']")
    WebElement findBtn;

    @FindBy(xpath = "//*[@title='Port']")
    WebElement portFilter;

    @FindBy(xpath = "//*[@for='ports_VIC']")
    WebElement portVictoria;





    public void loginTestPO() throws IOException, InterruptedException {

        propertyUtils.propLoginTestInfoFile();

        driver.get(propertyUtils.prop.getProperty("assignment.url"));

        linkNavigate.click();
        shoreExcursions.click();
        dropDown.click();
        alaskaCruises.click();
        findBtn.click();
        portFilter.click();
        portVictoria.click();







    }


}

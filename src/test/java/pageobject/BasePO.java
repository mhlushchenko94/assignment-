package pageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.commons.beanutils.PropertyUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePO {

    protected AppiumDriver driver;

//    public final static int IMPLICIT_WAIT = PropertyUtils.getProperty("implicitWait", 30);
//    WaitUtils waitUtils;

    // pagefactory for appium elements
    protected BasePO(AppiumDriver driver) {
        this.driver = driver;
        initElement();
    }

    private void initElement() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }



}

package pageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BasePO {

    protected AppiumDriver driver;


    // pagefactory for appium elements

    protected BasePO(AppiumDriver driver) {
        this.driver = driver;
        initElement();
    }

    private void initElement() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


}

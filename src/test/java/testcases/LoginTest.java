package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageobject.LoginPO;

import java.io.IOException;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() throws IOException, InterruptedException {

        LoginPO loginPO = new LoginPO(driver);

        loginPO.loginTestPO();
    }
}

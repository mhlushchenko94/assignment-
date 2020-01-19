package testcases;

import org.testng.annotations.Test;
import pageobject.Scenario2PO;

import java.io.IOException;

public class Scenario2Test extends BaseTest {

    @Test
    public void testLogin() throws IOException, InterruptedException {

        Scenario2PO loginPO = new Scenario2PO(driver);

        loginPO.loginTestPO();
    }
}

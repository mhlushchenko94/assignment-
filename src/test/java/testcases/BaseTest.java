package testcases;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.PropertyUtils;

import java.io.IOException;
import java.net.URL;

public class BaseTest {

    protected AppiumDriver driver;

    public String platform = "android";

    // Access to PropertyUtils class file
    PropertyUtils propertyUtils = new PropertyUtils();


    @BeforeSuite
    public void serverStart() {

        System.out.println("Server Started");

        AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
        service.start();

    }


    @BeforeSuite
//    @BeforeTest
    //running a Quick Boot but does not save a snapshot on exit //For first time running emulator required to set up a Quick Boot
    public void emulatorStart() throws IOException {

        System.out.println("Emulator/Simulator Started");

        if (platform.equalsIgnoreCase("android")) {
            String[] args = new String[]{"/Users/mhlushchenko/Library/Android/sdk/emulator/emulator", "-avd", "TestWeb", "-no-snapshot-save"};

            Process process = new ProcessBuilder(args).start();
        } else {
            String[] args = new String[]{"xcrun", "simctl", "boot", "25618A64-CC7E-46F3-81ED-7DBED4FA6E1A"};

            Process process = new ProcessBuilder(args).start();
        }


    }


    @BeforeMethod
    public void setUpAppium() throws IOException {
        //call method to get access for `prop` variable
        propertyUtils.propConfigurationFile();


        DesiredCapabilities capabilities = new DesiredCapabilities();
        setDesiredCapabilities(capabilities);
        driver = new AppiumDriver(new URL(propertyUtils.prop.getProperty("appium.server.url")), capabilities);
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }

    private void setDesiredCapabilities(DesiredCapabilities desiredCapabilities) throws IOException {

        if (platform.equalsIgnoreCase("android")) {

            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
            desiredCapabilities.setCapability(MobileCapabilityType.UDID, propertyUtils.prop.getProperty("android.udid"));
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, propertyUtils.prop.getProperty("android.device.name"));
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, propertyUtils.prop.getProperty("android.platform"));
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, propertyUtils.prop.getProperty("android.platform.version"));
            desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
            desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            desiredCapabilities.setCapability("autoDismissAlerts", true);
            desiredCapabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
            desiredCapabilities.setCapability("uiautomator2ServerInstallTimeout", 120000);

        } else if (platform.equalsIgnoreCase("ios")) {


            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, propertyUtils.prop.getProperty("ios.platform"));
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, propertyUtils.prop.getProperty("ios.platform.version"));
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, propertyUtils.prop.getProperty("ios.device.name"));
            desiredCapabilities.setCapability("bundleId", propertyUtils.prop.getProperty("ios.bundle.id"));
            desiredCapabilities.setCapability("automationName", "XCUITest");
            desiredCapabilities.setCapability("waitForQuiescence", false);
            desiredCapabilities.setCapability("wdaEventloopIdleDelay", 3);

        }
    }

    @AfterSuite
    public void serverStop() throws IOException {

        System.out.println("Server Stopped");

        // killing all appium server ports !!!should be change with parallel testing!!!
        String[] args = new String[]{"KillAll", "-c", "node"};

        Process process = new ProcessBuilder(args).start();
    }

    //closing emulator or simulator after test
//    @AfterSuite
//
//    public void emulatorStop() throws IOException {
//
//        System.out.println("Emulator/Simulator closed");
//
//        if (platform.equalsIgnoreCase("android")) {
//            String[] args = new String[]{"adb", "-s", "emulator-5554", "emu", "kill"};
//
//            Process process = new ProcessBuilder(args).start();
//        } else {
//            String[] args = new String[]{"killall", "Simulator"};
//
//            Process process = new ProcessBuilder(args).start();
//        }
//    }


}

package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {

    public Properties prop = new Properties();
    public InputStream input = null;

    //configuration file
    public void propConfigurationFile() throws IOException {

        input = new FileInputStream("src/test/java/resources/config.properties");
        prop.load(input);
    }

    //login test file
    public void propLoginTestInfoFile() throws IOException {

        input = new FileInputStream("src/test/java/resources/scenario2TestInfo.properties");
        prop.load(input);
    }



}

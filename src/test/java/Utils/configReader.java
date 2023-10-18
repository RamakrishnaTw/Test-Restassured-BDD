package Utils;

import org.junit.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader {

  private Properties properties;

    public Properties loadProperties() {
        FileInputStream inputStream = null;
        String path = "src/test/resources/environments/Test.properties";
        try {
            inputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            Assert.fail("Error reading config file: " + e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    Assert.fail("Error closing the input stream: " + e);
                }
            }
        }
        return properties;
    }


    public String getValue(String key, Properties properties) {
        String value = properties.getProperty(key.toUpperCase());
        if (value == null) {
            try {
                throw new Exception("The key \"" + key.toUpperCase() + "\" does not exist in the config file.");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return value;
    }
}

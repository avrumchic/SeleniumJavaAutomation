package Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class GlobalProperties {
    Logger logger = Logger.getLogger(GlobalProperties.class.getName());

    private static String propertiesFile = "automation.properties";
    private Properties properties = new Properties();

    public Properties getProperties() {
        if (properties == null) {
            properties = new GlobalProperties().getProperties();
        }
        return properties;
    }

    public GlobalProperties() {
        InputStream iStream = null;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try {
            iStream = classloader.getResourceAsStream(propertiesFile);
            properties.load(iStream);
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (iStream != null) {
                    iStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

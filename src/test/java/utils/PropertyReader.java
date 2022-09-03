package utils;

import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Log4j2
public final class PropertyReader {

    public static final String CONFIG_PROPERTIES = "config.properties";

    public static Properties loadConfigProperties(String fileName) {
        Properties properties = new Properties();

        try (InputStream input = PropertyReader.class.getClassLoader().getResourceAsStream(fileName)) {
            properties.load(input);
            log.info("Properties file \"{}\" was read successfully", fileName);
        } catch (IOException ex) {
            log.error("Properties file \"{}\" was not read!!! \nError: {}", fileName, ex.getCause());
        }
        return properties;
    }

    public static String getProperty(String propertyName) {
        return loadConfigProperties(CONFIG_PROPERTIES).getProperty(propertyName);
    }
}
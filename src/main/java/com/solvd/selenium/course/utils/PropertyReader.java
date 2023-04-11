package com.solvd.selenium.course.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private static final Properties PROPERTIES = new Properties();

    static {
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties")) {
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperties(String key) {
        return PROPERTIES.getProperty(key);
    }
}

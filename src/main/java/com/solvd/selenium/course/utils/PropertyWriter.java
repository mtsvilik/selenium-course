package com.solvd.selenium.course.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyWriter {

    private static final Properties PROPERTIES = new Properties();

    public static void main(String[] args) {

        try (FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/config.properties")) {
            PROPERTIES.setProperty("testDate", "12345678");
            PROPERTIES.store(fileOutputStream, "This is a data from test project");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

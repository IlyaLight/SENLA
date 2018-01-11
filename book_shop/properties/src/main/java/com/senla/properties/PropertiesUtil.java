package com.senla.properties;

import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertiesUtil {
    private static final String EXCEPTION = "PropertiesUtil Exception при работе с файлом:";
    private static final Map<String, Properties> propertiesFilesMap = new HashMap<>();

    private static final org.slf4j.Logger LOGGER  = LoggerFactory.getLogger(PropertiesUtil.class);


    public static String getProperties(String filePah, String propertyName) throws PropertyNotFoundException {
        if (!propertiesFilesMap.containsKey(filePah)){
            Properties properties = new Properties();
            try (FileInputStream file = new FileInputStream(filePah)){
                properties.load(file);
            }catch (IOException e){
                LOGGER.error(EXCEPTION + filePah, e);
                throw new RuntimeException(e);
            }
            propertiesFilesMap.put(filePah, properties);
        }
        Object properties = propertiesFilesMap.get(filePah).getProperty(propertyName);
        if (properties == null){
            Exception e = new PropertyNotFoundException(propertyName);
            throw (PropertyNotFoundException) e;
        }
        return properties.toString();
    }




}

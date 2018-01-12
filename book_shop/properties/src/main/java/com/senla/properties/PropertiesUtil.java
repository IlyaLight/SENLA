package com.senla.properties;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class PropertiesUtil {
    private static final String EXCEPTION_PROPERTIES_LOAD_FMT = "Ошибка при работе с файлом \"%s\" нет проперти \"%s\" ";
    private static final String EXCEPTION_PROPERTIES_FILE_LOAD = "Неудалось загрузить файл ";
    private static final Map<String, Properties> propertiesFilesMap = new HashMap<>();

    private static final Logger LOGGER  = LoggerFactory.getLogger(PropertiesUtil.class);


    public static String getProperties(String filePah, String propertyName) throws PropertyNotFoundException {
        if (!propertiesFilesMap.containsKey(filePah)){
            Properties properties = new Properties();
            try (FileInputStream file = new FileInputStream(filePah)){
                properties.load(file);
            }catch (IOException e){
                LOGGER.error(EXCEPTION_PROPERTIES_FILE_LOAD + filePah);
                throw new RuntimeException(e);
            }
            propertiesFilesMap.put(filePah, properties);
        }
        Object properties = propertiesFilesMap.get(filePah).getProperty(propertyName);
        if (properties == null){
            Exception e = new PropertyNotFoundException(propertyName);
            LOGGER.error(new Formatter().format(EXCEPTION_PROPERTIES_LOAD_FMT, filePah, propertyName).toString());
            throw (PropertyNotFoundException) e;
        }
        return properties.toString();
    }




}

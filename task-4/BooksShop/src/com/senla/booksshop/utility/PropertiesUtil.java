package com.senla.booksshop.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    private static final String FILE = "config.properties";
    private static final String REQUEST_AUTOMATICALLY_EXECUTE = "request.automaticallyExecute";
    private static final String BOOK_STALE_TIME = "book.staleTime";
    private static final String SERIALIZABLE_PATH = "SerializablePath";

    public static PropertiesHolder getPropertiesHolder(String filePah){
        FileInputStream file;
        Properties properties = new Properties();
        try {
            file = new FileInputStream(filePah + FILE);
            properties.load(file);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        PropertiesHolder propertiesHolder = new PropertiesHolder();
        propertiesHolder.setAutomaticallyExecuteRequest(Boolean.getBoolean(properties.getProperty(REQUEST_AUTOMATICALLY_EXECUTE)));
        propertiesHolder.setStaleTime(Integer.getInteger(properties.getProperty(BOOK_STALE_TIME)));
        propertiesHolder.setSerializablePath(properties.getProperty(SERIALIZABLE_PATH));
        return propertiesHolder;
    }



}

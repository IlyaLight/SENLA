package com.senla.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertiesUtil {
    private static final String FILE = "config.properties";
    private static final String REQUEST_AUTOMATICALLY_EXECUTE = "request.automaticallyExecute";
    private static final String BOOK_STALE_TIME = "book.staleTime";
    private static final String CSV_PATH = "csv.Path";
    private static final String EXCEPTION = "Exception:";

    private static  PropertiesHolder holder;

    private static final Logger log = Logger.getLogger(PropertiesUtil.class.getName());


    public static PropertiesHolder getPropertiesHolder(String filePah){
        if (holder != null){
            return holder;
        }
        Properties properties = new Properties();
        try (FileInputStream file = new FileInputStream(filePah + FILE)){
            properties.load(file);
        }catch (IOException e){
            log.log(Level.SEVERE, EXCEPTION, e);
            throw new RuntimeException(e);
        }
        holder = new PropertiesHolder();
        holder.setAutomaticallyExecuteRequest(Boolean.valueOf(properties.getProperty(REQUEST_AUTOMATICALLY_EXECUTE)));
        holder.setStaleTime(Integer.valueOf(properties.getProperty(BOOK_STALE_TIME)));
        holder.setCsvPath(properties.getProperty(CSV_PATH, ""));
        return holder;
    }




}

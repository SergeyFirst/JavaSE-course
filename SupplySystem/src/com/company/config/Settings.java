package com.company.config;

import java.util.PropertyResourceBundle;

public class Settings {

    private static PropertyResourceBundle props;

    public static final String DB_CLASS_NAME = "db_class_name";
    public static final String DB_URL = "db_url";
    public static final String DB_LOGIN = "db_login";
    public static final String DB_PASSWORD = "db_password";
    public static final String DATA_SOURCE_COUNT = "source_count";
    public static final String NAME_OF_PROPERTY_DATA_SOURCE = "name_of_property_data_source";

    static {
        props = (PropertyResourceBundle) PropertyResourceBundle.getBundle("com.company.config.SupplySystem");
    }

    public static String getProperty(String name) {
        return props.getString(name);
    }

}

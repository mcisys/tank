package com.mcisys.tank;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class PropertyMgr {

    static Properties props = new Properties();

    static {
        try {
            props.load(Objects.requireNonNull(PropertyMgr.class.getClassLoader().getResourceAsStream("config.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int get(String key) {
        if (props == null) return 0;
        return Integer.parseInt(String.valueOf(props.get(key)));
    }
}

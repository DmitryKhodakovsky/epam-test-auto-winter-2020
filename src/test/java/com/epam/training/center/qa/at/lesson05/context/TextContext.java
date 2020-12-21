package com.epam.training.center.qa.at.lesson05.context;

import java.util.HashMap;
import java.util.Map;

public class TextContext {

    private static TextContext instance = new TextContext();

    private Map<String, Object> map = new HashMap<>();

    private TextContext() {
    }

    public void setTestObject(String key, Object value) {
        map.put(key, value);
    }

    public <T> T getTestObject(String key) {
        return (T) map.get(key);
    }

    public static TextContext getInstance() {
        if (instance == null) {
            instance = new TextContext();
        }
        return instance;
    }
}

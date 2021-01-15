package com.ejlchina.json;

import com.ejlchina.okhttps.DataConvertor;

import java.util.ServiceLoader;

public class JSONFinder {

    private static final String FACTORY_KEY = "com.ejlchina.json.JSONFactory";
    private static final String DEFAULT_CONVERTOR = "com.ejlchina.okhttps.JacksonDataConvertor";

    private static DataConvertor _convertor;

    /**
     * 初始化
     * @param convertor 转换器
     */
    public static void init(DataConvertor convertor) {
        JSONFinder._convertor = convertor;
    }

    /**
     * 寻找 JSON 转换器
     * @return DataConvertor
     */
    public static synchronized DataConvertor find() {
        // 如果存在，直接返回
        if (_convertor != null) {
            return _convertor;
        }
        // 使用 SPI 方式寻找 JSONFactory
        for (JSONFactory factory : ServiceLoader.load(JSONFactory.class)) {
            _convertor = factory.create();
            if (_convertor != null) {
                return _convertor;
            }
        }
        // 从 System Properties 从寻找 JSONFactory
        String className = System.getProperty(FACTORY_KEY);
        if (className != null) {
            JSONFactory factory = loadJSONFactory(className);
            _convertor = factory.create();
            if (_convertor != null) {
                return _convertor;
            }
        }
        _convertor = loadDefaultConvertor(className);
        return _convertor;
    }

    private static JSONFactory loadJSONFactory(String className) {
        Class<?> clazz;
        try {
            clazz = JSONFinder.class.getClassLoader().loadClass(className);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
        if (!JSONFactory.class.isAssignableFrom(clazz)) {
            throw new IllegalStateException("the System Property [" + FACTORY_KEY + ": " + className + "]"
                + " is not subclass of com.ejlchina.json.JSONFactory");
        }
        try {
            return (JSONFactory) clazz.getDeclaredConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException("can not instance JSONFactory: " + className, e);
        }
    }

    private static DataConvertor loadDefaultConvertor(String className) {
        Class<?> clazz;
        try {
            clazz = JSONKit.class.getClassLoader().loadClass(DEFAULT_CONVERTOR);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("no JSONFactory or DataConvertor provided!", e);
        }
        if (!DataConvertor.class.isAssignableFrom(clazz)) {
            throw new IllegalStateException(className + " is not subclass of com.ejlchina.okhttps.DataConvertor");
        }
        try {
            return (DataConvertor) clazz.getDeclaredConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException(e);
        }
    }

}

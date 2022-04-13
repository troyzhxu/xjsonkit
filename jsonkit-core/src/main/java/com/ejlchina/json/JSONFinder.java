package com.ejlchina.json;

import com.ejlchina.data.DataConvertor;

import java.util.ServiceLoader;

public class JSONFinder {

    public static final String FACTORY_KEY = "com.ejlchina.json.JSONFactory";

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
    public static DataConvertor find() {
        // 如果存在，直接返回
        if (_convertor != null) {
            return _convertor;
        }
        synchronized (JSONFinder.class) {
            if (_convertor == null) {
                // 使用 SPI 方式寻找 JSONFactory
                for (JSONFactory factory : ServiceLoader.load(JSONFactory.class)) {
                    _convertor = factory.create();
                    if (_convertor != null) {
                        break;
                    }
                }
            }
            if (_convertor == null) {
                // 从 System Properties 从寻找 JSONFactory
                String className = System.getProperty(FACTORY_KEY);
                if (className != null) {
                    JSONFactory factory = loadJSONFactory(className);
                    _convertor = factory.create();
                }
            }
        }
        if (_convertor != null) {
            return _convertor;
        }
        throw new IllegalStateException("没有为 JOSNKit 配置 DataConvertor 或 JSONFactory");
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

}

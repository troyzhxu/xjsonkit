package com.ejlchina.json;


import com.ejlchina.okhttps.Array;
import com.ejlchina.okhttps.DataConvertor;
import com.ejlchina.okhttps.Mapper;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author Troy.Zhou
 * @since 1.0.0
 *
 * JSON 工具
 * 默认使用 Jackson，不依赖具体的 JSON 实现
 */
public class JSONKit {

    private static final String CONVERTOR_KEY = "com.ejlchina.common.util.JSONUtils";
    private static final String DEFAULT_CONVERTOR = "com.ejlchina.okhttps.JacksonDataConvertor";
    private static final Charset CHARSET = StandardCharsets.UTF_8;
    private static DataConvertor _convertor;

    /**
     * 初始化
     * @param convertor 转换器
     */
    public static void init(DataConvertor convertor) {
        JSONKit._convertor = convertor;
    }

    /**
     * JSON 字符串转换为 Mapper 对象
     * @param jsonObj JSON 字符串
     * @return Mapper
     */
    public static Mapper toMapper(String jsonObj) {
        return convertor().toMapper(inputStream(jsonObj), CHARSET);
    }

    /**
     * JSON 字符串转换为 Array 数字
     * @param jsonArr JSON 字符串
     * @return Array
     */
    public static Array toArray(String jsonArr) {
        return convertor().toArray(inputStream(jsonArr), CHARSET);
    }

    /**
     * JSON 字符串转换为 Bean 对象
     * @param type Bean 类型
     * @param jsonObj JSON 字符串
     * @param <T> 泛型
     * @return Bean 对象
     */
    public static <T> T toBean(Type type, String jsonObj) {
        return convertor().toBean(type, inputStream(jsonObj), CHARSET);
    }

    /**
     * JSON 字符串转换为 Bean 对象
     * @param type Bean 类型
     * @param jsonObj JSON 字符串
     * @param <T> 泛型
     * @return Bean 对象
     */
    public static <T> List<T> toList(Class<T> type, String jsonObj) {
        return convertor().toList(type, inputStream(jsonObj), CHARSET);
    }

    /**
     * 对象转 JSON 字符串
     * @param object 对象
     * @return JSON 字符串
     */
    public static String toJson(Object object) {
        return new String(convertor().serialize(object, CHARSET), CHARSET);
    }


    private static synchronized DataConvertor convertor() {
        if (_convertor != null) {
            return _convertor;
        }
        String className = System.getProperty(CONVERTOR_KEY);
        if (className == null) {
            className = DEFAULT_CONVERTOR;
        }
        Class<?> clazz;
        try {
            clazz = JSONKit.class.getClassLoader().loadClass(className);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
        if (!DataConvertor.class.isAssignableFrom(clazz)) {
            throw new IllegalStateException(className + " is not subclass of com.ejlchina.okhttps.DataConvertor");
        }
        try {
            _convertor = (DataConvertor) clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
        return _convertor;
    }

    private static InputStream inputStream(String json) {
        return new ByteArrayInputStream(json.getBytes(CHARSET));
    }

}


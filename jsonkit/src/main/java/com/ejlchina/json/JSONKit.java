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

    private static final Charset CHARSET = StandardCharsets.UTF_8;

    /**
     * 初始化
     * @param convertor 转换器
     */
    public static void init(DataConvertor convertor) {
        JSONFinder.init(convertor);
    }

    /**
     * JSON 字符串转换为 Mapper 对象
     * @param jsonObj JSON 字符串
     * @return Mapper
     */
    public static Mapper toMapper(String jsonObj) {
        return JSONFinder.find().toMapper(inputStream(jsonObj), CHARSET);
    }

    /**
     * JSON 字符串转换为 Array 数字
     * @param jsonArr JSON 字符串
     * @return Array
     */
    public static Array toArray(String jsonArr) {
        return JSONFinder.find().toArray(inputStream(jsonArr), CHARSET);
    }

    /**
     * JSON 字符串转换为 Bean 对象
     * @param type Bean 类型
     * @param jsonObj JSON 字符串
     * @param <T> 泛型
     * @return Bean 对象
     */
    public static <T> T toBean(Type type, String jsonObj) {
        return JSONFinder.find().toBean(type, inputStream(jsonObj), CHARSET);
    }

    /**
     * JSON 字符串转换为 Bean 对象
     * @param type Bean 类型
     * @param jsonObj JSON 字符串
     * @param <T> 泛型
     * @return Bean 对象
     */
    public static <T> List<T> toList(Class<T> type, String jsonObj) {
        return JSONFinder.find().toList(type, inputStream(jsonObj), CHARSET);
    }

    /**
     * 对象转 JSON 字符串
     * @param object 对象
     * @return JSON 字符串
     */
    public static String toJson(Object object) {
        return new String(JSONFinder.find().serialize(object, CHARSET), CHARSET);
    }

    private static InputStream inputStream(String json) {
        return new ByteArrayInputStream(json.getBytes(CHARSET));
    }

}


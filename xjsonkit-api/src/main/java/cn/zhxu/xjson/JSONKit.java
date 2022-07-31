package cn.zhxu.xjson;

import cn.zhxu.data.Array;
import cn.zhxu.data.DataConvertor;
import cn.zhxu.data.Mapper;
import cn.zhxu.data.TypeRef;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author Troy.Zhou
 * @since 1.0.0
 *
 * JSON 工具类，不依赖具体的 JSON 实现
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
        return JSONFinder.find().toMapper(jsonObj);
    }

    /**
     * JSON 字节数组转换为 Mapper 对象
     * @param jsonBytes JSON 字节数组
     * @return Mapper
     * @since v1.3.0
     */
    public static Mapper toMapper(byte[] jsonBytes) {
        return JSONFinder.find().toMapper(new ByteArrayInputStream(jsonBytes), CHARSET);
    }

    /**
     * JSON 字符串转换为 Array 数字
     * @param jsonArr JSON 字符串
     * @return Array
     */
    public static Array toArray(String jsonArr) {
        return JSONFinder.find().toArray(jsonArr);
    }

    /**
     * JSON 字节数组转换为 Array 数字
     * @param jsonBytes JSON 字节数组
     * @return Array
     * @since v1.3.0
     */
    public static Array toArray(byte[] jsonBytes) {
        return JSONFinder.find().toArray(new ByteArrayInputStream(jsonBytes), CHARSET);
    }

    /**
     * JSON 字符串转换为 Bean 对象
     * @param type Bean 类型
     * @param jsonObj JSON 字符串
     * @param <T> 泛型
     * @return Bean 对象
     */
    public static <T> T toBean(Type type, String jsonObj) {
        return JSONFinder.find().toBean(type, jsonObj);
    }

    /**
     * JSON 字节数组转换为 Bean 对象
     * @param type Bean 类型
     * @param jsonBytes JSON 字节数组
     * @param <T> 泛型
     * @return Bean 对象
     * @since v1.3.0
     */
    public static <T> T toBean(Type type, byte[] jsonBytes) {
        return JSONFinder.find().toBean(type, new ByteArrayInputStream(jsonBytes), CHARSET);
    }

    /**
     * JSON 字符串转换为 Bean 对象
     * @param typeRef Bean 类型
     * @param jsonObj JSON 字符串
     * @param <T> 泛型
     * @return Bean 对象
     * @since v1.2.0
     */
    public static <T> T toBean(TypeRef<T> typeRef, String jsonObj) {
        return toBean(typeRef.getType(), jsonObj);
    }

    /**
     * JSON 字节数组转换为 Bean 对象
     * @param typeRef Bean 类型
     * @param jsonBytes JSON 字节数组
     * @param <T> 泛型
     * @return Bean 对象
     * @since v1.2.0
     */
    public static <T> T toBean(TypeRef<T> typeRef, byte[] jsonBytes) {
        return toBean(typeRef.getType(), jsonBytes);
    }

    /**
     * JSON 字符串转换为 Bean 对象
     * @param type Bean 类型
     * @param jsonObj JSON 字符串
     * @param <T> 泛型
     * @return Bean List
     */
    public static <T> List<T> toList(Class<T> type, String jsonObj) {
        return JSONFinder.find().toList(type, jsonObj);
    }

    /**
     * JSON 字节数组转换为 Bean 对象
     * @param type Bean 类型
     * @param jsonBytes JSON 字节数组
     * @param <T> 泛型
     * @return Bean List
     * @since v1.2.0
     */
    public static <T> List<T> toList(Class<T> type, byte[] jsonBytes) {
        return JSONFinder.find().toList(type, new ByteArrayInputStream(jsonBytes), CHARSET);
    }

    /**
     * 对象转 JSON 字符串
     * @param object 对象
     * @return JSON 字符串
     */
    public static String toJson(Object object) {
        return JSONFinder.find().serialize(object);
    }

    /**
     * 对象转 JSON 字节数组
     * @param object 对象
     * @return JSON 字节数组
     * @since v1.2.0
     */
    public static byte[] toJsonBytes(Object object) {
        return JSONFinder.find().serialize(object, CHARSET);
    }

}


package cn.zhxu.xjson;

import cn.zhxu.data.Array;
import cn.zhxu.data.DataConvertor;
import cn.zhxu.data.Mapper;
import cn.zhxu.data.TypeRef;
import cn.zhxu.xjson.spi.Config;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author Troy.Zhou
 * @since 1.4.0
 *
 * JSONB 工具类，不依赖具体实现
 */
public class JsonbKit {

    private static final Charset CHARSET = StandardCharsets.UTF_8;

    /**
     * 初始化
     * @param convertor 转换器
     */
    public static void init(DataConvertor convertor) {
        Config.jsonb(convertor);
    }

    /**
     * JSONB 的 Base64 字符串转换为 Mapper 对象
     * @param jsonbBase64 JSONB 的 Base64 字符串
     * @return Mapper
     */
    public static Mapper toMapper(String jsonbBase64) {
        return Config.jsonb().toMapper(jsonbBase64);
    }

    /**
     * JSONB 字节数组转换为 Mapper 对象
     * @param jsonbBytes JSONB 字节数组
     * @return Mapper
     * @since v1.3.0
     */
    public static Mapper toMapper(byte[] jsonbBytes) {
        return Config.jsonb().toMapper(new ByteArrayInputStream(jsonbBytes), CHARSET);
    }

    /**
     * JSONB 的 Base64 字符串转换为 Array 对象
     * @param jsonbBase64 JSONB 的 Base64 字符串
     * @return Array
     */
    public static Array toArray(String jsonbBase64) {
        return Config.jsonb().toArray(jsonbBase64);
    }

    /**
     * JSONB 字节数组转换为 Array 对象
     * @param jsonbBytes JSONB 字节数组
     * @return Array
     * @since v1.3.0
     */
    public static Array toArray(byte[] jsonbBytes) {
        return Config.jsonb().toArray(new ByteArrayInputStream(jsonbBytes), CHARSET);
    }

    /**
     * JSONB 的 Base64 字符串转换为 Bean 对象
     * @param type Bean 类型
     * @param jsonbBase64 JSONB 的 Base64 字符串
     * @param <T> 泛型
     * @return Bean 对象
     */
    public static <T> T toBean(Type type, String jsonbBase64) {
        return Config.jsonb().toBean(type, jsonbBase64);
    }

    /**
     * JSONB 字节数组转换为 Bean 对象
     * @param type Bean 类型
     * @param jsonbBytes JSONB 字节数组
     * @param <T> 泛型
     * @return Bean 对象
     * @since v1.3.0
     */
    public static <T> T toBean(Type type, byte[] jsonbBytes) {
        return Config.jsonb().toBean(type, new ByteArrayInputStream(jsonbBytes), CHARSET);
    }

    /**
     * JSONB 的 Base64 字符串转换为 Bean 对象
     * @param typeRef Bean 类型
     * @param jsonbBase64 JSONB 的 Base64 字符串
     * @param <T> 泛型
     * @return Bean 对象
     * @since v1.2.0
     */
    public static <T> T toBean(TypeRef<T> typeRef, String jsonbBase64) {
        return toBean(typeRef.getType(), jsonbBase64);
    }

    /**
     * JSONB 字节数组转换为 Bean 对象
     * @param typeRef Bean 类型
     * @param jsonbBytes JSONB 字节数组
     * @param <T> 泛型
     * @return Bean 对象
     * @since v1.2.0
     */
    public static <T> T toBean(TypeRef<T> typeRef, byte[] jsonbBytes) {
        return toBean(typeRef.getType(), jsonbBytes);
    }

    /**
     * JSONB 的 Base64 字符串转换为 Bean 对象
     * @param type Bean 类型
     * @param jsonbBase64 JSONB 的 Base64 字符串
     * @param <T> 泛型
     * @return Bean List
     */
    public static <T> List<T> toList(Class<T> type, String jsonbBase64) {
        return Config.jsonb().toList(type, jsonbBase64);
    }

    /**
     * JSONB 字节数组转换为 Bean 对象
     * @param type Bean 类型
     * @param jsonbBytes JSONB 字节数组
     * @param <T> 泛型
     * @return Bean List
     * @since v1.2.0
     */
    public static <T> List<T> toList(Class<T> type, byte[] jsonbBytes) {
        return Config.jsonb().toList(type, new ByteArrayInputStream(jsonbBytes), CHARSET);
    }

    /**
     * 对象转 JSONB 的 Base64 字符串
     * @param object 对象
     * @return JSONB 的 Base64 字符串
     */
    public static String toBase64(Object object) {
        return Config.jsonb().serialize(object);
    }

    /**
     * 对象转 JSONB 字节数组
     * @param object 对象
     * @return JSONB 字节数组
     * @since v1.2.0
     */
    public static byte[] toBytes(Object object) {
        return Config.jsonb().serialize(object, CHARSET);
    }

}


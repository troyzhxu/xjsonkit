package cn.zhxu.xjson;

import cn.zhxu.data.Array;
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
 * @since 1.0.0
 *
 * JSON 工具类，不依赖具体实现
 */
public class JsonKit {

    private static final Charset CHARSET = StandardCharsets.UTF_8;

    /**
     * JSON 字符串转换为 Mapper 对象
     * @param json JSON 字符串
     * @return Mapper
     */
    public static Mapper toMapper(String json) {
        return Config.json().toMapper(json);
    }

    /**
     * JSON 字节数组转换为 Mapper 对象
     * @param jsonBytes JSON 字节数组
     * @return Mapper
     * @since v1.3.0
     */
    public static Mapper toMapper(byte[] jsonBytes) {
        return Config.json().toMapper(new ByteArrayInputStream(jsonBytes), CHARSET);
    }

    /**
     * JSON 字符串转换为 Array 对象
     * @param json JSON 字符串
     * @return Array
     */
    public static Array toArray(String json) {
        return Config.json().toArray(json);
    }

    /**
     * JSON 字节数组转换为 Array 对象
     * @param jsonBytes JSON 字节数组
     * @return Array
     * @since v1.3.0
     */
    public static Array toArray(byte[] jsonBytes) {
        return Config.json().toArray(new ByteArrayInputStream(jsonBytes), CHARSET);
    }

    /**
     * JSON 字符串转换为 Bean 对象
     * @param type Bean 类型
     * @param json JSON 字符串
     * @param <T> 泛型
     * @return Bean 对象
     */
    public static <T> T toBean(Type type, String json) {
        return Config.json().toBean(type, json);
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
        return Config.json().toBean(type, new ByteArrayInputStream(jsonBytes), CHARSET);
    }

    /**
     * JSON 字符串转换为 Bean 对象
     * @param typeRef Bean 类型
     * @param json JSON 字符串
     * @param <T> 泛型
     * @return Bean 对象
     * @since v1.2.0
     */
    public static <T> T toBean(TypeRef<T> typeRef, String json) {
        return toBean(typeRef.getType(), json);
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
     * @param json JSON 字符串
     * @param <T> 泛型
     * @return Bean List
     */
    public static <T> List<T> toList(Class<T> type, String json) {
        return Config.json().toList(type, json);
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
        return Config.json().toList(type, new ByteArrayInputStream(jsonBytes), CHARSET);
    }

    /**
     * 对象转 JSON 字符串
     * @param object 对象
     * @return JSON 字符串
     */
    public static String toJson(Object object) {
        return Config.json().serialize(object);
    }

    /**
     * 对象转 JSON 字符串
     * @param object 对象
     * @param pretty 是否格式化
     * @return JSON 字符串
     * @since v1.5.0
     */
    public static String toJson(Object object, boolean pretty) {
        return Config.json().serialize(object, pretty);
    }

    /**
     * 对象转 JSON 格式化字符串
     * @param object 对象
     * @return JSON 字符串
     * @since v1.5.0
     */
    public static String toPretty(Object object) {
        return Config.json().serialize(object, true);
    }

    /**
     * 对象转 JSON 字节数组
     * @param object 对象
     * @return JSON 字节数组
     * @since v1.2.0
     */
    public static byte[] toBytes(Object object) {
        return Config.json().serialize(object, CHARSET);
    }

}


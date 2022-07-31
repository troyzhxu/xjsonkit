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
 * Yaml 工具类，不依赖具体实现
 */
public class YamlKit {

    private static final Charset CHARSET = StandardCharsets.UTF_8;

    /**
     * Yaml 字符串转换为 Mapper 对象
     * @param yaml Yaml 字符串
     * @return Mapper
     */
    public static Mapper toMapper(String yaml) {
        return Config.yaml().toMapper(yaml);
    }

    /**
     * Yaml 字节数组转换为 Mapper 对象
     * @param yamlBytes Yaml 字节数组
     * @return Mapper
     * @since v1.3.0
     */
    public static Mapper toMapper(byte[] yamlBytes) {
        return Config.yaml().toMapper(new ByteArrayInputStream(yamlBytes), CHARSET);
    }

    /**
     * Yaml 字符串转换为 Array 对象
     * @param yaml Yaml 字符串
     * @return Array
     */
    public static Array toArray(String yaml) {
        return Config.yaml().toArray(yaml);
    }

    /**
     * Yaml 字节数组转换为 Array 对象
     * @param yamlBytes Yaml 字节数组
     * @return Array
     * @since v1.3.0
     */
    public static Array toArray(byte[] yamlBytes) {
        return Config.yaml().toArray(new ByteArrayInputStream(yamlBytes), CHARSET);
    }

    /**
     * Yaml 字符串转换为 Bean 对象
     * @param type Bean 类型
     * @param yaml Yaml 字符串
     * @param <T> 泛型
     * @return Bean 对象
     */
    public static <T> T toBean(Type type, String yaml) {
        return Config.yaml().toBean(type, yaml);
    }

    /**
     * Yaml 字节数组转换为 Bean 对象
     * @param type Bean 类型
     * @param yamlBytes Yaml 字节数组
     * @param <T> 泛型
     * @return Bean 对象
     * @since v1.3.0
     */
    public static <T> T toBean(Type type, byte[] yamlBytes) {
        return Config.yaml().toBean(type, new ByteArrayInputStream(yamlBytes), CHARSET);
    }

    /**
     * Yaml 字符串转换为 Bean 对象
     * @param typeRef Bean 类型
     * @param yaml Yaml 字符串
     * @param <T> 泛型
     * @return Bean 对象
     * @since v1.2.0
     */
    public static <T> T toBean(TypeRef<T> typeRef, String yaml) {
        return toBean(typeRef.getType(), yaml);
    }

    /**
     * Yaml 字节数组转换为 Bean 对象
     * @param typeRef Bean 类型
     * @param yamlBytes Yaml 字节数组
     * @param <T> 泛型
     * @return Bean 对象
     * @since v1.2.0
     */
    public static <T> T toBean(TypeRef<T> typeRef, byte[] yamlBytes) {
        return toBean(typeRef.getType(), yamlBytes);
    }

    /**
     * Yaml 字符串转换为 Bean 对象
     * @param type Bean 类型
     * @param yaml Yaml 字符串
     * @param <T> 泛型
     * @return Bean List
     */
    public static <T> List<T> toList(Class<T> type, String yaml) {
        return Config.yaml().toList(type, yaml);
    }

    /**
     * Yaml 字节数组转换为 Bean 对象
     * @param type Bean 类型
     * @param yamlBytes Yaml 字节数组
     * @param <T> 泛型
     * @return Bean List
     * @since v1.2.0
     */
    public static <T> List<T> toList(Class<T> type, byte[] yamlBytes) {
        return Config.yaml().toList(type, new ByteArrayInputStream(yamlBytes), CHARSET);
    }

    /**
     * 对象转 Yaml 字符串
     * @param object 对象
     * @return Yaml 字符串
     */
    public static String toYaml(Object object) {
        return Config.yaml().serialize(object);
    }

    /**
     * 对象转 Yaml 字节数组
     * @param object 对象
     * @return Yaml 字节数组
     * @since v1.2.0
     */
    public static byte[] toBytes(Object object) {
        return Config.yaml().serialize(object, CHARSET);
    }

}


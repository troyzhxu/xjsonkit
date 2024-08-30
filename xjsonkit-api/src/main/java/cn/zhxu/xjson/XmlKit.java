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
 * XML 工具类，不依赖具体实现
 */
public class XmlKit {

    private static final Charset CHARSET = StandardCharsets.UTF_8;

    /**
     * XML 字符串转换为 Mapper 对象
     * @param xml XML 字符串
     * @return Mapper
     */
    public static Mapper toMapper(String xml) {
        return Config.xml().toMapper(xml);
    }

    /**
     * XML 字节数组转换为 Mapper 对象
     * @param xmlBytes XML 字节数组
     * @return Mapper
     * @since v1.3.0
     */
    public static Mapper toMapper(byte[] xmlBytes) {
        return Config.xml().toMapper(new ByteArrayInputStream(xmlBytes), CHARSET);
    }

    /**
     * XML 字符串转换为 Array 对象
     * @param xml XML 字符串
     * @return Array
     */
    public static Array toArray(String xml) {
        return Config.xml().toArray(xml);
    }

    /**
     * XML 字节数组转换为 Array 对象
     * @param xmlBytes XML 字节数组
     * @return Array
     * @since v1.3.0
     */
    public static Array toArray(byte[] xmlBytes) {
        return Config.xml().toArray(new ByteArrayInputStream(xmlBytes), CHARSET);
    }

    /**
     * XML 字符串转换为 Bean 对象
     * @param type Bean 类型
     * @param xml XML 字符串
     * @param <T> 泛型
     * @return Bean 对象
     */
    public static <T> T toBean(Type type, String xml) {
        return Config.xml().toBean(type, xml);
    }

    /**
     * XML 字节数组转换为 Bean 对象
     * @param type Bean 类型
     * @param xmlBytes XML 字节数组
     * @param <T> 泛型
     * @return Bean 对象
     * @since v1.3.0
     */
    public static <T> T toBean(Type type, byte[] xmlBytes) {
        return Config.xml().toBean(type, new ByteArrayInputStream(xmlBytes), CHARSET);
    }

    /**
     * XML 字符串转换为 Bean 对象
     * @param typeRef Bean 类型
     * @param xml XML 字符串
     * @param <T> 泛型
     * @return Bean 对象
     * @since v1.2.0
     */
    public static <T> T toBean(TypeRef<T> typeRef, String xml) {
        return toBean(typeRef.getType(), xml);
    }

    /**
     * XML 字节数组转换为 Bean 对象
     * @param typeRef Bean 类型
     * @param xmlBytes XML 字节数组
     * @param <T> 泛型
     * @return Bean 对象
     * @since v1.2.0
     */
    public static <T> T toBean(TypeRef<T> typeRef, byte[] xmlBytes) {
        return toBean(typeRef.getType(), xmlBytes);
    }

    /**
     * XML 字符串转换为 Bean 对象
     * @param type Bean 类型
     * @param xml XML 字符串
     * @param <T> 泛型
     * @return Bean List
     */
    public static <T> List<T> toList(Class<T> type, String xml) {
        return Config.xml().toList(type, xml);
    }

    /**
     * XML 字节数组转换为 Bean 对象
     * @param type Bean 类型
     * @param xmlBytes XML 字节数组
     * @param <T> 泛型
     * @return Bean List
     * @since v1.2.0
     */
    public static <T> List<T> toList(Class<T> type, byte[] xmlBytes) {
        return Config.xml().toList(type, new ByteArrayInputStream(xmlBytes), CHARSET);
    }

    /**
     * 对象转 XML 字符串
     * @param object 对象
     * @return XML 字符串
     */
    public static String toXml(Object object) {
        return Config.xml().serialize(object);
    }

    /**
     * 对象转 XML 字符串
     * @param object 对象
     * @return XML 字符串
     */
    public static String toXml(Object object, boolean pretty) {
        return Config.xml().serialize(object, pretty);
    }

    /**
     * 对象转 XML 格式化字符串
     * @param object 对象
     * @return JSON 字符串
     * @since v1.5.0
     */
    public static String toPretty(Object object) {
        return Config.json().serialize(object, true);
    }

    /**
     * 对象转 XML 字节数组
     * @param object 对象
     * @return XML 字节数组
     * @since v1.2.0
     */
    public static byte[] toBytes(Object object) {
        return Config.xml().serialize(object, CHARSET);
    }

}


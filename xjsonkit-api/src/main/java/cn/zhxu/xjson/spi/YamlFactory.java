package cn.zhxu.xjson.spi;

import cn.zhxu.data.DataConvertor;

import java.util.ServiceLoader;

public interface YamlFactory {

    DataConvertor create();

    static DataConvertor find() {
        for (YamlFactory factory : ServiceLoader.load(YamlFactory.class)) {
            DataConvertor convertor = factory.create();
            if (convertor != null) {
                return convertor;
            }
        }
        throw new IllegalStateException("No YamlFactory found");
    }

}

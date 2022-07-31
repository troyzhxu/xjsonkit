package cn.zhxu.xjson.spi;

import cn.zhxu.data.DataConvertor;

import java.util.ServiceLoader;

public interface JsonFactory {

    DataConvertor create();

    static DataConvertor find() {
        for (JsonFactory factory : ServiceLoader.load(JsonFactory.class)) {
            DataConvertor convertor = factory.create();
            if (convertor != null) {
                return convertor;
            }
        }
        throw new IllegalStateException("No JsonFactory found");
    }

}

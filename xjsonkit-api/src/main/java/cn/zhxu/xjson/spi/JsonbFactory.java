package cn.zhxu.xjson.spi;

import cn.zhxu.data.DataConvertor;

import java.util.ServiceLoader;

public interface JsonbFactory {

    DataConvertor create();

    static DataConvertor find() {
        for (JsonbFactory factory : ServiceLoader.load(JsonbFactory.class)) {
            DataConvertor convertor = factory.create();
            if (convertor != null) {
                return convertor;
            }
        }
        throw new IllegalStateException("No JsonbFactory found");
    }

}

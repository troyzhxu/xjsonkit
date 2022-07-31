package cn.zhxu.xjson.jackson;

import cn.zhxu.data.DataConvertor;
import cn.zhxu.data.jackson.JacksonDataConvertor;
import cn.zhxu.xjson.spi.JsonFactory;

public class JacksonFactory implements JsonFactory {

    @Override
    public DataConvertor create() {
        return new JacksonDataConvertor();
    }

}

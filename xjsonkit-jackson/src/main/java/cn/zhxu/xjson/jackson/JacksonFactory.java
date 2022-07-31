package cn.zhxu.xjson.jackson;

import cn.zhxu.xjson.JSONFactory;
import cn.zhxu.data.DataConvertor;
import cn.zhxu.data.jackson.JacksonDataConvertor;

public class JacksonFactory implements JSONFactory {

    @Override
    public DataConvertor create() {
        return new JacksonDataConvertor();
    }

}

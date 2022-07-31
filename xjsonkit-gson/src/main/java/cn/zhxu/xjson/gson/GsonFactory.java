package cn.zhxu.xjson.gson;

import cn.zhxu.data.DataConvertor;
import cn.zhxu.data.gson.GsonDataConvertor;
import cn.zhxu.xjson.spi.JsonFactory;

public class GsonFactory implements JsonFactory {

    @Override
    public DataConvertor create() {
        return new GsonDataConvertor();
    }

}

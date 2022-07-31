package cn.zhxu.xjson.fastjson2;

import cn.zhxu.data.DataConvertor;
import cn.zhxu.data.fastjson2.Fastjson2DataConvertor;
import cn.zhxu.xjson.spi.JsonFactory;

public class Fastjson2Factory implements JsonFactory {

    @Override
    public DataConvertor create() {
        return new Fastjson2DataConvertor();
    }

}

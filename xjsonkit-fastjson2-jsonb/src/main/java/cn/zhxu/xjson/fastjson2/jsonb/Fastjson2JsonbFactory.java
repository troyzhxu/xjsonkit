package cn.zhxu.xjson.fastjson2.jsonb;

import cn.zhxu.data.DataConvertor;
import cn.zhxu.data.fastjson2.jsonb.Fastjson2JsonbDataConvertor;
import cn.zhxu.xjson.spi.JsonbFactory;

public class Fastjson2JsonbFactory implements JsonbFactory {

    @Override
    public DataConvertor create() {
        return new Fastjson2JsonbDataConvertor();
    }

}

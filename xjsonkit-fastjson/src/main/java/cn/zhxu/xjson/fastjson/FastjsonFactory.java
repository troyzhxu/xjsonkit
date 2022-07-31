package cn.zhxu.xjson.fastjson;

import cn.zhxu.data.DataConvertor;
import cn.zhxu.data.fastjson.FastjsonDataConvertor;
import cn.zhxu.xjson.spi.JsonFactory;

public class FastjsonFactory implements JsonFactory {

    @Override
    public DataConvertor create() {
        return new FastjsonDataConvertor();
    }

}

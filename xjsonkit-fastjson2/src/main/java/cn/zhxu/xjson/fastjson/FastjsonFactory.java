package cn.zhxu.xjson.fastjson;

import cn.zhxu.data.DataConvertor;
import cn.zhxu.data.fastjson2.Fastjson2DataConvertor;
import cn.zhxu.xjson.JSONFactory;

public class FastjsonFactory implements JSONFactory {

    @Override
    public DataConvertor create() {
        return new Fastjson2DataConvertor();
    }

}

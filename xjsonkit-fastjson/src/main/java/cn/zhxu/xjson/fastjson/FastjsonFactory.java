package cn.zhxu.xjson.fastjson;

import cn.zhxu.xjson.JSONFactory;
import cn.zhxu.data.DataConvertor;
import cn.zhxu.data.fastjson.FastjsonDataConvertor;

public class FastjsonFactory implements JSONFactory {

    @Override
    public DataConvertor create() {
        return new FastjsonDataConvertor();
    }

}

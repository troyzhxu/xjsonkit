package cn.zhxu.xjson.gson;

import cn.zhxu.xjson.JSONFactory;
import cn.zhxu.data.DataConvertor;
import cn.zhxu.data.gson.GsonDataConvertor;

public class GsonFactory implements JSONFactory {

    @Override
    public DataConvertor create() {
        return new GsonDataConvertor();
    }

}

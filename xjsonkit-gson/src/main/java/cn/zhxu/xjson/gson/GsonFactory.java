package cn.zhxu.xjson.gson;

import cn.zhxu.xjson.JSONFactory;
import com.ejlchina.data.DataConvertor;
import com.ejlchina.data.gson.GsonDataConvertor;

public class GsonFactory implements JSONFactory {

    @Override
    public DataConvertor create() {
        return new GsonDataConvertor();
    }

}

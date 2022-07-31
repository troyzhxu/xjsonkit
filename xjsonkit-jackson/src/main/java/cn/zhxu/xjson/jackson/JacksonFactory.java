package cn.zhxu.xjson.jackson;

import cn.zhxu.xjson.JSONFactory;
import com.ejlchina.data.DataConvertor;
import com.ejlchina.data.jackson.JacksonDataConvertor;

public class JacksonFactory implements JSONFactory {

    @Override
    public DataConvertor create() {
        return new JacksonDataConvertor();
    }

}

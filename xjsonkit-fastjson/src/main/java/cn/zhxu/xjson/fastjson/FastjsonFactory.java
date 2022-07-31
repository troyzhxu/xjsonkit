package cn.zhxu.xjson.fastjson;

import cn.zhxu.xjson.JSONFactory;
import com.ejlchina.data.DataConvertor;
import com.ejlchina.data.fastjson.FastjsonDataConvertor;

public class FastjsonFactory implements JSONFactory {

    @Override
    public DataConvertor create() {
        return new FastjsonDataConvertor();
    }

}

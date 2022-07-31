package cn.zhxu.xjson.snack3;

import cn.zhxu.data.DataConvertor;
import cn.zhxu.data.snack3.Snack3DataConvertor;
import cn.zhxu.xjson.JSONFactory;

public class Snack3Factory implements JSONFactory {

    @Override
    public DataConvertor create() {
        return new Snack3DataConvertor();
    }

}

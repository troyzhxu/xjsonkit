package cn.zhxu.xjson.snack3;

import cn.zhxu.data.DataConvertor;
import cn.zhxu.data.snack3.Snack3DataConvertor;
import cn.zhxu.xjson.spi.JsonFactory;

public class Snack3Factory implements JsonFactory {

    @Override
    public DataConvertor create() {
        return new Snack3DataConvertor();
    }

}

package cn.zhxu.xjson.jackson.xml;

import cn.zhxu.data.DataConvertor;
import cn.zhxu.data.jackson.xml.JacksonXmlDataConvertor;
import cn.zhxu.xjson.JSONFactory;

public class JacksonXmlFactory implements JSONFactory {

    @Override
    public DataConvertor create() {
        return new JacksonXmlDataConvertor();
    }

}

package cn.zhxu.xjson.jackson.xml;

import cn.zhxu.data.DataConvertor;
import cn.zhxu.data.jackson.xml.JacksonXmlDataConvertor;
import cn.zhxu.xjson.spi.XmlFactory;

public class JacksonXmlFactory implements XmlFactory {

    @Override
    public DataConvertor create() {
        return new JacksonXmlDataConvertor();
    }

}

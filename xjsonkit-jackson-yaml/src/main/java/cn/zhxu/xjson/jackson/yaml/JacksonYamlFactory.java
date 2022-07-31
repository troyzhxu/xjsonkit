package cn.zhxu.xjson.jackson.yaml;

import cn.zhxu.data.jackson.yaml.JacksonYamlDataConvertor;
import cn.zhxu.xjson.JSONFactory;
import cn.zhxu.data.DataConvertor;

public class JacksonYamlFactory implements JSONFactory {

    @Override
    public DataConvertor create() {
        return new JacksonYamlDataConvertor();
    }

}

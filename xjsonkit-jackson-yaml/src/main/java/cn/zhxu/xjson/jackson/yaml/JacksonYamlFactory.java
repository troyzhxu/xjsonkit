package cn.zhxu.xjson.jackson.yaml;

import cn.zhxu.data.jackson.yaml.JacksonYamlDataConvertor;
import cn.zhxu.data.DataConvertor;
import cn.zhxu.xjson.spi.YamlFactory;

public class JacksonYamlFactory implements YamlFactory {

    @Override
    public DataConvertor create() {
        return new JacksonYamlDataConvertor();
    }

}

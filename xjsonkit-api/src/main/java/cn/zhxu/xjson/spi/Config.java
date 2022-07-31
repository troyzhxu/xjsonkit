package cn.zhxu.xjson.spi;

import cn.zhxu.data.DataConvertor;

public class Config {

    private static DataConvertor json;
    private static DataConvertor jsonb;
    private static DataConvertor xml;
    private static DataConvertor yaml;

    public static void json(DataConvertor json) {
        Config.json = json;
    }

    public static void jsonb(DataConvertor jsonb) {
        Config.jsonb = jsonb;
    }

    public static void xml(DataConvertor xml) {
        Config.xml = xml;
    }

    public static void yaml(DataConvertor yaml) {
        Config.yaml = yaml;
    }

    public static DataConvertor json() {
        if (json == null) {
            json = JsonFactory.find();
        }
        return json;
    }

    public static DataConvertor jsonb() {
        if (jsonb == null) {
            jsonb = JsonbFactory.find();
        }
        return jsonb;
    }

    public static DataConvertor xml() {
        if (xml == null) {
            xml = JsonbFactory.find();
        }
        return xml;
    }

    public static DataConvertor yaml() {
        if (yaml == null) {
            yaml = JsonbFactory.find();
        }
        return yaml;
    }

}

module jsonkit.fastjson {
    requires jsonkit.core;
    requires data.core;
    requires data.fastjson;
    exports com.ejlchina.json.fastjson;

    provides com.ejlchina.json.JSONFactory with com.ejlchina.json.fastjson.FastjsonFactory;

}
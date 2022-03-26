module jsonkit.gson {
    requires jsonkit.core;
    requires data.core;
    requires data.gson;
    exports com.ejlchina.json.gson;

    provides com.ejlchina.json.JSONFactory with com.ejlchina.json.gson.GsonFactory;

}
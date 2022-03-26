module jsonkit.jackson {
    requires jsonkit.core;
    requires data.core;
    requires data.jackson;
    exports com.ejlchina.json.jackson;

    provides com.ejlchina.json.JSONFactory with com.ejlchina.json.jackson.JacksonFactory;

}
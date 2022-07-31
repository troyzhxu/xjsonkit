package com.ejlchina.json.jackson;

import com.ejlchina.data.DataConvertor;
import com.ejlchina.data.jackson.JacksonDataConvertor;
import com.ejlchina.json.JSONFactory;

public class JacksonFactory implements JSONFactory {

    @Override
    public DataConvertor create() {
        return new JacksonDataConvertor();
    }

}

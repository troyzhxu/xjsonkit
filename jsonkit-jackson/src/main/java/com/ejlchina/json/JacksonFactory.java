package com.ejlchina.json;

import com.ejlchina.okhttps.DataConvertor;
import com.ejlchina.okhttps.JacksonDataConvertor;

public class JacksonFactory implements JSONFactory {

    @Override
    public DataConvertor create() {
        return new JacksonDataConvertor();
    }

}

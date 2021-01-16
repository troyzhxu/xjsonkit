package com.ejlchina.json;

import com.ejlchina.data.DataConvertor;
import com.ejlchina.data.JacksonDataConvertor;

public class JacksonFactory implements JSONFactory {

    @Override
    public DataConvertor create() {
        return new JacksonDataConvertor();
    }

}

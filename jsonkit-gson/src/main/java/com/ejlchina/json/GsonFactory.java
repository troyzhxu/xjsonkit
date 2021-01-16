package com.ejlchina.json;

import com.ejlchina.data.DataConvertor;
import com.ejlchina.data.GsonDataConvertor;

public class GsonFactory implements JSONFactory {

    @Override
    public DataConvertor create() {
        return new GsonDataConvertor();
    }

}

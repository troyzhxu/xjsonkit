package com.ejlchina.json;

import com.ejlchina.okhttps.DataConvertor;
import com.ejlchina.okhttps.GsonDataConvertor;

public class GsonFactory implements JSONFactory {

    @Override
    public DataConvertor create() {
        return new GsonDataConvertor();
    }

}

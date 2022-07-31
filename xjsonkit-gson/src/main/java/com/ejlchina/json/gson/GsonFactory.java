package com.ejlchina.json.gson;

import com.ejlchina.data.DataConvertor;
import com.ejlchina.data.gson.GsonDataConvertor;
import com.ejlchina.json.JSONFactory;

public class GsonFactory implements JSONFactory {

    @Override
    public DataConvertor create() {
        return new GsonDataConvertor();
    }

}

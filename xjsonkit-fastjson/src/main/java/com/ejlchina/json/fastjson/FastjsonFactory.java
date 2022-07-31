package com.ejlchina.json.fastjson;

import com.ejlchina.data.DataConvertor;
import com.ejlchina.data.fastjson.FastjsonDataConvertor;
import com.ejlchina.json.JSONFactory;

public class FastjsonFactory implements JSONFactory {

    @Override
    public DataConvertor create() {
        return new FastjsonDataConvertor();
    }

}

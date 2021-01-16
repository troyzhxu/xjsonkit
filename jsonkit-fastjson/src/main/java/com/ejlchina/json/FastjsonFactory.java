package com.ejlchina.json;

import com.ejlchina.data.DataConvertor;
import com.ejlchina.data.FastjsonDataConvertor;

public class FastjsonFactory implements JSONFactory {

    @Override
    public DataConvertor create() {
        return new FastjsonDataConvertor();
    }

}

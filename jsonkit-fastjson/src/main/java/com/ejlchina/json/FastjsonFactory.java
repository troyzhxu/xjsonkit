package com.ejlchina.json;

import com.ejlchina.okhttps.DataConvertor;
import com.ejlchina.okhttps.FastjsonDataConvertor;

public class FastjsonFactory implements JSONFactory {

    @Override
    public DataConvertor create() {
        return new FastjsonDataConvertor();
    }

}

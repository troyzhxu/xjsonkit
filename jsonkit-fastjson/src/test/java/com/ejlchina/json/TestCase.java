package com.ejlchina.json;


import com.ejlchina.json.fastjson.FastjsonFactory;
import org.junit.Test;

public class TestCase {

    @Test
    public void test() {
        new TestCases(new FastjsonFactory()).run();
    }

}

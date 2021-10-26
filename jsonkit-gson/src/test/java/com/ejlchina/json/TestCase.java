package com.ejlchina.json;

import com.ejlchina.json.gson.GsonFactory;
import org.junit.Test;

public class TestCase {

    @Test
    public void test() {
        new TestCases(new GsonFactory()).run();
    }

}

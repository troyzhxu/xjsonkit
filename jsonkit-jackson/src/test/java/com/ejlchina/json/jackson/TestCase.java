package com.ejlchina.json.jackson;

import com.ejlchina.json.test.TestCases;
import org.junit.Test;

public class TestCase {

    @Test
    public void test() {
        new TestCases(new JacksonFactory()).run();
    }

}

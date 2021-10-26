package com.ejlchina.json;

import com.ejlchina.json.jackson.JacksonFactory;
import org.junit.Test;

public class TestCase {

    @Test
    public void test() {
        new TestCases(new JacksonFactory()).run();
    }

}

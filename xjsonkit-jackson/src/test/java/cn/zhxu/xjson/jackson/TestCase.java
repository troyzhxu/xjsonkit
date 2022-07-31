package cn.zhxu.xjson.jackson;

import cn.zhxu.xjson.test.TestCases;
import org.junit.Test;

public class TestCase {

    @Test
    public void test() {
        new TestCases(new JacksonFactory().create()).run();
    }

}

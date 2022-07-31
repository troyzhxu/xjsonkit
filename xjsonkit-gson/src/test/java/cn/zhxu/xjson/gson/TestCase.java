package cn.zhxu.xjson.gson;

import cn.zhxu.xjson.test.TestCases;
import org.junit.Test;

public class TestCase {

    @Test
    public void test() {
        new TestCases(new GsonFactory().create()).run();
    }

}

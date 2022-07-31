package cn.zhxu.xjson.fastjson;

import cn.zhxu.xjson.test.TestCases;
import org.junit.Test;

public class TestCase {

    @Test
    public void test() {
        new TestCases(new FastjsonFactory().create()).run();
    }

}

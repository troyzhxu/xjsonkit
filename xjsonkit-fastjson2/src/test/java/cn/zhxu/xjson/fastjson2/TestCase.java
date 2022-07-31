package cn.zhxu.xjson.fastjson2;

import cn.zhxu.xjson.test.TestCases;
import org.junit.Test;

public class TestCase {

    @Test
    public void test() {
        new TestCases(new Fastjson2Factory().create()).run();
    }

}

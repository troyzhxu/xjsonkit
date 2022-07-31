package cn.zhxu.xjson.snack3;

import cn.zhxu.xjson.test.TestCases;
import org.junit.Test;

public class TestCase {

    @Test
    public void test() {
        new TestCases(new Snack3Factory().create()).run();
    }

}

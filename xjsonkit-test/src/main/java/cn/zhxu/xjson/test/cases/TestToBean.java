package cn.zhxu.xjson.test.cases;

import cn.zhxu.xjson.JSONKit;
import org.junit.Assert;

import java.nio.charset.StandardCharsets;

public class TestToBean {

    static final String case1 = "{\"name\": \"Jack\",\"age\":20}";

    public void test() {
        User bean1 = JSONKit.toBean(User.class, case1);
        checkCase(bean1);
        System.out.println("case1 ok!");
        User bean2 = JSONKit.toBean(User.class, case1.getBytes(StandardCharsets.UTF_8));
        checkCase(bean2);
        System.out.println("case2 ok!");
    }

    private void checkCase(User bean) {
        Assert.assertNotNull(bean);
        Assert.assertEquals("Jack", bean.getName());
        Assert.assertEquals(20, bean.getAge());
    }

}

package cn.zhxu.xjson.test.cases;

import cn.zhxu.xjson.JsonKit;
import org.junit.Assert;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class TestToList {

    static final String case1 = "[{\"name\": \"Jack\",\"age\":20},{\"name\": \"Tom\",\"age\":21}]";

    public void test() {
        checkCase(JsonKit.toList(User.class, case1));
        System.out.println("case1 ok!");
        checkCase(JsonKit.toList(User.class, case1.getBytes(StandardCharsets.UTF_8)));
        System.out.println("case2 ok!");
    }

    private void checkCase(List<User> list) {
        Assert.assertNotNull(list);
        Assert.assertEquals(2, list.size());
        User b1 = list.get(0);
        User b2 = list.get(1);
        Assert.assertNotNull(b1);
        Assert.assertNotNull(b2);
        Assert.assertEquals("Jack", b1.getName());
        Assert.assertEquals(20, b1.getAge());
        Assert.assertEquals("Tom", b2.getName());
        Assert.assertEquals(21, b2.getAge());
    }

}

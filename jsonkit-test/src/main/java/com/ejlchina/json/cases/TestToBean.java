package com.ejlchina.json.cases;

import com.ejlchina.json.JSONKit;
import org.junit.Assert;

public class TestToBean {

    static final String case1 = "{\"name\": \"Jack\",\"age\":20}";

    public void test() {
        User bean = JSONKit.toBean(User.class, case1);
        Assert.assertNotNull(bean);
        Assert.assertEquals("Jack", bean.getName());
        Assert.assertEquals(20, bean.getAge());
        System.out.println("case1 ok!");
    }


}

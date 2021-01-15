package com.ejlchina.json.cases;

import com.ejlchina.json.JSONKit;
import org.junit.Assert;

import java.util.List;

public class TestToList {

    static final String case1 = "[{\"name\": \"Jack\",\"age\":20},{\"name\": \"Tom\",\"age\":21}]";

    public void test() {
        List<Bean> list = JSONKit.toList(Bean.class, case1);
        Assert.assertNotNull(list);
        Assert.assertEquals(2, list.size());
        Bean b1 = list.get(0);
        Bean b2 = list.get(1);
        Assert.assertNotNull(b1);
        Assert.assertNotNull(b2);
        Assert.assertEquals("Jack", b1.getName());
        Assert.assertEquals(20, b1.getAge());
        Assert.assertEquals("Tom", b2.getName());
        Assert.assertEquals(21, b2.getAge());
        System.out.println("case1 ok!");
    }

}

package com.ejlchina.json.cases;

import com.ejlchina.json.JSONKit;
import com.ejlchina.data.Array;
import com.ejlchina.data.Mapper;
import org.junit.Assert;

public class TestToArray {

    static final String case1 = "[1,2,3]";

    static final String case2 = "[4,{\"name\": \"Jack\"}]";


    public void test() {
        Array a1 = JSONKit.toArray(case1);
        Assert.assertEquals(3, a1.size());
        Assert.assertEquals(1, a1.getInt(0));
        Assert.assertEquals(1, a1.getLong(0));
        Assert.assertEquals(2, a1.getInt(1));
        Assert.assertEquals(3, a1.getInt(2));
        System.out.println("case1 ok!");

        Array a2 = JSONKit.toArray(case2);
        Assert.assertEquals(2, a2.size());
        Assert.assertEquals(4, a2.getInt(0));
        Mapper m = a2.getMapper(1);
        Assert.assertNotNull(m);
        Assert.assertEquals(1, m.size());
        Assert.assertTrue(m.has("name"));
        Assert.assertEquals("Jack", m.getString("name"));
        System.out.println("case2 ok!");
    }

}

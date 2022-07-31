package cn.zhxu.xjson.test.cases;

import cn.zhxu.xjson.JSONKit;
import cn.zhxu.data.Array;
import cn.zhxu.data.Mapper;
import org.junit.Assert;

import java.nio.charset.StandardCharsets;

public class TestToArray {

    static final String case1 = "[1,2,3]";

    static final String case2 = "[4,{\"name\": \"Jack\"}]";


    public void test() {
        Array a1 = JSONKit.toArray(case1);
        checkCase1(a1);
        System.out.println("case1 ok!");
        Array a2 = JSONKit.toArray(case2);
        checkCase2(a2);
        System.out.println("case2 ok!");
        Array a3 = JSONKit.toArray(case1.getBytes(StandardCharsets.UTF_8));
        checkCase1(a3);
        System.out.println("case3 ok!");
        Array a4 = JSONKit.toArray(case2.getBytes(StandardCharsets.UTF_8));
        checkCase2(a4);
        System.out.println("case4 ok!");
    }

    private void checkCase1(Array a1) {
        Assert.assertEquals(3, a1.size());
        Assert.assertEquals(1, a1.getInt(0));
        Assert.assertEquals(1, a1.getLong(0));
        Assert.assertEquals(2, a1.getInt(1));
        Assert.assertEquals(3, a1.getInt(2));
    }

    private void checkCase2(Array a2) {
        Assert.assertEquals(2, a2.size());
        Assert.assertEquals(4, a2.getInt(0));
        Mapper m = a2.getMapper(1);
        Assert.assertNotNull(m);
        Assert.assertEquals(1, m.size());
        Assert.assertTrue(m.has("name"));
        Assert.assertEquals("Jack", m.getString("name"));
    }

}

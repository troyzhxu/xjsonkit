package com.ejlchina.json.cases;

import com.ejlchina.json.JSONKit;
import com.ejlchina.data.Mapper;
import org.junit.Assert;

import java.util.Set;

public class TestToMapper {

    static final String case1 = "{\"name\":\"Jack\",\"age\":20}";

    static final String case2 = "{\"school\":{\"name\":\"High School\"}}";

    public void test() {
        Mapper m1 = JSONKit.toMapper(case1);
        checkCase1(m1);
        System.out.println("TestToMapper case1 ok!");

        Mapper m2 = JSONKit.toMapper(case2);
        checkCase2(m2);
        System.out.println("TestToMapper case2 ok!");

        Mapper m3 = JSONKit.toMapper(case1);
        checkCase1(m3);
        System.out.println("TestToMapper case3 ok!");

        Mapper m4 = JSONKit.toMapper(case2);
        checkCase2(m4);
        System.out.println("TestToMapper case4 ok!");

    }

    private void checkCase2(Mapper m2) {
        Assert.assertEquals(1, m2.size());
        Assert.assertTrue(m2.has("school"));
        Assert.assertFalse(m2.has("name"));
        Mapper sch = m2.getMapper("school");
        Assert.assertNotNull(sch);
        Assert.assertEquals(1, sch.size());
        Assert.assertTrue(sch.has("name"));
        Assert.assertFalse(sch.has("school"));
        Assert.assertEquals("High School", sch.getString("name"));

    }

    private void checkCase1(Mapper m1) {
        Assert.assertEquals(2, m1.size());
        Assert.assertTrue(m1.has("name"));
        Assert.assertTrue(m1.has("age"));
        Assert.assertFalse(m1.has("sex"));
        Assert.assertArrayEquals(new String[]{"name", "age"}, m1.keySet().toArray());
        Assert.assertEquals("Jack", m1.getString("name"));
        Assert.assertEquals(20, m1.getInt("age"));
        Assert.assertEquals(20, m1.getLong("age"));
        Assert.assertEquals("20", m1.getString("age"));
    }


}

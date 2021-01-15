package com.ejlchina.json.cases;

import com.ejlchina.json.JSONKit;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class TestToJson {


    public void test() {
        Bean b1 = new Bean();
        b1.setName("Alice");
        b1.setAge(30);

        String json1 = JSONKit.toJson(b1);

        Assert.assertTrue("{\"name\":\"Alice\",\"age\":30}".equals(json1) || "{\"age\":30,\"name\":\"Alice\"}".equals(json1));

        List<Object> list = new ArrayList<>();
        list.add(1);
        list.add("A");
        list.add(2);

        Assert.assertEquals("[1,\"A\",2]", JSONKit.toJson(list));

        System.out.println("case1 ok!");
    }


}

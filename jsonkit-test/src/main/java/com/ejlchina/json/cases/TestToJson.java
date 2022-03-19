package com.ejlchina.json.cases;

import com.ejlchina.json.JSONKit;
import org.junit.Assert;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestToJson {


    public static final String JSON_OBJ_1 = "{\"name\":\"Alice\",\"age\":30}";
    public static final String JSON_OBJ_2 = "{\"age\":30,\"name\":\"Alice\"}";
    public static final String JSON_ARR = "[1,\"A\",2]";

    public void test() {
        User b1 = new User();
        b1.setName("Alice");
        b1.setAge(30);

        String json1 = JSONKit.toJson(b1);

        Assert.assertTrue(JSON_OBJ_1.equals(json1) || JSON_OBJ_2.equals(json1));

        System.out.println("TestToJson case1 ok!");

        byte[] jsonBytes = JSONKit.toJsonBytes(b1);

        Assert.assertTrue(Arrays.equals(jsonBytes, JSON_OBJ_1.getBytes(StandardCharsets.UTF_8))
                || Arrays.equals(jsonBytes, JSON_OBJ_2.getBytes(StandardCharsets.UTF_8)));

        System.out.println("TestToJson case2 ok!");

        List<Object> list = new ArrayList<>();
        list.add(1);
        list.add("A");
        list.add(2);

        Assert.assertEquals(JSON_ARR, JSONKit.toJson(list));

        System.out.println("TestToJson case3 ok!");

        Assert.assertEquals(JSON_ARR.getBytes(StandardCharsets.UTF_8), JSONKit.toJsonBytes(list));

        System.out.println("TestToJson case4 ok!");
    }


}

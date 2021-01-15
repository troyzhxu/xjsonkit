package com.ejlchina.json;


import com.ejlchina.json.cases.User;
import org.junit.Test;

public class TestCase {

    @Test
    public void test() {
        new TestCases(new FastjsonFactory()).run();

        String json = "{\"name\":\"Jack\",\"age\":20}";

        User user = JSONKit.toBean(User.class, json);

        System.out.println(user.getName());
        System.out.println(user.getAge());

    }

}

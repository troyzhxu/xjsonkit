package com.ejlchina.json;

import com.ejlchina.json.cases.*;

public class TestCases {


    public TestCases(JSONFactory factory) {
        JSONKit.init(factory.create());
    }


    public void run() {
        println("TestToMapper   ......");
        new TestToMapper().test();
        println("TestToArray    ......");
        new TestToArray().test();
        println("TestToBean     ......");
        new TestToBean().test();
        println("TestToList     ......");
        new TestToList().test();
        println("TestToJson     ......");
        new TestToJson().test();
    }

    void println(String msg) {
        System.out.println(msg);
    }

}

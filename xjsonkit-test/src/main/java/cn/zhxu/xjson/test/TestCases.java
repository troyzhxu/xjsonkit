package cn.zhxu.xjson.test;

import cn.zhxu.xjson.JSONFactory;
import cn.zhxu.xjson.JSONKit;
import cn.zhxu.xjson.test.cases.*;
import com.ejlchina.json.test.cases.*;

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

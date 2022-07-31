package cn.zhxu.xjson.test;

import cn.zhxu.data.DataConvertor;
import cn.zhxu.xjson.JsonKit;
import cn.zhxu.xjson.test.cases.*;

public class TestCases {


    public TestCases(DataConvertor convertor) {
        JsonKit.init(convertor);
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

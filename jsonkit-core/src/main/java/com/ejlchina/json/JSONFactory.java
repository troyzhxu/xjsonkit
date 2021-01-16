package com.ejlchina.json;

import com.ejlchina.data.DataConvertor;

/**
 * JSON 工厂
 */
public interface JSONFactory {

    /**
     * 创建一个 JSON 转换器
     * @return DataConvertor
     */
    DataConvertor create();

}

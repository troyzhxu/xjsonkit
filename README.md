# JsonKit

## 介绍

超轻量级 JSON 序列化与反序列化 门面框架，不依赖具体 JSON 实现，让你的业务代码可以在 Jackson、Gson、Fastjson 等具体实现之间切换自如。

## 安装教程

### Maven

```xml
<dependency>
    <groupId>com.ejlchina</groupId>
    <artifactId>jsonkit</artifactId>
    <version>1.0.0</version>
</dependency>
```

使用 Jackson 实现：

```xml
<dependency>
    <groupId>com.ejlchina</groupId>
    <artifactId>jsonkit-jackson</artifactId>
    <version>1.0.0</version>
</dependency>
```

使用 Gson 实现：

```xml
<dependency>
    <groupId>com.ejlchina</groupId>
    <artifactId>jsonkit-gson</artifactId>
    <version>1.0.0</version>
</dependency>
```

使用 Fastjson 实现：

```xml
<dependency>
    <groupId>com.ejlchina</groupId>
    <artifactId>jsonkit-fastjson</artifactId>
    <version>1.0.0</version>
</dependency>
```

以上依赖添加一个即可。

### Gradle

```groovy
implementation 'com.ejlchina:jsonkit:1.0.0'
```

使用 Jackson 实现：

```groovy
implementation 'com.ejlchina:jsonkit-jackson:1.0.0'
```

使用 Gson 实现：

```groovy
implementation 'com.ejlchina:jsonkit-gson:1.0.0'
```

使用 Fastjson 实现：

```groovy
implementation 'com.ejlchina:jsonkit-fastjson:1.0.0'
```

以上依赖添加一个即可。

## 使用说明

### 反序列化 toMapper

```java
String json = "{\"name\":\"Jack\",\"age\":20}";
// 转换为具有映射结构的 Mapper 对象
Mapper mapper = JSONKit.toMapper(json);

// 第一层的键集合大小
int size = mapper.size();                       // 2
// 第一层的键值集合
Set<String> keys = mapper.keySet();             // ["name", "age"]
// 按键名访问 String 属性
String name = mapper.getString("name");     // Jack
// 按键名访问 int 属性
int age = mapper.getInt("age");             // 20
    
// 遍历 JSON (第一层)
mapper.forEach((key, data) -> {
    System.out.println(key);                    // 依次输出 name 和 age
    System.out.println(data.toString());        // 依次输出 Jack 和 20
});
```

### 反序列化 toArray

```java
String json = "[1, 2, {\"name\":\"Jack\"}]";
// 转换为具有映射结构的 Mapper 对象
Mapper mapper = JSONKit.toMapper(json);

String name = mapper.getString("name");     // Jack
int age = mapper.getInt("age");             // 20
```


### 反序列化 toBean

### 反序列化 toList

### 正序列化 toJson

### 配置 JSONKit


## 参与贡献

1. Fork 本仓库
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request


## 特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  Gitee 官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解 Gitee 上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是 Gitee 最有价值开源项目，是综合评定出的优秀开源项目
5.  Gitee 官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  Gitee 封面人物是一档用来展示 Gitee 会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)

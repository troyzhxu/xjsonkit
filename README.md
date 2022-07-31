# xJsonKit

<p>
    <a href="https://maven-badges.herokuapp.com/maven-central/cn.zhxu/xjsonkit/"><img src="https://maven-badges.herokuapp.com/maven-central/cn.zhxu/xjsonkit/badge.svg" alt="Maven Central"></a>
    <a href="https://gitee.com/troyzhxu/xjsonkit/blob/master/LICENSE"><img src="https://img.shields.io/hexpm/l/plug.svg" alt="License"></a>
    <a href="https://github.com/troyzhxu"><img src="https://img.shields.io/badge/%E4%BD%9C%E8%80%85-troyzhxu-orange.svg" alt="Troy.Zhou"></a>
</p>

## 介绍

超轻量级 JSON **正序列化** 与 **反序列化** 的 **门面框架**，不依赖具体的 JSON 实现，让业务代码与 Jackson、Gson、Fastjson 等彻底 **解耦**，让你可以在需要的时候轻松切换项目底层实现！

## 安装教程

#### API 依赖

```groovy
implementation 'cn.zhxu:xjsonkit-api:1.5.0'
```

该依赖提供了 `JsonKit`、`JsonbKit`、`XmlKit`、`YamlKit` 四个工具类。

#### Json 相关实现

```groovy
// Fastjson 实现
implementation 'cn.zhxu:xjsonkit-fastjson:1.5.0'
// Fastjson2 实现
implementation 'cn.zhxu:xjsonkit-fastjson2:1.5.0'
// Gson 实现
implementation 'cn.zhxu:xjsonkit-gson:1.5.0'
// Jackson 实现
implementation 'cn.zhxu:xjsonkit-jackson:1.5.0'
// Snack3 实现
implementation 'cn.zhxu:xjsonkit-snack3:1.5.0'
```

#### JSONB 相关实现

```groovy
// Fastjson2-JSONB 实现
implementation 'cn.zhxu:xjsonkit-fastjson2-jsonb:1.5.0'
```

#### Xml 相关实现

```groovy
// Jackson Xml
implementation 'cn.zhxu:xjsonkit-jackson-xml:1.5.0'
```

#### Yaml 相关实现

```groovy
// Jackson Yaml
implementation 'cn.zhxu:xjsonkit-jackson-yaml:1.5.0'
```

## 使用说明

X Json Kit 共提供了 `JsonKit`、`JsonbKit`、`XmlKit`、`YamlKit` 四个工具类。下文以 `JsonKit` 为例简述其用法，其它工具类使用方法类似。

### 反序列化 toMapper

```java
String json = "{\"name\":\"Jack\",\"age\":20}";
// 转换为具有映射结构的 Mapper 对象
Mapper mapper = JsonKit.toMapper(json);

// 第一层的键集合大小
int size = mapper.size();               // 2
// 第一层的键值集合
Set<String> keys = mapper.keySet();     // ["name", "age"]
// 按键名访问 String 属性
String name = mapper.getString("name"); // Jack
// 按键名访问 int 属性
int age = mapper.getInt("age");         // 20
    
// 遍历 Mapper 对象
mapper.forEach((key, data) -> {
    System.out.println(key);            // 依次输出 name 和 age
    System.out.println(data);           // 依次输出 Jack 和 20
});

System.out.println(mapper);             // 输出 {"name":"Jack","age":20}
```

### 反序列化 toArray

```java
String json = "[20,{\"name\":\"Jack\"},\"JsonKit\"]";
// 转换为具有数组结构的 Array 对象
Array array = JsonKit.toArray(json);

// 数组大小
int size = array.size();                // 3
// 按下标获取 int 数据
int value = array.getInt(0);            // 20
// 按下标获取 Mapper 数据
Mapper mapper = array.getMapper(1);     // {"name":"Jack"}
// 按下标获取 String 数据
String string = array.getString(2);     // JsonKit

// 遍历 Array 对象
array.forEach(((index, data) -> {
    System.out.println(index);          // 依次输出 0、 1 和 2
    System.out.println(data);           // 依次输出 20、 {"name":"Jack"} 和 JsonKit
}));

System.out.println(array);              // 输出 [20,{"name":"Jack"},"JsonKit"]
```

### 反序列化 toBean

```java
String json = "{\"name\":\"Jack\",\"age\":20}";
// 根据类型 转换为 Java Bean
User user = JsonKit.toBean(User.class, json);

String name = user.getName();           // Jack
int name = user.getAge();               // 20
```

### 反序列化 toList

```java
String json = "[{\"name\":\"Jack\",\"age\":20}, {\"name\":\"Tom\",\"age\":21}]";
// 根据类型 转换为 Java List
List<User> list = JsonKit.toList(User.class, json);

int size = list.size();                 // 2
User user1 = list.get(0);               // {"name":"Jack","age":20}
User user2 = list.get(1);               // {"name":"Tom","age":21}
```

### 正序列化 toJson

```java
User user = new User();
user.setName("Jack");
user.setAge(20);

String json = JsonKit.toJson(user);     // 转换为 JSON 字符串

System.out.println(json);               // 输出 {"age":20,"name":"Jack"}
```

## 配置方法

如果已经添加了如 `jsonkit-jackson` 的适配包，默认不用任何配置即可正常使用。

但如果需要特殊配置，例如使用 Jackson 时，可在如下操作：

```java
ObjectMapper objectMapper = new ObjectMapper();

// 对 ObjectMapper 进行配置...
    
// 对 JsonKit 进行初始化
Config.json(new JacksonDataConvertor(ObjectMapper));
```

其中 `Config` 是 `cn.zhxu.xjson.spi` 包下的配置类，它里面有 `json(..)`、`jsonb(..)`、`xml(..)`、`yaml(..)` 四个配置方法，它们分别作用于 `JsonKit`、`JsonbKit`、`XmlKit`、`YamlKit` 四个工具类。
使用其它扩展包也类似操作。

## 友情链接

[**[ OkHttps ]** 轻量却强大的 HTTP 客户端，前后端通用，支持 WebSocket 与 Stomp 协议](https://gitee.com/troyzhxu/okhttps)

[**[ Bean Searcher ]** 轻量级数据库条件检索引擎，一行代码实现复杂条件列表检索！](https://gitee.com/troyzhxu/bean-searcher)

## 参与贡献

1. Star Fork 本仓库
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request


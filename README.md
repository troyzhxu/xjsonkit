# xJsonKit

<p>
    <a href="https://maven-badges.herokuapp.com/maven-central/cn.zhxu/xjsonkit/"><img src="https://maven-badges.herokuapp.com/maven-central/cn.zhxu/xjsonkit/badge.svg" alt="Maven Central"></a>
    <a href="https://gitee.com/troyzhxu/xjsonkit/blob/master/LICENSE"><img src="https://img.shields.io/hexpm/l/plug.svg" alt="License"></a>
    <a href="https://github.com/troyzhxu"><img src="https://img.shields.io/badge/%E4%BD%9C%E8%80%85-troyzhxu-orange.svg" alt="Troy.Zhou"></a>
</p>

## 介绍

超轻量级 **JSON** / **JSONB** / **XML** / **YAML** 的 **正序列化** 与 **反序列化** 的 **门面框架**，让业务代码不依赖具体的实现，与 Jackson、Gson、Fastjson 等 **解耦**，让你可以在需要的时候轻松切换项目底层实现！

## 安装教程

#### API 依赖

```groovy
implementation 'cn.zhxu:xjsonkit-api:1.5.0'
```

该依赖提供了 `JsonKit`、`JsonbKit`、`XmlKit`、`YamlKit` 四个工具类，它们分别提供了对 JSON / JSONB / XML / YAML 类型数据的正反序列化操作相关的 API。

#### JSON 相关实现

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

#### XML 相关实现

```groovy
// Jackson Xml
implementation 'cn.zhxu:xjsonkit-jackson-xml:1.5.0'
```

#### YAML 相关实现

```groovy
// Jackson Yaml
implementation 'cn.zhxu:xjsonkit-jackson-yaml:1.5.0'
```

## 使用说明

xJsonKit 共提供了 `JsonKit`、`JsonbKit`、`XmlKit`、`YamlKit` 四个工具类。下文以 `JsonKit` 为例简述其用法，其它工具类使用方法类似。

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
System.out.println(mapper.toPretty());  // 格式化输出
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
System.out.println(array.toPretty());   // 格式化输出
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

String pretty = JsonKit.toPretty(user); // 转换为 格式化的 JSON 字符串
String pretty = JsonKit.toJson(user, true);
```

### 格式互转

* JSON 对象 转 XML、YAML、JSONB

```java
var json = "{\"id\":1,\"name\":\"Jack\",\"age\":20}";
// 转 XML
var xml = XmlKit.toXml(JsonKit.toMapper(json));
// 转 YAML
var yaml = XmlKit.toYaml(JsonKit.toMapper(json));
// 转 JSONB
var jsonb = JsonbKit.toBytes(JsonKit.toMapper(json));
```

* JSON 数组 转 XML、YAML、JSONB

```java
var json = "[{\"id\":1,\"name\":\"Jack\"},{\"id\":2,\"name\":\"Tom\"}]";
// 转 XML
var xml = XmlKit.toXml(JsonKit.toArray(json));
// 转 YAML
var yaml = XmlKit.toYaml(JsonKit.toArray(json));
// 转 JSONB
var jsonb = JsonbKit.toBytes(JsonKit.toArray(json));
```

* XML 对象 转 JSON、YAML、JSONB

```java
var xml = "<root><id>1</id><name>Jack</name><age>20</age></root>";
// 转 JSON
var json = JsonKit.toJson(XmlKit.toMapper(xml));
// 转 YAML
var yaml = XmlKit.toYaml(XmlKit.toMapper(xml));
// 转 JSONB
var jsonb = JsonbKit.toBytes(XmlKit.toMapper(xml));
```

* XML 数组 转 JSON、YAML、JSONB

```java
var xml = "<list><item><id>1</id><name>Jack</name></item><item><id>2</id><name>Tom</name></item></list>";
// 转 JSON
var json = JsonKit.toJson(XmlKit.toArray(xml));
// 转 YAML
var yaml = XmlKit.toYaml(XmlKit.toArray(xml));
// 转 JSONB
var jsonb = JsonbKit.toBytes(XmlKit.toArray(xml));
```

* 等等（YAML 与 JSONB 转其它格式同理）

## 配置方法

如果已经添加了如 `xjsonkit-jackson` 的底层实现包，则不用任何配置即可正常使用。

但如果需要特殊配置，例如使用 Jackson 时，可进行如下配置：

```java
ObjectMapper objectMapper = new ObjectMapper();
// TODO: 对 ObjectMapper 进行配置...

// 对 JsonKit 进行配置
Config.json(new JacksonDataConvertor(ObjectMapper));
```

其中 `Config` 是 `cn.zhxu.xjson.spi` 包下的配置类，它里面有 `json(..)`、`jsonb(..)`、`xml(..)`、`yaml(..)` 四个配置方法，它们分别作用于 `JsonKit`、`JsonbKit`、`XmlKit`、`YamlKit` 四个工具类。

### 自定义底层实现

只需实现 `DataConvertor` 接口即可：

```java
// 自定义 JSON 实现
Config.json(new MyJsonDataConvertor());
// 自定义 JSONB 实现
Config.jsonb(new MyJsonbDataConvertor());
// 自定义 XML 实现
Config.xml(new MyXmlDataConvertor());
// 自定义 YAML 实现
Config.yaml(new MyYamlDataConvertor());
```

## 友情链接

[**[ OkHttps ]** 轻量却强大的 HTTP 客户端，前后端通用，支持 WebSocket 与 Stomp 协议](https://gitee.com/troyzhxu/okhttps)

[**[ Bean Searcher ]** 轻量级数据库条件检索引擎，一行代码实现复杂条件列表检索！](https://gitee.com/troyzhxu/bean-searcher)

## 参与贡献

1. Star Fork 本仓库
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request


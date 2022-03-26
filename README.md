# JsonKit

<p>
    <a href="https://maven-badges.herokuapp.com/maven-central/com.ejlchina/jsonkit/"><img src="https://maven-badges.herokuapp.com/maven-central/com.ejlchina/jsonkit/badge.svg" alt="Maven Central"></a>
    <a href="https://gitee.com/ejlchina-zhxu/jsonkit/blob/master/LICENSE"><img src="https://img.shields.io/hexpm/l/plug.svg" alt="License"></a>
    <a href="https://github.com/ejlchina"><img src="https://img.shields.io/badge/%E4%BD%9C%E8%80%85-ejlchina-orange.svg" alt="Troy.Zhou"></a>
</p>

## 介绍

超轻量级 JSON **正序列化** 与 **反序列化** 的 **门面框架**，不依赖具体的 JSON 实现，让业务代码与 Jackson、Gson、Fastjson 等彻底 **解耦**，让你可以在需要的时候轻松切换项目底层实现！

## 安装教程

### Maven

使用 JsonKit API：

```xml
<dependency>
    <groupId>com.ejlchina</groupId>
    <artifactId>jsonkit-core</artifactId>
    <version>1.3.1</version>
</dependency>
```

使用 Jackson 底层实现：

```xml
<dependency>
    <groupId>com.ejlchina</groupId>
    <artifactId>jsonkit-jackson</artifactId>
    <version>1.3.1</version>
</dependency>
```

使用 Gson 底层实现：

```xml
<dependency>
    <groupId>com.ejlchina</groupId>
    <artifactId>jsonkit-gson</artifactId>
    <version>1.3.1</version>
</dependency>
```

使用 Fastjson 底层实现：

```xml
<dependency>
    <groupId>com.ejlchina</groupId>
    <artifactId>jsonkit-fastjson</artifactId>
    <version>1.3.1</version>
</dependency>
```

以上依赖添加一个即可。

### Gradle

```groovy
implementation 'com.ejlchina:jsonkit-core:1.3.1'
```

使用 Jackson 底层实现：

```groovy
implementation 'com.ejlchina:jsonkit-jackson:1.3.1'
```

使用 Gson 底层实现：

```groovy
implementation 'com.ejlchina:jsonkit-gson:1.3.1'
```

使用 Fastjson 底层实现：

```groovy
implementation 'com.ejlchina:jsonkit-fastjson:1.3.1'
```

以上依赖添加一个即可。

## 使用说明

### 反序列化 toMapper

```java
String json = "{\"name\":\"Jack\",\"age\":20}";
// 转换为具有映射结构的 Mapper 对象
Mapper mapper = JSONKit.toMapper(json);

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
Array array = JSONKit.toArray(json);

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
User user = JSONKit.toBean(User.class, json);

String name = user.getName();           // Jack
int name = user.getAge();               // 20
```

### 反序列化 toList

```java
String json = "[{\"name\":\"Jack\",\"age\":20}, {\"name\":\"Tom\",\"age\":21}]";
// 根据类型 转换为 Java List
List<User> list = JSONKit.toList(User.class, json);

int size = list.size();                 // 2
User user1 = list.get(0);               // {"name":"Jack","age":20}
User user2 = list.get(1);               // {"name":"Tom","age":21}
```

### 正序列化 toJson

```java
User user = new User();
user.setName("Jack");
user.setAge(20);

String json = JSONKit.toJson(user);     // 转换为 JSON 字符串

System.out.println(json);               // 输出 {"age":20,"name":"Jack"}
```

### 配置 JSONKit

如果已经添加了如 `jsonkit-jackson` 的适配包，默认不用任何配置即可正常使用。

但如果需要特殊配置，例如使用 Jackson 时，可在如下操作：

```java
ObjectMapper objectMapper = new ObjectMapper();

// 对 ObjectMapper 进行配置...
    
// 对 JSONKit 进行初始化
JSONKit.init(new JacksonDataConvertor(ObjectMapper));
```

使用其它扩展包也类似操作。

## 友情链接

[**[ OkHttps ]** 轻量却强大的 HTTP 客户端，前后端通用，支持 WebSocket 与 Stomp 协议](https://gitee.com/ejlchina-zhxu/okhttps)

[**[ Bean Searcher ]** 轻量级数据库条件检索引擎，一行代码实现复杂条件列表检索！](https://gitee.com/ejlchina-zhxu/bean-searcher)

## 参与贡献

1. Star Fork 本仓库
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request


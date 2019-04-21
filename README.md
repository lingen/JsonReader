# JsonReader

JsonReader是为简化对 app_config.json 配置读取提供的一个库；

### 6.1 依赖引入

下载jar 

<https://share.weiyun.com/59x2q8V>



**引入方式**

将json_reader-1.0-SNAPSHOT.jar放入到libs目录下

> 配置 app下的build.gradle



在dependencies中加入依赖

```
implementation fileTree(dir: 'libs', include: ['*.jar'])
implementation 'com.google.code.gson:gson:2.8.5'
```



### 6.2 使用规范

> 导入JsonReader类

```java
import com.lingenliu.util.JsonReader;
```

> 获取默认实例

```java
//此实例将读取assets目录下的app_config.json文件
JsonReader instance = JsonReader.sharedInstance();
```

> 读取配置值

```java
//读取单值
String value = JsonReader.sharedInstance().stringForKey("value");

//读取多层级的值 多级示例：{"value":{"type":"TYPE_A","name":"张三"}}
String type = JsonReader.sharedInstance().stringForKeys("value","type"); //值为TYPE_A
```

### 6.3 API一览

```java
 /**
  * 获取一个json中的 KEY 的值，指定返回值为Object类型
  * */
public Object objectForKey(String key);
/**
  * 获取一个json中的 KEY 的值，指定返回值为string类型
  * */
public String stringForKey(String key);

 /**
  * 获取一个json中的 KEY 的值，指定返回值为Bool类型
  * */
public boolean boolForKey(String key);

 /**
  * 获取一个json中的 KEY 的值，指定返回值为int类型
  * */
public int intForKey(String key);

 /**
  * 获取一个json中的 KEY 的值，指定返回值为float类型
  * */
public float floatForKey(String key);

 /**
  * 获取一个json中的 KEY 的值，指定返回值为long类型
  * */
public long longForKey(String key);

 /**
  * 获取一个json中的 KEY 的值，指定返回值为Map
  * */
public Map<String,Object> mapForKey(String key);

 /**
  * 获取一个json中的 多级 KEY 的值，指定返回值为Object类型
  * */
 public Object objectForKeys(String... keys);

 /**
  * 获取一个json中的 多级 KEY 的值，指定返回值为String类型
  * */
public String stringForKeys(String... keys);

 /**
  * 获取一个json中的 多级 KEY 的值，指定返回值为Bool类型
  * */
public boolean boolForKeys(String... keys);

 /**
  * 获取一个json中的 多级 KEY 的值，指定返回值为int类型
  * */
public int intForKeys(String... keys);

 /**
  * 获取一个json中的 多级 KEY 的值，指定返回值为float类型
  * */
public float floatForKeys(String... keys);

 /**
  * 获取一个json中的 多级 KEY 的值，指定返回值为long类型
  * */
public long longForKeys(String... keys);

 /**
  * 获取一个json中的 多级 KEY 的值，指定返回值为map类型
  * */
public Map<String,Object> mapForKeys(String... keys);
```
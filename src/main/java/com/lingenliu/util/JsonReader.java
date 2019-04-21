package com.lingenliu.util;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Map;

public class JsonReader {

    private Map<String,Object> values;

    private static JsonReader jsonReader;

    public static JsonReader sharedInstance(){
        jsonReader = new JsonReader();
        jsonReader.initData();
        return jsonReader;
    }

    private void initData(){

        String jsonValue = this.readData();

        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        Map<String, Object> values = new Gson().fromJson(jsonValue, type);

        this.values = values;

    }


    private  String readData() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(JsonReader.class.getResourceAsStream("/assets/app_config.json")));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    //###################### 公开的方法
    /**
     * 获取一个json中的 KEY 的值，指定返回值为Object类型
     * */
    public Object objectForKey(String key){
        return this.values.get(key);
    }

    /**
     * 获取一个json中的 KEY 的值，指定返回值为string类型
     * */
    public String stringForKey(String key){
        return this.values.get(key).toString();
    }

    /**
     * 获取一个json中的 KEY 的值，指定返回值为float类型
     * */
    public boolean boolForKey(String key){
        return Boolean.valueOf(this.values.get(key).toString());
    }

    /**
     * 获取一个json中的 KEY 的值，指定返回值为int类型
     * */
    public int intForKey(String key){
        return Integer.parseInt(this.values.get(key).toString());
    }

    /**
     * 获取一个json中的 KEY 的值，指定返回值为float类型
     * */
    public float floatForKey(String key){
        return Float.parseFloat(this.values.get(key).toString());
    }

    /**
     * 获取一个json中的 KEY 的值，指定返回值为long类型
     * */
    public long longForKey(String key){
        return Long.parseLong(this.values.get(key).toString());
    }

    /**
     * 获取一个json中的 KEY 的值，指定返回值为Map
     * */
    public Map<String,Object> mapForKey(String key){
        Object object = this.values.get(key);
        if (object instanceof Map){
            return (Map)object;
        }
        return null;
    }


    /**
     * 获取一个json中的 多级 KEY 的值，指定返回值为Object类型
     * */
    public Object objectForKeys(String... keys){
        if (keys.length == 0){
            return null;
        }
        Object value = this.values.get(keys[0]);

        for (int i = 1;i < keys.length;i++){
            String key = keys[i];
            if (value instanceof Map){
                Map mapValues = (Map)value;
                value = mapValues.get(key);
            }
            else{
                return null;
            }
        }
        return value;
    }

    /**
     * 获取一个json中的 多级 KEY 的值，指定返回值为String类型
     * */
    public String stringForKeys(String... keys){
        Object value = this.objectForKeys(keys);
        return value.toString();
    }

    /**
     * 获取一个json中的 多级 KEY 的值，指定返回值为Bool类型
     * */
    public boolean boolForKeys(String... keys){
        String value = this.stringForKeys(keys);
        return Boolean.valueOf(value);
    }

    /**
     * 获取一个json中的 多级 KEY 的值，指定返回值为int类型
     * */
    public int intForKeys(String... keys){
        String value = this.stringForKeys(keys);
        return Integer.valueOf(value);    }

    /**
     * 获取一个json中的 多级 KEY 的值，指定返回值为float类型
     * */
    public float floatForKeys(String... keys){
        String value = this.stringForKeys(keys);
        return Float.valueOf(value);
    }

    /**
     * 获取一个json中的 多级 KEY 的值，指定返回值为long类型
     * */
    public long longForKeys(String... keys){
        String value = this.stringForKeys(keys);
        return Long.valueOf(value);
    }


    /**
     * 获取一个json中的 多级 KEY 的值，指定返回值为map类型
     * */
    public Map<String,Object> mapForKeys(String... keys){
        Object value = this.objectForKeys(keys);
        if (value instanceof  Map){
            return (Map)values;
        }
        return null;
    }

}

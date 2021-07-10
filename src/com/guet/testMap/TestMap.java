package com.guet.testMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Conway
 * @date 2021/3/25 22:05
 */
public class TestMap {
    public static void main(String[] args) {
            Map<String, String> map1 = new HashMap<String, String>();
            map1.put("one", "一");
            map1.put("two", "二");
            map1.put("three", "三");
            Map<String, String> map2 = new HashMap<String, String>();
            map1.put("one", "十");
            map1.put("two", "九");
            map1.put("eight", "八");
            Map<String, String> combineResultMap = new HashMap<String, String>();
            combineResultMap.putAll(map1);
            combineResultMap.putAll(map2);
            for (Map.Entry<String, String> entry : combineResultMap.entrySet()) {
               System.out.println(entry.getKey() + ":" + entry.getValue());
            }
    }
}

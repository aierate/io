package com.guet.test;

import java.util.*;

/**
 * @author Conway
 * @date 2021/5/10 17:12
 */
public class RemoveDuplicateMap {
    public static void main(String[] args) {
        Map<Integer,List<Integer>> map = new HashMap<Integer, List<Integer>>();
        Map<Integer,List<Integer>> map1 = new HashMap<Integer, List<Integer>>();
        List<Integer> v = new ArrayList<>();
        List<Integer> v1 = new ArrayList<>();
        List<Integer> v2 = new ArrayList<>();
        List<Integer> v3 = new ArrayList<>();
        List<Integer> v4 = new ArrayList<>();
        List<Integer> v5 = new ArrayList<>();
        List<Integer> v6 = new ArrayList<>();
        v.add(123);
        v.add(157);
        v1.add(123);
        v1.add(158);
        v2.add(157);
        v2.add(166);
        v3.add(123);
        v3.add(157);
        v5.add(888);
        v5.add(999);
        v6.add(999);
        v6.add(1000);
        map.put(1, v);
        map.put(2, v1);
        map.put(3, v3);
        map.put(4, v2);
        map.put(5, v4);
        map.put(6, v5);
        map.put(7, v6);
        System.out.println("合并前"+map.toString());

        int i = 1;
        Set<Integer> maps = map.keySet();
        for(int  key : maps){
            if(map.get(key).isEmpty()) continue;
            for(int  key1 : maps){
                if (map.get(key1).isEmpty() || key >= key1) continue;
                if(!Collections.disjoint(map.get(key),map.get(key1))){
                    //List<Integer> li = map.get(key);
                    map.get(key).removeAll(map.get(key1));
                    map.get(key).addAll(map.get(key1));
                    //map.entrySet().remove(key1.getKey());
                    map.get(key1).clear();
                }
            }
            map1.put(i, map.get(key));
            ++i;
        }
        System.out.println("合并后"+map1.toString());
    }
}

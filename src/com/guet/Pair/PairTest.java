package com.guet.Pair;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Conway
 * @date 2021/3/16 16:09
 */
public class PairTest {
    public static void main(String[] args) {
        List<Pair<List<Integer>, Integer>> R = new ArrayList<>();
        List<Pair<List<Integer>, Integer>> R2 = new ArrayList<>();

        List<Integer> s = new ArrayList<>();
        List<Integer> s2 = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            s.add(i);
        }

        for (int i = 2; i < 20; i++){
            s2.add(i);
        }
        System.out.println(s.removeAll(s2));
        System.out.println(s);
        System.out.println(s2);
//
//        Pair<List<Integer>, Integer> T = new Pair<>(s,1);
//        Pair<List<Integer>, Integer> T1 = new Pair<>(s2,1);
//        Pair<List<Integer>, Integer> T2 = new Pair<>(s2,1);
//
//        R.add(T);
//        R2.add(T1);
//        R2.add(T2);
/*
        R = R2;

        //System.out.println(R);

        for (Pair<List<Integer>, Integer> r : R) {

            List key1 = new ArrayList();
            key1.addAll(r.getKey());
            int value = r.getValue();
            ++value;
            key1.retainAll(s);

        }*/
        //System.out.println(R);
        /*int num = 10;
        lable:
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < num; j++ ){


                if (num > 5){
                    continue lable;
                }
            }
            --num;
            System.out.println(i);
        }*/

    }
}

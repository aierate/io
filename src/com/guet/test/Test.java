package com.guet.test;

import java.text.DecimalFormat;

/**
 * @author Conway
 * @date 2021/3/16 9:51
 */
public class Test {
    public static void main(String[] args) {
        double a = 30.684821000000003;
        double b = 30.636166999999997;
        DecimalFormat df2 =new DecimalFormat("#.000000");
        String str1 = df2.format(a);
        String str2 = df2.format(b);

        System.out.println(str1);
        System.out.println(str2);
    }


}

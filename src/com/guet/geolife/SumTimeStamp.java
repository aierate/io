package com.guet.geolife;

import java.io.*;

/**
 * @author Conway
 * @date 2021/3/15 9:48
 * 统计最某个时间戳最多的用户数量
 */

public class SumTimeStamp {
    public static void main(String[] args) {
        String readFile = "I:\\KangweiData\\Geolife Trajectories 1.3\\geolife_angle_sorted_clear_area2.txt";
        String wirteFile = "H:\\comin_dataset\\out3.txt";

        writeFileOnLine(readFile, wirteFile);
    }

    //读取文件
    public static void writeFileOnLine(String readFileName, String writeFileName) {
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        FileInputStream fis = null;

        InputStreamReader isr = null;

        BufferedWriter bw = null;
        BufferedReader br = null;


        try {
            File file = new File(writeFileName);
            fos = new FileOutputStream(file);
            osw = new OutputStreamWriter(fos, "UTF-8");
            bw = new BufferedWriter(osw);

            File f = new File(readFileName);
            fis = new FileInputStream(f);

            isr = new InputStreamReader(fis, "UTF-8");

            br = new BufferedReader(isr);

            String line = null;

            //slideWindow with two class elements
            //init first class elements

            //处理细节
            //最小经度，最小纬度，最大经度，最大纬度
            int max = 0;
            int sum = 0;
            String compare = "sm";

            while ((line = br.readLine()) != null) {
                String[] dataStream = line.toString().split("\t");
                if (!" ".contains(line)) {
                    if(compare == "sm"){
                        compare = dataStream[3].trim();
                    }
                    if(compare.equals(dataStream[3].trim())){
                        ++sum;
                    }else{
                        compare = dataStream[3].trim();
                        max = Math.max(max, sum);
                        sum = 0;
                    }
                }
            }
            System.out.println(max);
        } catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if (null != br) {
                    br.close();
                }

                if (null != bw) {
                    bw.close();
                }
                if (null != fos) {
                    fos.close();
                }
                if (null != osw) {
                    osw.close();
                }
                if (null != isr) {
                    isr.close();
                }
                if (null != fis) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}


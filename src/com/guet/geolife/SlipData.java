package com.guet.geolife;

import java.io.*;

/**
 * @author Conway
 * @date 2021/7/8 9:47
 * 分割geolife数据，并改变时间戳。
 */
public class SlipData {
    public static void main(String[] args) {
        String readFile = "I:\\KangweiData\\Geolife Trajectories 1.3\\geolife.txt";
        String wirteFile = "H:\\comin_dataset\\geolife_slip1.txt";

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


            int timeStamp = 0;
            String compare = "0";
            long i = 3766038;
            while ((--i) >= 0) {
                line = br.readLine();
                String[] dataStream = line.toString().split("\t");
                if (!" ".contains(line)) {

                    if(compare.equals(dataStream[0].trim())){
                        bw.write(dataStream[0] +"\t" + dataStream[1] +"\t" + dataStream[2] +"\t"+ timeStamp + "\n");
                        System.out.println(dataStream[0] +"\t" + dataStream[1] +"\t" + dataStream[2] +"\t"+ timeStamp);
                        ++timeStamp;
                    }else{
                        compare = dataStream[0].trim();
                        timeStamp = 0;
                        bw.write(dataStream[0] +"\t" + dataStream[1] +"\t" + dataStream[2] +"\t"+ timeStamp + "\n");
                        System.out.println(dataStream[0] +"\t" + dataStream[1] +"\t" + dataStream[2] +"\t"+ timeStamp);
                        ++timeStamp;
                    }
                }
            }

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

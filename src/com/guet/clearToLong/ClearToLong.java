package com.guet.clearToLong;

import java.io.*;
import java.text.DecimalFormat;

/*
 * @author Conway
 * @date 2021/3/16 9:41
 */


public class ClearToLong {
    public static void main(String[] args) {
        String readFile = "I:\\KangweiData\\Geolife Trajectories 1.3\\geolife_angle_sorted.txt";
        String wirteFile = "I:\\KangweiData\\Geolife Trajectories 1.3\\geolife_angle_sorted_clear.txt";

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


            DecimalFormat df2 =new DecimalFormat("#.000000");

            while ((line = br.readLine()) != null) {
                String[] dataStream = line.toString().split("\t");
                if (!" ".contains(line)) {
                    if(dataStream[1].length() > 9){

                        double strToDou = Double.valueOf(dataStream[1]);
                        dataStream[1] = df2.format(strToDou);

                    }
                    if (dataStream[2].length() > 9){
                        double strToDou = Double.valueOf(dataStream[2]);
                        dataStream[2] = df2.format(strToDou);
                    }
                }
                System.out.println( dataStream[0] + " " + dataStream[1] + " " + dataStream[2] + " " + dataStream[3] + " " + dataStream[4] );

                bw.write(dataStream[0] + " " + dataStream[1] + " " + dataStream[2] + " " + dataStream[3] + " " + dataStream[4] +  "\n");
            }
            //System.out.println( + " " + max[1] + " " + max[2] + " " + max[3]);


            //bw.write(inputs[0] + "," + inputs[1] + "," + inputs[2] + "," + inputs[3] + "," + inputs[4] + "," + inputs[5] + "\n");



            //bw.write((max[0]+ "," + max[1]+ "," + max[2]+ "," +max[3]));
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


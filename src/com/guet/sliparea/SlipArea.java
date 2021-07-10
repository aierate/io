package com.guet.sliparea;

import com.guet.model.Point;

import java.io.*;
import java.lang.reflect.Array;

/**
 * @author Conway
 * @date 2021/3/15 9:48
 */

public class SlipArea {
    public static void main(String[] args) {
        String readFile = "H:\\out1.txt";
        String wirteFile = "H:\\out2.txt";

        writeFileOnLine(readFile, wirteFile);
    }

    //读取文件
    public static void writeFileOnLine(String readFileName, String writeFileName) {
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        FileInputStream fis = null;
        FileInputStream fis2 = null;
        InputStreamReader isr = null;
        InputStreamReader isr2 = null;
        BufferedWriter bw = null;
        BufferedReader br = null;
        BufferedReader br2 = null;

        try {
            File file = new File(writeFileName);
            fos = new FileOutputStream(file);
            osw = new OutputStreamWriter(fos, "UTF-8");
            bw = new BufferedWriter(osw);

            File f = new File(readFileName);
            fis = new FileInputStream(f);
            fis2 = new FileInputStream(f);
            isr = new InputStreamReader(fis, "UTF-8");
            isr2 = new InputStreamReader(fis2, "UTF-8");
            br = new BufferedReader(isr);
            br2 = new BufferedReader(isr2);
            String line = null;
            String line2 = null;
            //slideWindow with two class elements
            //init first class elements

            //处理细节
            //最小经度，最小纬度，最大经度，最大纬度
            double[] max = new double[]{9999.00, 9999.00, 0.00, 0.00};
            while ((line = br.readLine()) != null) {
                String[] dataStream = line.toString().split(" ");
                if (!" ".contains(line)) {

                    max[0] = Math.min(new Double(dataStream[1].trim()), max[0]);
                    max[1] = Math.min(new Double(dataStream[2].trim()), max[1]);
                    max[2] = Math.max(new Double(dataStream[1].trim()), max[2]);
                    max[3] = Math.max(new Double(dataStream[2].trim()), max[3]);
                }
            }
            System.out.println(max[0] + " " + max[1] + " " + max[2] + " " + max[3]);

            //分割的数量
            int slipLotNumber = 8;
            int slipLatNumber = 8;
            //经度网格边长
            double lotLength = (max[2] - max[0])/slipLotNumber;
            //纬度的网格边长
            double latLengeh = (max[3] - max[1])/slipLatNumber;


            while ((line2 = br2.readLine()) != null) {
                String[] inputs = new String[6];
                String[] dataStream = line2.toString().split(" ");

                if (!" ".contains(line2)) {
//                    int i = (int)(Math.random() * 360);
                    int areaId =  ((int)((new Double(dataStream[1].trim()) - max[0])/lotLength) + 1
                           + (int)((new Double(dataStream[2].trim()) - max[1])/latLengeh) * slipLatNumber);
                    inputs[0] = dataStream[0];
                    inputs[1] = dataStream[1];
                    inputs[2] = dataStream[2];
                    inputs[3] = dataStream[3];
                    inputs[4] = dataStream[4];
                    inputs[5] = String.valueOf(areaId);

                    //System.out.println(1);
                }
                bw.write(inputs[0] +" " + inputs[1] +" " + inputs[2] +" "+ inputs[3] +" "+ inputs[4] +" "+ inputs[5] + "\n");
            }

                //bw.write((max[0]+ "," + max[1]+ "," + max[2]+ "," +max[3]));
            } catch(Exception e){
                e.printStackTrace();
            }finally{
                try {
                    if (null != br) {
                        br.close();
                    }
                    if (null != br2){
                        br2.close();
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


package com.guet.slipAreaforLat;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Conway
 * @date 2021/5/6 16:00
 * 对数据按照纬度排序，分区数据，保证每个分区中数据量相同
 */
public class SlipAreaforLatSort {
    public static void main(String[] args) {
        String readFile = "H:/comin_dataset/geolife_slip2.txt";
        String wirteFile = "H:/comin_dataset/geolife_slip3.txt";

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
            double lotmin = Double.MAX_VALUE;
            double lotmax = Double.MIN_VALUE;
            List<Double> latArr = new ArrayList<>();


            while ((line = br.readLine()) != null) {
                String[] dataStream = line.toString().split("\t");
                if (!" ".contains(line)) {
                    latArr.add(new Double(dataStream[1].trim()));
                }
            }


            Collections.sort(latArr);
            int latSize = latArr.size();
            System.out.println(latSize);

            //分割的数量
            int slipLotNumber = 5;

            //经度网格边长
            int lotLength = latSize/slipLotNumber;

            //分割的边界
            double lat0 = latArr.get(0);
            double lat1 = latArr.get(lotLength);
            double lat2 = latArr.get(lotLength * 2);
            double lat3 = latArr.get(lotLength * 3);
            double lat4 = latArr.get(lotLength * 4);
            double lat5 = latArr.get(latArr.size() - 1);

           /* for (Double a: latArr) {
                bw.write(a +  "\n");
            }*/

            System.out.println(lat0 + " " + lat1  +  " " + lat2 + " " + lat3 + " " + lat4 + " " + lat5);
            //判断数据在哪个分区里面
            while ((line2 = br2.readLine()) != null) {
                String[] inputs = new String[6];
                String[] dataStream = line2.toString().split("\t");

                if (!" ".contains(line2)) {

                    int areaId = 0;
                    Double lats = new Double(dataStream[1].trim());
                    if(lats > lat0 && lats < lat1){
                        areaId = 1;
                    }else if(lats > lat1 && lats < lat2){
                        areaId = 2;
                    }else if(lats > lat2 && lats < lat3){
                        areaId = 3;
                    }else if(lats > lat3 && lats < lat4){
                        areaId = 4;
                    }else if(lats > lat4 && lats < lat5){
                        areaId = 5;
                    }


                    inputs[0] = dataStream[0];
                    inputs[1] = dataStream[1];
                    inputs[2] = dataStream[2];
                    inputs[3] = dataStream[3];
                    inputs[4] = dataStream[4];
                    inputs[5] = String.valueOf(areaId);

                }
                System.out.println(inputs.toString());
                bw.write(inputs[0] +"\t" + inputs[1] +"\t" + inputs[2] +"\t"+ inputs[3] +"\t"+ inputs[4] +"\t"+ inputs[5] + "\n");
            }


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

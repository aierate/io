package com.guet.slipAreaforLat;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Conway
 * @date 2021/3/15 9:48
 * 得到交叉区域，并编号
 */

public class SlipAreaforLatExchage {
    public static void main(String[] args) {
        String readFile = "H:\\comin_dataset\\out3.txt";
        String wirteFile = "H:\\comin_dataset\\out4.txt";

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
            double lotmin = 9999.000000;
            double lotmax = 0.000000;

            while ((line = br.readLine()) != null) {
                String[] dataStream = line.toString().split(" ");
                if (!" ".contains(line)) {

                    lotmin  = Math.min(new Double(dataStream[1].trim()), lotmin);

                    lotmax = Math.max(new Double(dataStream[1].trim()), lotmax);
                }
            }
            System.out.println(lotmax + " " + lotmin);

            //分割的数量
            int slipLotNumber = 20;

            double[] marge = new double[22];

            //经度网格边长
            double lotLength = (lotmax - lotmin)/slipLotNumber;
            //存储边界点
            marge[0] = lotmin;
            for (int i = 1; i < marge.length; i++){
                marge[i] = marge[i-1] + lotLength;
            }

            double x = 0.003;
            while ((line2 = br2.readLine()) != null) {
                System.out.println(line2);
                String[] inputs = new String[7];
                String[] dataStream = line2.toString().split(" ");
                int area2 = 0;
                if (!" ".contains(line2)) {

                    double lat = Double.parseDouble(dataStream[1].trim());
                    int area1 = Integer.parseInt(dataStream[5].trim());

                    //判断边界区域点
                    if(lat > marge[area1] - 0.003){
                        area2 = area1 + 1;
                    }else if (lat < marge[area1 - 1] + 0.003){
                        area2 = area1 - 1;
                    }else {
                        area2 = area1;
                    }

                    inputs[0] = dataStream[0];
                    inputs[1] = dataStream[1];
                    inputs[2] = dataStream[2];
                    inputs[3] = dataStream[3];
                    inputs[4] = dataStream[4];
                    inputs[5] = dataStream[5];
                    inputs[6] = String.valueOf(area2);

                }
                //System.out.println(Arrays.toString(inputs));
                bw.write(inputs[0] +" " + inputs[1] +" " + inputs[2] +" "+ inputs[3] +" "+ inputs[4] +" "+ inputs[5] + " " + inputs[6] + "\n");
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


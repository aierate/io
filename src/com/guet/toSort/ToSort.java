package com.guet.toSort;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Conway
 * @date 2021/7/3 11:35
 */
public class ToSort {
    public static void main(String[] args) {

//        String readFile = "I:/KangweiData/Geolife Trajectories 1.3/geolife_angle.txt";
//        String wirteFile = "I:/KangweiData/Geolife Trajectories 1.3/geolife_angle_sort.txt";
        String readFile = "H:/comin_dataset/geolife_slip3.txt";
        String wirteFile = "H:/comin_dataset/geolife_slip4.txt";
        writeFileOnLine(readFile, wirteFile);
    }


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

            //文件输入流，从硬盘读取
            fis = new FileInputStream(f);

            isr = new InputStreamReader(fis, "UTF-8");

            br = new BufferedReader(isr);

            String line = null;

            List<Trajactory> sortList = new ArrayList<>();
            //读和
            while ((line = br.readLine()) != null) {

                String[] dataStream = line.toString().split("\t");
                if (!" ".contains(line)) {
                    sortList.add(new Trajactory(dataStream[0],dataStream[1],dataStream[2],Integer.parseInt(dataStream[3].trim()),dataStream[4],Integer.parseInt(dataStream[5].trim())));
                }
//                bw.write(inputs[0] +" " + inputs[1] +" " + inputs[2] +" "+ inputs[3] + "\r\n");
            }
            Collections.sort(sortList);

            for (Trajactory tr: sortList) {
                bw.write(tr.toString() + "\n");
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


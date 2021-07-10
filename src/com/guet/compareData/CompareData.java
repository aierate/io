package com.guet.compareData;

import java.io.*;

/**
 * @author Conway
 * @date 2021/5/11 15:29
 * 字符流读取和写出到文件
 */

public class CompareData {
    public static void main(String[] args) {
        //自己修改路径。先后将20140808-20140812的数据合成到comparedata.txt
        String readFile = "I:\\KangweiData\\chengdu_taxi_processed_data\\20140812.txt";
        String wirteFile = "I:\\KangweiData\\chengdu_taxi_processed_data\\compareData\\comparedata.txt";
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
            //文件输出流，以追加的方式写入文件。
            fos = new FileOutputStream(file,true);

            osw = new OutputStreamWriter(fos, "UTF-8");

            bw = new BufferedWriter(osw);

            File f = new File(readFileName);

            //文件输入流，从硬盘读取
            fis = new FileInputStream(f);

            isr = new InputStreamReader(fis, "UTF-8");

            br = new BufferedReader(isr);

            String line = null;

            //读和写文件
            while ((line = br.readLine()) != null) {
                String[] inputs = new String[4];
                String[] dataStream = line.toString().split("\t");
                if (!" ".contains(line)) {
                    //将时间戳减去与1的差值。变为从1开始。
                    int areaId =  (new Integer(dataStream[3]) - 17281);

                    inputs[0] = dataStream[0];
                    inputs[1] = dataStream[1];
                    inputs[2] = dataStream[2];
                    inputs[3] = String.valueOf(areaId);
                }
                System.out.println(inputs[0] +" " + inputs[1] +" " + inputs[2] +" "+ inputs[3]);
                bw.write(inputs[0] +" " + inputs[1] +" " + inputs[2] +" "+ inputs[3] + "\r\n");
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

package com.io.www;

import java.io.*;

public class IoFile {
    public static void main(String[] args) {
        readFile("I:/KangweiData/chengdu_taxi_processed_data/compareData/comparedata.txt", " ");
    }

    //写出到文件
    public static void writeFile(String str, String writepath) {
        File file = new File(writepath);
        FileOutputStream fo = null;
        OutputStreamWriter os = null;
        BufferedWriter bw = null;

        try {
            fo = new FileOutputStream(file,true);
            os = new OutputStreamWriter(fo);
            bw = new BufferedWriter(os);
            bw.write(str + "\t\n");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                    if (null != bw){
                            bw.close();
                        }
                    if (null != os){
                        os.close();
                    }
                    if (null != fo) {
                        fo.close();
                    }
                }catch (IOException e) {
                e.printStackTrace();

                }
        }
    }

    //读取文件并打印
    public static void readFile(String readpath, String slips) {
        File file = new File(readpath);
        String str = null;

        FileInputStream iof = null;
        InputStreamReader ios = null;
        BufferedReader iob = null;
        try {
            iof = new FileInputStream(file);
            ios = new InputStreamReader(iof, "UTF-8");
            iob = new BufferedReader((ios));
            while ((str = iob.readLine()) != null) {

                String[] lines = str.split(slips);

                    System.out.println(lines[0] + "," + lines[1] + "," + lines[2] + "," + lines[3]);
                    writeFile(lines[0] + "," + lines[1] + "," + lines[2] + "," + lines[3] +"\r\n","I:/KangweiData/chengdu_taxi_processed_data/compareData/comparedata2.txt");

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != iob) {
                    iob.close();
                }
                if (null != ios) {
                    ios.close();
                }
                if (null != iof) {
                    iof.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

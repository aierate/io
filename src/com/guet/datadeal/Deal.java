package com.guet.datadeal;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.guet.model.Point;
//3 4 5 6 8 9 10 11 12 14 15 16 18 19 20 21 22 23
public class Deal {
    public static void main(String[] args) {
        String readFile = "/Volumes/TOSHIBA EXT/dataDeal/20140803.txt";
        String wirteFile = "/Volumes/TOSHIBA EXT/dealdata/20140803.txt";
        writeFileOnLine(readFile,wirteFile);
//        List<File> files = getFiles("/Volumes/TOSHIBA EXT/dealdata/");
//        for (File f:files){
//            String readFile = f.getName();
//            String wirteFile = f.getName();
//            writeFileOnLine(readFile,wirteFile);
//        }


    }
    //have not used
    public  static List<File> getFiles(String path){
        File root =  new  File(path);
        List<File> files =  new ArrayList<File>();
        if (!root.isDirectory()){
            files.add(root);
        } else {
            File[] subFiles = root.listFiles();
            for (File f : subFiles){
                files.addAll(getFiles(f.getAbsolutePath()));
            }
        }
        return  files;
    }

    public static void getAngle(Point A,Point B){

            int angle;
            double Y_dis=B.y-A.y;
            double X_dis=B.x - A.x;
            //if not move
            if (Y_dis==0&&X_dis==0) A.setAngle(0);
            else {
                //按顺时针进行判定
                angle = (int) (Math.atan(Math.abs(X_dis / Y_dis)) * 180. / Math.PI);
                //第二象限
                if (Y_dis > 0 && X_dis <= 0) A.setAngle((90-angle) + 270);
                //第三象限
                else if (Y_dis <= 0 && X_dis < 0) A.setAngle(angle + 180);
                //第四象限
                else if (Y_dis < 0 && X_dis >= 0) A.setAngle((90-angle) + 90);
                else A.setAngle(angle);
            }

            /*
            *
            * if(dLo>0&&dLa<=0){
            angle=(90.-angle)+90;
        }
        else if(dLo<=0&&dLa<0){
            angle=angle+180.;
        }else if(dLo<0&&dLa>=0){
            angle= (90.-angle)+270;
        }
            * */

    }
    public static void writeFileOnLine(String readFileName,String writeFileName){
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedWriter bw = null;
        BufferedReader br = null;
        Point[] SlidePointWindow = new Point[2];
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
            SlidePointWindow[0] = new Point(-1,-1.0,-1.0,-1);

            while ((line = br.readLine()) != null){
                String[] dataStream = line.toString().split("\t");
                if (!" ".contains(line)){
                    SlidePointWindow[1] = new Point(Integer.parseInt(dataStream[0]),Double.parseDouble(dataStream[1]),Double.parseDouble(dataStream[2]),Integer.parseInt(dataStream[3]));
                   if (SlidePointWindow[0].getId()==SlidePointWindow[1].getId()) {//the same id
                       //judge whether continue
                       if (Math.abs(SlidePointWindow[0].getTimestamps()-SlidePointWindow[1].getTimestamps())==1){
                           getAngle(SlidePointWindow[0],SlidePointWindow[1]);

                       }else SlidePointWindow[0].setAngle(-1);
                       bw.write(SlidePointWindow[0].getId()+"\t"+SlidePointWindow[0].getX()+"\t"+SlidePointWindow[0].getY()+"\t"+SlidePointWindow[0].getTimestamps()+"\t"+SlidePointWindow[0].getAngle()+"\t\n");
                       SlidePointWindow[0]=SlidePointWindow[1];
                   }else {// if not same , then replace delete the former point
                       SlidePointWindow[0]=SlidePointWindow[1];
                       SlidePointWindow[0].setAngle(-1);
                   }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (null != br){
                    br.close();
                }
                if (null != bw){
                    bw.close();
                }
                if (null != fos){
                    fos.close();
                }
                if (null != osw){
                    osw.close();
                }
                if (null != isr){
                    isr.close();
                }
                if (null != fis){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

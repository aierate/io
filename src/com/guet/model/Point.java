package com.guet.model;

public class Point {
        int id;
        public double x;
        public double y;
        int timestamps;
        int angle=-1;

        public Point() {
        }

        public int getId() {
                return id;
        }

        public double getX() {
                return x;
        }

        public double getY() {
                return y;
        }

        public int getTimestamps() {
                return timestamps;
        }

        public int getAngle() {
                return angle;
        }

        public Point(int id, double x, double y, int timestamps) {
                this.id = id;
                this.x = x;
                this.y = y;
                this.timestamps = timestamps;
        }
        public void setAngle(int angle) {
                this.angle = angle;
        }

        public void setId(int id) {
                this.id = id;
        }

        public void setX(double x) {
                this.x = x;
        }

        public void setTimestamps(int timestamps) {
                this.timestamps = timestamps;
        }

        public void setY(double y) {
                this.y = y;
        }

        /**
         * 求A点与下一点与正北方向的夹角
         * @param A 前一时间戳的点
         * @param B 后一时间戳的点
         * @return  AB连线与正北方向的夹角（0~360）
         */
//        public void getAngle(Point A,Point B){
//                //保证timestamp是连续的
//                if (Math.abs(A.timestamps-B.timestamps)==1){
//                        //计算两点之间的距离
//                        //double distance=Math.sqrt((A.x-B.x)*(A.x-B.x)+(A.y-B.y)*(A.y-B.y));
//                        double Y_dis=B.y-A.y;
//                        double X_dis=B.x - A.x;
//                        angle= (int) (Math.atan(Math.abs(X_dis/Y_dis))*180./Math.PI);
//                        if (Y_dis>0&&X_dis<0) A.setAngle(angle+90);
//                        else if (Y_dis<0&&X_dis<0) A.setAngle(angle+180);
//                        else if (Y_dis<0&&X_dis>0) A.setAngle(angle+270);
//                        else A.setAngle(angle);
//
//                }
//                else A.angle=-1;
//        }

}

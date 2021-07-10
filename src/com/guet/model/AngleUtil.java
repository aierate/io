package com.guet.model;

public class AngleUtil {

    public static void main(String[] args) {
        MyLatLng A=new MyLatLng(113.249648,23.401553);
        MyLatLng B=new MyLatLng(113.246033,23.403362);
        System.out.println(getAngle(A,B));
    }
    /**
     * 求B点经纬度
     * @param A 已知点的经纬度，
     * @param distance   AB两地的距离  单位km
     * @param angle  AB连线与正北方向的夹角（0~360）
     * @return  B点的经纬度
     */
    public static MyLatLng getMyLatLng(MyLatLng A,double distance,double angle){

        double dx = distance*1000*Math.sin(Math.toRadians(angle));
        double dy= distance*1000*Math.cos(Math.toRadians(angle));

        double bjd=(dx/A.Ed+A.m_RadLo)*180./Math.PI;
        double bwd=(dy/A.Ec+A.m_RadLa)*180./Math.PI;
        return new MyLatLng(bjd, bwd);
    }

    /**
     * 获取AB连线与正北方向的角度
     * @param A  A点的经纬度
     * @param B  B点的经纬度
     * @return  AB连线与正北方向的角度（0~360）
     */
    public  static double getAngle(MyLatLng A,MyLatLng B){
        double dx=(B.m_RadLo-A.m_RadLo)*A.Ed;
        double dy=(B.m_RadLa-A.m_RadLa)*A.Ec;
        double angle=0.0;
        angle=Math.atan(Math.abs(dx/dy))*180./Math.PI;
        double dLo=B.m_Longitude-A.m_Longitude;
        double dLa=B.m_Latitude-A.m_Latitude;
        if(dLo>0&&dLa<=0){
            angle=(90.-angle)+90;
        }
        else if(dLo<=0&&dLa<0){
            angle=angle+180.;
        }else if(dLo<0&&dLa>=0){
            angle= (90.-angle)+270;
        }
        return angle;
    }
    static class MyLatLng {
        final static double Rc=6378137;//赤道半径
        final static double Rj=6356725;//极半径
        double m_LoDeg,m_LoMin,m_LoSec;//度，分，秒
        double m_LaDeg,m_LaMin,m_LaSec;
        double m_Longitude,m_Latitude;//经纬度
        double m_RadLo,m_RadLa;
        double Ec;
        double Ed;
        public MyLatLng(double longitude,double latitude){
            m_LoDeg=(int)longitude;
            m_LoMin=(int)((longitude-m_LoDeg)*60);
            m_LoSec=(longitude-m_LoDeg-m_LoMin/60.)*3600;

            m_LaDeg=(int)latitude;
            m_LaMin=(int)((latitude-m_LaDeg)*60);
            m_LaSec=(latitude-m_LaDeg-m_LaMin/60.)*3600;

            m_Longitude=longitude;
            m_Latitude=latitude;
            m_RadLo=longitude*Math.PI/180.;
            m_RadLa=latitude*Math.PI/180.;
            Ec=Rj+(Rc-Rj)*(90.-m_Latitude)/90.;
            Ed=Ec*Math.cos(m_RadLa);
        }
    }
}


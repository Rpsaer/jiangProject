package cn.zcbigdata.mybits_demo.entity;

public class dataCheck {


    public static  int check(String x) throws Exception {
        try{
            return Integer.valueOf(x);
        }catch(Exception e){
            throw new Exception("输入id参数出错");
        }
    }
    public static  int check1(String x) throws Exception {
        try{
            return Integer.valueOf(x);
        }catch(Exception e){
            throw new Exception("输入热度参数出错");
        }
    }
}

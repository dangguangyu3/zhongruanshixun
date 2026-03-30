package com.mybook.tools.instance;

public class UserSimpleInstance {
    private static FindUserInstance myinstance=null;
    public static int getMyInstance(){
        if(myinstance==null){
            myinstance=new FindUserInstance();
        }
        //如果不为空，则证明实例化过了
        return myinstance.getUserid();
    }
    public static void setMyInstance(int id){
        if(myinstance==null){
            myinstance=new FindUserInstance();
        }
        //如果不为空，则把值赋给myinstance里面的userid
        myinstance.setUserid(id);
    }
    //这里添加如果需要得到用户表的身份identify
    public static int getIdentify(){
        if(myinstance==null){
            myinstance=new FindUserInstance();
        }
        //如果不为空，则证明实例化过了
        return myinstance.getIdentify();
    }
    //设置identify的方法
    public static void setIdentify(int identify){
        if(myinstance==null){
            myinstance=new FindUserInstance();
        }
        //如果不为空，则把值赋给myinstance里面的userid
        myinstance.setIdentify(identify);
    }

}

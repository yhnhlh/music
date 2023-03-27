package com.utils;

public  class Constants {
    //消息提示
    public static String REQUEST_MSG="msg";
    //登录状态 0- 未登录  1-已登录
    public static int isLogin = 0;

    //用户权限
    public static int isManger=0;


    //用于记录，两张个性化推荐列表，isFromA为true表示，从表A中读取数据;
    public static volatile boolean isFromA=true;
}

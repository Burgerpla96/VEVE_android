package com.kosmo.veve.http;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.util.Log;

public class UrlCollection{
   // public static String SERVER_URL = "http://192.168.43.60:8080/veve";
      //public static String SERVER_URL =  "http://192.168.0.145:8080/veve";
    //public static String SERVER_URL = "http://192.168.45.139:8080/veve";
    //public static String SERVER_URL = "http://172.20.10.11:8080/veve";
    public static String SERVER_URL = "http://192.168.0.25:8080/veve";



    public static String LOGIN = SERVER_URL+"/member/json";
    public static String UPDATE_INFO = SERVER_URL+"/member/update";

    public static String SIGNUP = SERVER_URL + "/member/signUp";
    public static String IDCHECK = SERVER_URL + "/member/idcheck";
    public static String SIGNUPKAKAO = SERVER_URL + "/member/signUpKakao";

    public static String GALLERY_POST = SERVER_URL + "/gallary/post";
    public static String GALLERY_DELETE = SERVER_URL +"/gallary/delete";
    public static String GALLERY_UPDATE = SERVER_URL +"/gallary/update";

    public static String GALLERY_LIKE = SERVER_URL +"/Gallary/heart";
    public static String GALLERY_SCRAP = SERVER_URL +"/Gallary/Scrap";

    public static String ANDROIDLIST = SERVER_URL + "/gallary/androidList";
    public static String ANDROIDLIST_FILE = SERVER_URL + "/gallary/androidListFile";

    public static String COMMENTLIST = SERVER_URL +"/gallary/comment";
    public static String COMMENT_POST = SERVER_URL +"/gallary/commentPost";

    public static String MYFEED = SERVER_URL+"/myfeed";

    public static String MYPAGE = SERVER_URL +"/mypage";
    public static String INSERTFOLLOW = SERVER_URL + "/member/follow";
    public static String FOLLOWLIST = SERVER_URL +"/mypage/followList";
    public static String FOLLOWINGLIST = SERVER_URL +"/mypage/followingList";
    public static String MYPAGELIST = SERVER_URL + "/mypage/list";
    public static String MYPAGESCRAPLIST = SERVER_URL +"/mypage/scrapList";
    public static String MYPAGENUTRIENT = SERVER_URL +"/Mypage/Nutrient";


}

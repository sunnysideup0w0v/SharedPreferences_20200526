package com.example.sharedpreferences_20200526.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class ContextUtil {
    // 메모장의 파일명에 대응되는 개념.
    private static final String prefName = "프로젝트이름Pref";

    // 항목의 이름에 오타를 내지 않기 위해 변수로 만들고 => 자동완성 활용
    private static final String USER_ID = "USER_ID";

    // 아이디를 받아서 저장해주는 메소드
    public static void setUserId(Context context, String inputId){
        // 메모장을 열어줌
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        // 메모장에 필요한 항목을 저장함
        pref.edit().putString(USER_ID, inputId).apply();
    }

    // 메모장에 기록된 아이디를 받아서 리턴해주는 메소드
    public static String getUserId(Context context){
        // 메모장을 열고
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        // 메모장에 적어둔 아이디 가져오기.
        return pref.getString(USER_ID, "");
    }
}

package com.wartono.my;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.wartono.my.Model.Login.LoginData;

import java.util.HashMap;

public class SessionManager {

    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public static final String IS_LOGGED_IN = "isLoggedIn";
    public static final String USER_ID = "id_user";
    public static final String USERNAME = "username";
    public static final String NOMER_KONTAK = "nomer_kontak";

    @SuppressLint("CommitPrefEdits")
    public SessionManager (Context context){
        this.context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(LoginData user){
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(USER_ID, user.getId_user());
        editor.putString(USERNAME, user.getUsername());
        editor.putString(NOMER_KONTAK, user.getNomer_kontak());
        editor.commit();
    }

    public HashMap<String,String> getUserDetail(){
        HashMap<String,String> user = new HashMap<>();
        user.put(USER_ID, sharedPreferences.getString(USER_ID,null));
        user.put(USERNAME, sharedPreferences.getString(USERNAME,null));
        user.put(NOMER_KONTAK, sharedPreferences.getString(NOMER_KONTAK,null));
        return user;
    }

    public void checkLogin() {
        if (!this.isLoggedIn()) {
            Intent i = new Intent(context, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }

    public void logoutSession(){
        editor.clear();
        editor.commit();
    }

    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }

    public String getUsername(){
        HashMap<String, String> user = getUserDetail();
        Log.d("XXXTAG", "getUsername " + user.get(SessionManager.USERNAME));
        return user.get(SessionManager.USERNAME);
    }


    public  void destroyCurrentUser(){
        editor.putBoolean(IS_LOGGED_IN,false);
        editor.putString(USERNAME, "");
        editor.commit();
    }

}
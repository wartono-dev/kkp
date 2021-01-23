package com.wartono.my.Model.Login;

import com.google.gson.annotations.SerializedName;

public class LoginData {
    @SerializedName("id_user")
    private String id_user;

    @SerializedName("name")
    private String name;

    @SerializedName("username")
    private String username;

    public void setId_user(String id_user){

        this.id_user = id_user;
    }

    public String setId_user(){

        return id_user;
    }

    public String getId_user() {

        return id_user;
    }

    public void setNama(String nama)
    {
        this.name = nama;
    }

    public String getNama(){
        return name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
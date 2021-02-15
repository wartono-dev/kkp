package com.wartono.my.Model.Login;

import com.google.gson.annotations.SerializedName;

public class LoginData {
    @SerializedName("id_user")
    private String id_user;

    @SerializedName("username")
    private String username;

    @SerializedName("nomer_kontak")
    private String nomer_kontak;

    public void setId_user(String id_user){

        this.id_user = id_user;
    }

    public String setId_user(){

        return id_user;
    }

    public String getId_user() {

        return id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNomer_kontak() { return nomer_kontak;
    }
}
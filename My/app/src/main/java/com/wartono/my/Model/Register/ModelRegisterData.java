package com.wartono.my.Model.Register;

import com.google.gson.annotations.SerializedName;

public class ModelRegisterData {
	@SerializedName("id_user")
	private String id_user;

	@SerializedName("nomer_kontak")
	private String nomer_kontak;

	@SerializedName("username")
	private String username;

	public String getId_user() {

		return id_user;
	}

	public void setId_user(String id_user) {

		this.id_user = id_user;
	}

	public void setName(String name)
	{
		this.nomer_kontak = nomer_kontak;
	}

	public String getName()
	{
		return nomer_kontak;
	}

	public void setUsername(String username){

		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}
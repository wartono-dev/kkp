package com.wartono.my.Model.Register;

import com.google.gson.annotations.SerializedName;

public class ModelRegisterData {
	@SerializedName("id_user")
	private String id_user;

	@SerializedName("name")
	private String name;

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
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setUsername(String username){

		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}
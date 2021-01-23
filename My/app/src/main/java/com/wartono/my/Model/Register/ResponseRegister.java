package com.wartono.my.Model.Register;

import com.google.gson.annotations.SerializedName;

public class ResponseRegister {

	@SerializedName("data")
	private ModelRegisterData data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public ResponseRegister(String username, String name, String password) {

	}

    public void setData(ModelRegisterData data){

		this.data = data;
	}

	public ModelRegisterData getData(){

		return data;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}
}
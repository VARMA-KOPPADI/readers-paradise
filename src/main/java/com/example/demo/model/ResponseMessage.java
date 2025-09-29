package com.example.demo.model;

import java.util.List;

import com.example.demo.entity.User;

import lombok.Data;

@Data
public class ResponseMessage {
	
	public ResponseMessage(String status, String statusMsg) {
		super();
		this.status = status;
		this.statusMsg = statusMsg;
	}


	private int statusCode;
	private String status;
	private String statusMsg;
	private Object data;
	private List list;
	
	
	public ResponseMessage(int statusCode, String status, String statusMsg, Object data) {
		super();
		this.statusCode = statusCode;
		this.status = status;
		this.statusMsg = statusMsg;
		this.data = data;
	}


	public ResponseMessage(int statusCode, String status, String statusMsg) {
		super();
		this.statusCode = statusCode;
		this.status = status;
		this.statusMsg = statusMsg;
	}


	public ResponseMessage(String success, String string, User checkUser) {
		// TODO Auto-generated constructor stub
	}

}

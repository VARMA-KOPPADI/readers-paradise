package com.example.demo.model;

import java.util.List;

import lombok.Data;

@Data
public class ResponseMessage {
	
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

}

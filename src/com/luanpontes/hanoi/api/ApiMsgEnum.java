package com.luanpontes.hanoi.api;

public enum ApiMsgEnum {
	
	
	MSG_NOT_FOUND("{\"message\":\"Resource not found\"}"),
	
	MSG_INTERNAL_ERROR("{\"message\":\"Sorry, internal error :( \"}")
	
	;
	
	String msg;
	
	
	ApiMsgEnum(String msg){
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return msg;
	}
	

}

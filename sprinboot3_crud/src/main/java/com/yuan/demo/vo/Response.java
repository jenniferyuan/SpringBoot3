package com.yuan.demo.vo;

public class Response {
	
	public static final String SUCCESS = "successfully";
	public static final String FAILED = "failed";
	
	private Boolean flag;
	private Object data;
	private String msg;
	
	public Response() {
		super();
	}

	public Response(Boolean flag) {
		super();
		this.flag = flag;
	}
	
	public Response(Boolean flag, String msg) {
		super();
		this.flag = flag;
		this.msg = msg;
	}
	
	public Response(Boolean flag, Object data, String msg) {
		super();
		this.flag = flag;
		this.data = data;
		this.msg = msg;
	}

	public Boolean getFlag() {
		return flag;
	}
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	

}

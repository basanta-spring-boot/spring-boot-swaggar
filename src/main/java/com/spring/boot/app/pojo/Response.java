package com.spring.boot.app.pojo;

public class Response {
	private boolean isSuccess;
	private String status;

	public Response(boolean isSuccess, String status) {
		super();
		this.isSuccess = isSuccess;
		this.status = status;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

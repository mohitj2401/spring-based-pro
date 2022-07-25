package com.mohit.story.dto;

import java.util.List;

public class ErrorMessage {
	private List<String> output;
	private int statusCode;

	public List<String> getOutput() {
		return output;
	}

	public void setOutput(List<String> output) {
		this.output = output;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}

package com.project.entity;

public class Request {
	private int request_id;
	private int request_sender_id;
	private int request_receiver_id;
	private int request_tag;
	public int getRequest_id() {
		return request_id;
	}
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	public int getRequest_sender_id() {
		return request_sender_id;
	}
	public void setRequest_sender_id(int request_sender_id) {
		this.request_sender_id = request_sender_id;
	}
	public int getRequest_receiver_id() {
		return request_receiver_id;
	}
	public void setRequest_receiver_id(int request_receiver_id) {
		this.request_receiver_id = request_receiver_id;
	}
	public int getRequest_tag() {
		return request_tag;
	}
	public void setRequest_tag(int request_tag) {
		this.request_tag = request_tag;
	}
	
}

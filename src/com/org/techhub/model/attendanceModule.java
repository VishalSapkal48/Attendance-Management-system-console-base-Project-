package com.org.techhub.model;

import java.util.*;

public class attendanceModule {
	private int aid;
	private int status;
	private int studentid;
	private String dates;

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public attendanceModule() {
		this.aid = aid;

		this.status = status;
	}

	public attendanceModule(int aid, int status) {
		this.aid = aid;
		this.status = status;
	}

	public attendanceModule(int aid, int studentid, String dates, int status) {
		this.aid = aid;
		this.status = status;
		this.studentid = studentid;
		this.dates = dates;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "attendanceModule [aid=" + aid + ", status=" + status + ", studentid=" + studentid + ", dates=" + dates
				+ "]";
	}

}

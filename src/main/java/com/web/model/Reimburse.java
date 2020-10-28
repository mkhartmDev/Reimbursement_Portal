package com.web.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Reimburse {
	private int reimb_id;
	private BigDecimal amount;
	private LocalDateTime submitted;
	private LocalDateTime resolved;
	private String desc;
	private byte[] rec_pic;
	private int author;
	private int status;
	private int type;
	
	
	@Override
	public String toString() {
		return "Reimburse [reimb_id=" + reimb_id + ", amount=" + amount + ", submitted=" + submitted + ", resolved="
				+ resolved + ", desc=" + desc + ", author=" + author + ", status=" + status + ", type=" + type + "]";
	}
	
	public Reimburse(int reimb_id, BigDecimal amount, LocalDateTime submitted, LocalDateTime resolved, String desc, int author, int status, int type) {
		super();
		this.reimb_id = reimb_id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.desc = desc;
		// this.rec_pic = rec_pic;
		this.author = author;
		this.status = status;
		this.type = type;
	}
	
	public Reimburse(BigDecimal amount, String desc, int author, int type) {
		super();
		this.amount = amount;
		this.desc = desc;
		this.author = author;
		this.type = type;
	}
	
	
	
	
	

	public int getReimb_id() {
		return reimb_id;
	}
	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public LocalDateTime getSubmitted() {
		return submitted;
	}
	public void setSubmitted(LocalDateTime submitted) {
		this.submitted = submitted;
	}
	public LocalDateTime getResolved() {
		return resolved;
	}
	public void setResolved(LocalDateTime resolved) {
		this.resolved = resolved;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public byte[] getRec_pic() {
		return rec_pic;
	}
	public void setRec_pic(byte[] rec_pic) {
		this.rec_pic = rec_pic;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	

}

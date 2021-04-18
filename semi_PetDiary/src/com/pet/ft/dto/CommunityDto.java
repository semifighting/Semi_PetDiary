package com.pet.ft.dto;

import java.util.Date;

public class CommunityDto {
	
	private int community_seq;
	private String community_title;
	private String community_content;
	private Date community_regdate;
	private String community_report;
	private int community_reportcount;
	private int community_no;
	private int comment_no;
	private int member_no;
	
	public CommunityDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CommunityDto(int community_seq, String community_title, String community_content, Date community_regdate,
			String community_report, int community_reportcount, int community_no, int comment_no, int member_no) {
		super();
		this.community_seq = community_seq;
		this.community_title = community_title;
		this.community_content = community_content;
		this.community_regdate = community_regdate;
		this.community_report = community_report;
		this.community_reportcount = community_reportcount;
		this.community_no = community_no;
		this.comment_no = comment_no;
		this.member_no = member_no;
	}
	public int getCommunity_seq() {
		return community_seq;
	}
	public void setCommunity_seq(int community_seq) {
		this.community_seq = community_seq;
	}
	public String getCommunity_title() {
		return community_title;
	}
	public void setCommunity_title(String community_title) {
		this.community_title = community_title;
	}
	public String getCommunity_content() {
		return community_content;
	}
	public void setCommunity_content(String community_content) {
		this.community_content = community_content;
	}
	public Date getCommunity_regdate() {
		return community_regdate;
	}
	public void setCommunity_regdate(Date community_regdate) {
		this.community_regdate = community_regdate;
	}
	public String getCommunity_report() {
		return community_report;
	}
	public void setCommunity_report(String community_report) {
		this.community_report = community_report;
	}
	public int getCommunity_reportcount() {
		return community_reportcount;
	}
	public void setCommunity_reportcount(int community_reportcount) {
		this.community_reportcount = community_reportcount;
	}
	public int getCommunity_no() {
		return community_no;
	}
	public void setCommunity_no(int community_no) {
		this.community_no = community_no;
	}
	public int getComment_no() {
		return comment_no;
	}
	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	
	
}

package com.pet.ft.dto;

import java.util.Date;
public class BookDto {
	private int book_num;
	private Date book_date;
	private String book_time;
	private String book_type;
	private int book_store;
	private int member_no;
	private int book_price;
	private String book_state;
	private String book_hostime;
	
	
	public BookDto() {
		
	}


	public BookDto(int book_num, Date book_date, String book_time, String book_type, int book_store, int member_no,
			int book_price, String book_state, String book_hostime) {
		super();
		this.book_num = book_num;
		this.book_date = book_date;
		this.book_time = book_time;
		this.book_type = book_type;
		this.book_store = book_store;
		this.member_no = member_no;
		this.book_price = book_price;
		this.book_state = book_state;
		this.book_hostime = book_hostime;
	}


	public int getBook_num() {
		return book_num;
	}


	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}


	public Date getBook_date() {
		return book_date;
	}


	public void setBook_date(Date book_date) {
		this.book_date = book_date;
	}


	public String getBook_time() {
		return book_time;
	}


	public void setBook_time(String book_time) {
		this.book_time = book_time;
	}


	public String getBook_type() {
		return book_type;
	}


	public void setBook_type(String book_type) {
		this.book_type = book_type;
	}


	public int getBook_store() {
		return book_store;
	}


	public void setBook_store(int book_store) {
		this.book_store = book_store;
	}


	public int getMember_no() {
		return member_no;
	}


	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}


	public int getBook_price() {
		return book_price;
	}


	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}


	public String getBook_state() {
		return book_state;
	}


	public void setBook_state(String book_state) {
		this.book_state = book_state;
	}


	public String getBook_hostime() {
		return book_hostime;
	}


	public void setBook_hostime(String book_hostime) {
		this.book_hostime = book_hostime;
	}


}

package com.TM.spring.jpa;

import org.springframework.data.mongodb.core.mapping.*;
import org.springframework.data.annotation.*;
import java.util.Date;
import lombok.*;


@Data
@Builder
@AllArgsConstructor
@Document
@ToString
public class Book {
	@Id
	private String book_id;
	private String author;
	private String title;
	private double price;
	private Boolean available;
	private Date dueDate;
	private Date returnDate;
	private int issue;
	private String pub_id;
	private String memb_id;
	
	public Book() {}
	
	
	public void set_book_id(String book_id) {
		this.book_id = book_id;
	}
	public String get_book_id() {
		return book_id;
	}
	

	public void set_author(String author) {
		this.author = author;
	}
	public String get_author() {
		return author;
	}
	

	public void set_title(String title) {
		this.title = title;
	}
	public String get_title() {
		return title;
	}
	

	public void set_price(double price) {
		this.price = price;
	}
	public double get_price() {
		return price;
	}
	

	public void set_available(boolean available) {
		this.available = available;
	}
	public boolean get_available() {
		return available;
	}
	

	public void set_dueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date get_dueDate() {
		return dueDate;
	}
	

	public void set_returnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public Date get_returnDate() {
		return returnDate;
	}
	

	public void set_issue(int issue) {
		this.issue = issue;
	}
	public int get_issue() {
		return issue;
	}
	

	public void set_pub_id(String pub_id) {
		this.pub_id = pub_id;
	}
	public String get_pub_id() {
		return pub_id;
	}
	

	public void set_memb_id(String memb_id) {
		this.memb_id = memb_id;
	}
	public String get_memb_id() {
		return memb_id;
	}

	
}

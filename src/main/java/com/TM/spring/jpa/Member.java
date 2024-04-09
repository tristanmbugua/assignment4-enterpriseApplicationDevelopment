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
public class Member {

	@Id
	private String memb_id;
	private Date expiry_date;
	private String name;
	private String address;
	private int memb_type;
	private Date memb_date;
	
	public Member() {}
	
	public void set_expiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}
	public Date get_expiry_date() {
		return expiry_date;
	}
	
	public void set_name(String name) {
		this.name = name;
	}
	public String get_name() {
		return name;
	}
	

	public void set_address(String address) {
		this.address = address;
	}
	public String get_address() {
		return address;
	}
	

	public void set_memb_type(int memb_type) {
		this.memb_type = memb_type;
	}
	public int get_memb_type() {
		return memb_type;
	}
	

	public void set_memb_date(Date memb_date) {
		this.memb_date = memb_date;
	}
	public Date get_memb_date() {
		return memb_date;
	}
	

	public void set_memb_id(String memb_id) {
		this.memb_id = memb_id;
	}
	public String get_memb_id() {
		return memb_id;
	}
}

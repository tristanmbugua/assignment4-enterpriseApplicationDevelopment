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
public class Publisher {

	@Id
	private String pub_id;
	private String address;
	private String name;
	
	public void set_pub_id(String pub_id) {
		this.pub_id = pub_id;
	}
	public String get_pub_id() {
		return pub_id;
	}
	

	public void set_address(String address) {
		this.address = address;
	}
	public String get_address() {
		return address;
	}
	

	public void set_name(String name) {
		this.name = name;
	}
	public String get_name() {
		return name;
	}
}

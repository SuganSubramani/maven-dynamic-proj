package com.hibernateweb.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")
public class User {

	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="identifier", sequenceName="user_id_seq", allocationSize=1)  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="identifier")
	@Column(name = "id")
    private Integer userid;
	
	public Integer getId(){
	    return userid;
	}
	
	public void setId(Integer userid) {
		this.userid = userid;
	}
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "city")
	private String city;
	
	
	public int getUserId() {
		return userid;
	} 
	
	public String getUsername() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setUserName(String userName) {
		// TODO Auto-generated method stub
		this.userName = userName;
	}

	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password = password;
		
	}

	public void setEmail(String email) {
		// TODO Auto-generated method stub
		this.email = email;
		
	}

	public void setCity(String city) {
		// TODO Auto-generated method stub
		this.city = city;
	}

	public void setPhone(String phone) {
		// TODO Auto-generated method stub
		this.phone = phone;
	}

   

}

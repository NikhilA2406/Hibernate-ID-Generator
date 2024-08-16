package com.nikhil.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="userinfo")
public class userinfo 
{
	@Id
	@GeneratedValue(generator="my_seq" ,strategy=GenerationType.IDENTITY)
	@SequenceGenerator(name="my_seq",sequenceName="My_OwnSequence", initialValue=100, allocationSize=1)
     private Integer uid;
     
     private String uName;
     
     private String ucity;
	
	public userinfo()
	{
		System.out.println("Zero Param Constructor for Hibernate");
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getUcity() {
		return ucity;
	}

	public void setUcity(String ucity) {
		this.ucity = ucity;
	}

	@Override
	public String toString() {
		return "userinfo [uid=" + uid + ", uName=" + uName + ", ucity=" + ucity + "]";
	}
	


	
}

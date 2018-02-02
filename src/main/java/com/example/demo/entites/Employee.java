package com.example.demo.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "emp_num")
	private Integer empnum;
	@Column(name = "emp_name")
	private String empname;	
	public Integer getEmpnum() {
		return empnum;
	}
	public void setEmpnum(Integer empnum) {
		this.empnum = empnum;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}

}

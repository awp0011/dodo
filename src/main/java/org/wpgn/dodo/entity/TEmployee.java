package org.wpgn.dodo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the t_employee database table.
 * 
 */
@Entity
@Table(name = "t_employee")
public class TEmployee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8701434737528513598L;

	/**
	 * 
	 */

	private int age;

	private String birthday;

	private String city;

	private String country;

	private String createtime;
	
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "dept_id")
	private TDepartment department;
	
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "educational")
	private TEducational educational;

	private String email;

	private int gender;
	@Id
	private String id;

	private String loginname;

	private int married;

	private String name;
	
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "position")
	private TPosition position;

	private String remarks;

	private String salary;

	private String school;

	public TEmployee() {
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public TDepartment getDepartment() {
		return department;
	}

	public void setDepartment(TDepartment department) {
		this.department = department;
	}

	

	public TEducational getEducational() {
		return educational;
	}

	public void setEducational(TEducational educational) {
		this.educational = educational;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGender() {
		return this.gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginname() {
		return this.loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public int getMarried() {
		return this.married;
	}

	public void setMarried(int married) {
		this.married = married;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TPosition getPosition() {
		return this.position;
	}

	public void setPosition(TPosition position) {
		this.position = position;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSalary() {
		return this.salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

}
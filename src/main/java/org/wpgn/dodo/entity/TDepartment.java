package org.wpgn.dodo.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_department database table.
 * 
 */
@Entity
@Table(name="t_department")
public class TDepartment implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String id;

	private String manager;

	@Column(name="manager_name")
	private String managerName;

	private String name;

	public TDepartment() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getManager() {
		return this.manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getManagerName() {
		return this.managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
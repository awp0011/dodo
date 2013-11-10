package org.wpgn.dodo.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_position database table.
 * 
 */
@Entity
@Table(name="t_position")
public class TPosition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="dept_id")
	private String deptId;
	@Id
	private String id;

	private String name;

	public TPosition() {
	}

	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
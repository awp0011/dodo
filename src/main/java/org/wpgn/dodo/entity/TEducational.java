package org.wpgn.dodo.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_educational database table.
 * 
 */
@Entity
@Table(name="t_educational")
public class TEducational implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String id;

	private String name;

	public TEducational() {
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
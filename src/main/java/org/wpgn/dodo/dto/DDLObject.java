package org.wpgn.dodo.dto;

public class DDLObject {
	private String id;
	private String text;
	
	public DDLObject(final String id,final String text){
		this.id = id;
		this.text = text;
	}
	public String getId() {
		return id;
	}
	public void setId(final String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(final String text) {
		this.text = text;
	}
	
}

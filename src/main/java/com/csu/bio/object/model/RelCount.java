package com.csu.bio.object.model;

public class RelCount {
	private String disease_id;
	private Long count;
	private String association_type;

	public String getDisease_id() {
		return disease_id;
	}

	public void setDisease_id(String disease_id) {
		this.disease_id = disease_id;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getAssociation_type() {
		return association_type;
	}

	public void setAssociation_type(String association_type) {
		this.association_type = association_type;
	}
}

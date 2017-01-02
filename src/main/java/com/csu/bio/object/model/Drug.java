package com.csu.bio.object.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "drug")
public class Drug {

	@Id
	private String id;

	@Field("disease_id")
	private String disease_id;

	@Field("disease_name")
	private String disease_name;

	@Field("drug_id")
	private String drug_id;

	@Field("drug_name")
	private String drug_name;

	@Field("category")
	private String category;

	@Field("n_resources")
	private int n_resources;

	@Field("n_curators")
	private int n_curators;

	@Field("source")
	private String source;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDisease_id() {
		return disease_id;
	}

	public void setDisease_id(String disease_id) {
		this.disease_id = disease_id;
	}

	public String getDisease_name() {
		return disease_name;
	}

	public void setDisease_name(String disease_name) {
		this.disease_name = disease_name;
	}

	public String getDrug_id() {
		return drug_id;
	}

	public void setDrug_id(String drug_id) {
		this.drug_id = drug_id;
	}

	public String getDrug_name() {
		return drug_name;
	}

	public void setDrug_name(String drug_name) {
		this.drug_name = drug_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getN_resources() {
		return n_resources;
	}

	public void setN_resources(int n_resources) {
		this.n_resources = n_resources;
	}

	public int getN_curators() {
		return n_curators;
	}

	public void setN_curators(int n_curators) {
		this.n_curators = n_curators;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}

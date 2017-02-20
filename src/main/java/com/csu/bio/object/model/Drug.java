package com.csu.bio.object.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "drug")
public class Drug {

	/**
	 * common fields
	 */
	@Id
	private String id;

	@TextIndexed
	@Field("disease_id")
	private String disease_id;

	@Field("map_id")
	private String disease_map_id;

	@TextIndexed
	@Field("disease_name")
	private String disease_name;

	@TextIndexed
	@Field("drug_id")
	private String drug_id;

	@TextIndexed
	@Field("drug_name")
	private String drug_name;

	@TextIndexed
	@Field("source")
	private String source;

	/**
	 * pydb fields
	 */
	@Field("category")
	private String category;

	@Field("n_resources")
	private int num_of_resources;

	@Field("n_curators")
	private int nun_of_curators;

	/**
	 * ndfrt fields
	 */
	@Field("nui")
	private String nui;

	@Field("rxnorm_cui")
	private String rxnorm_concept_id;

	@Field("fda_unii")
	private String fda_unii;

	@Field("level")
	private String level;

	/**
	 * kegg fields
	 */
	@Field("drug_id_type")
	private String drug_id_type;

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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getNum_of_resources() {
		return num_of_resources;
	}

	public void setNum_of_resources(int num_of_resources) {
		this.num_of_resources = num_of_resources;
	}

	public int getNun_of_curators() {
		return nun_of_curators;
	}

	public void setNun_of_curators(int nun_of_curators) {
		this.nun_of_curators = nun_of_curators;
	}

	public String getNui() {
		return nui;
	}

	public void setNui(String nui) {
		this.nui = nui;
	}

	public String getRxnorm_concept_id() {
		return rxnorm_concept_id;
	}

	public void setRxnorm_concept_id(String rxnorm_concept_id) {
		this.rxnorm_concept_id = rxnorm_concept_id;
	}

	public String getFda_unii() {
		return fda_unii;
	}

	public void setFda_unii(String fda_unii) {
		this.fda_unii = fda_unii;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getDrug_id_type() {
		return drug_id_type;
	}

	public void setDrug_id_type(String drug_id_type) {
		this.drug_id_type = drug_id_type;
	}

	public String getDisease_map_id() {
		return disease_map_id;
	}

	public void setDisease_map_id(String disease_map_id) {
		this.disease_map_id = disease_map_id;
	}
}

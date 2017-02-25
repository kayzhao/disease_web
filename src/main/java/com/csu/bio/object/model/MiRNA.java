package com.csu.bio.object.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * for the MiRNA collection
 * 
 * @author kayzhao
 */

@Document(collection = "mirna")
public class MiRNA {
	/**
	 * common fields
	 */
	@Id
	private String id;

	@TextIndexed
	@Field("umls_cui")
	private String umls_cui;

	@TextIndexed
	@Field("disease_id")
	private String disease_id;

	@Field("disease_name")
	private String disease_name;

	@Field("source")
	private String source;

	@Field("mirna_name")
	private String mirna_name;

	@Field("description")
	private String description;

	@Field("mirna_target")
	private List<HashMap<String, String>> mirna_targets;

	/**
	 * hmdd
	 */
	@Field("pubmed")
	private String pubmed;

	/**
	 * miR2disease fields
	 */
	@Field("origin_source")
	private String origin_source;

	@Field("regulate")
	private String regulate_type;

	@Field("year")
	private Integer year;

	private String data_type;

	public String getData_type() {
		return data_type;
	}

	public void setData_type(String data_type) {
		this.data_type = data_type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUmls_cui() {
		return umls_cui;
	}

	public void setUmls_cui(String umls_cui) {
		this.umls_cui = umls_cui;
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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getMirna_name() {
		return mirna_name;
	}

	public void setMirna_name(String mirna_name) {
		this.mirna_name = mirna_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<HashMap<String, String>> getMirna_targets() {
		return mirna_targets;
	}

	public void setMirna_targets(List<HashMap<String, String>> mirna_targets) {
		this.mirna_targets = mirna_targets;
	}

	public String getPubmed() {
		return pubmed;
	}

	public void setPubmed(String pubmed) {
		this.pubmed = pubmed;
	}

	public String getOrigin_source() {
		return origin_source;
	}

	public void setOrigin_source(String origin_source) {
		this.origin_source = origin_source;
	}

	public String getRegulate_type() {
		return regulate_type;
	}

	public void setRegulate_type(String regulate_type) {
		this.regulate_type = regulate_type;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
}

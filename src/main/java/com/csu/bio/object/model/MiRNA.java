package com.csu.bio.object.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.annotation.Id;
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

	@Field("map_id")
	private String disease_map_id;

	@Field("disease_id")
	private String disease_original_id;

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
	private String pubmed_reference;

	/**
	 * miR2disease fields
	 */
	@Field("origin_source")
	private String origin_source;

	@Field("regulate")
	private String regulate_type;

	@Field("year")
	private Integer year;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDisease_map_id() {
		return disease_map_id;
	}

	public void setDisease_map_id(String disease_map_id) {
		this.disease_map_id = disease_map_id;
	}

	public String getDisease_original_id() {
		return disease_original_id;
	}

	public void setDisease_original_id(String disease_original_id) {
		this.disease_original_id = disease_original_id;
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

	public String getPubmed_reference() {
		return pubmed_reference;
	}

	public void setPubmed_reference(String pubmed_reference) {
		this.pubmed_reference = pubmed_reference;
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

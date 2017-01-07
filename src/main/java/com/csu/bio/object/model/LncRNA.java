package com.csu.bio.object.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * for the LncRNA collection
 * 
 * @author kayzhao
 */

@Document
public class LncRNA {
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

	@Field("lncrna_name")
	private String lncrna_name;

	@Field("description")
	private String description;

	@Field("mirna_target")
	private List<HashMap<String, String>> mirna_targets;

	@Field("pmid")
	private Integer pubmed_reference;

	@Field("chr")
	private String chromosome;

	@Field("dyregulation_type")
	private String dyregulation_type;

	@Field("start")
	private String start;

	@Field("end")
	private String end;

	@Field("alias")
	private String lncrna_alias;

	@Field("species")
	private String lncrna_species;

	@Field("genbank_id")
	private String genbank_id;

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

	public String getLncrna_name() {
		return lncrna_name;
	}

	public void setLncrna_name(String lncrna_name) {
		this.lncrna_name = lncrna_name;
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

	public Integer getPubmed_reference() {
		return pubmed_reference;
	}

	public void setPubmed_reference(Integer pubmed_reference) {
		this.pubmed_reference = pubmed_reference;
	}

	public String getChromosome() {
		return chromosome;
	}

	public void setChromosome(String chromosome) {
		this.chromosome = chromosome;
	}

	public String getDyregulation_type() {
		return dyregulation_type;
	}

	public void setDyregulation_type(String dyregulation_type) {
		this.dyregulation_type = dyregulation_type;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getLncrna_alias() {
		return lncrna_alias;
	}

	public void setLncrna_alias(String lncrna_alias) {
		this.lncrna_alias = lncrna_alias;
	}

	public String getLncrna_species() {
		return lncrna_species;
	}

	public void setLncrna_species(String lncrna_species) {
		this.lncrna_species = lncrna_species;
	}

	public String getGenbank_id() {
		return genbank_id;
	}

	public void setGenbank_id(String genbank_id) {
		this.genbank_id = genbank_id;
	}
}

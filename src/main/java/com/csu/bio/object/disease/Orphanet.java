package com.csu.bio.object.disease;

import java.util.HashMap;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.csu.bio.object.po.Concept;

public class Orphanet {

	/**
	 * common fields
	 */
	@Id
	@TextIndexed
	private String id;

	@TextIndexed
	@Field("synonym")
	private List<String> disease_synonyms;

	@TextIndexed
	@Field("name")
	private String disease_name;

	@Field("xref")
	private HashMap<String, List<String>> disease_xrefs;

	@Field("source")
	private List<String> sources;

	/**
	 * orphanet fields
	 */
	@Field("definition_citation")
	private String definition_citation;

	@Field("definition")
	private String orphanet_definition;

	@Field("definitions")
	private String orphanet_definitions;

	@Field("preferred_label")
	private String preferred_label;

	@Field("parents")
	private List<String> parents;

	@Field("tree_view")
	private List<String> tree_views;

	@Field("mapping")
	private HashMap<String, List<String>> disease_mappings;

	@Field("type_of_inheritance")
	private List<String> type_of_inheritance_records;

	@Field("ave_age_of_death")
	private List<String> average_age_of_death_records;

	@Field("ave_age_of_onset")
	private List<String> average_age_of_onset_records;

	@Field("prevalence")
	private List<HashMap<String, String>> prevalence_records;

	/**
	 * getters and setters
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public HashMap<String, List<String>> getDisease_xrefs() {
		return disease_xrefs;
	}

	public void setDisease_xrefs(HashMap<String, List<String>> disease_xrefs) {
		this.disease_xrefs = disease_xrefs;
	}

	public String getDefinition_citation() {
		return definition_citation;
	}

	public void setDefinition_citation(String definition_citation) {
		this.definition_citation = definition_citation;
	}

	public String getOrphanet_definition() {
		return orphanet_definition;
	}

	public void setOrphanet_definition(String orphanet_definition) {
		this.orphanet_definition = orphanet_definition;
	}

	public String getOrphanet_definitions() {
		return orphanet_definitions;
	}

	public void setOrphanet_definitions(String orphanet_definitions) {
		this.orphanet_definitions = orphanet_definitions;
	}

	public String getPreferred_label() {
		return preferred_label;
	}

	public void setPreferred_label(String preferred_label) {
		this.preferred_label = preferred_label;
	}

	public List<String> getParents() {
		return parents;
	}

	public void setParents(List<String> parents) {
		this.parents = parents;
	}

	public List<String> getTree_views() {
		return tree_views;
	}

	public void setTree_views(List<String> tree_views) {
		this.tree_views = tree_views;
	}

	public List<String> getType_of_inheritance_records() {
		return type_of_inheritance_records;
	}

	public void setType_of_inheritance_records(List<String> type_of_inheritance_records) {
		this.type_of_inheritance_records = type_of_inheritance_records;
	}

	public List<String> getAverage_age_of_death_records() {
		return average_age_of_death_records;
	}

	public void setAverage_age_of_death_records(List<String> average_age_of_death_records) {
		this.average_age_of_death_records = average_age_of_death_records;
	}

	public List<String> getAverage_age_of_onset_records() {
		return average_age_of_onset_records;
	}

	public void setAverage_age_of_onset_records(List<String> average_age_of_onset_records) {
		this.average_age_of_onset_records = average_age_of_onset_records;
	}

	public HashMap<String, List<String>> getDisease_mappings() {
		return disease_mappings;
	}

	public void setDisease_mappings(HashMap<String, List<String>> disease_mappings) {
		this.disease_mappings = disease_mappings;
	}

	public List<HashMap<String, String>> getPrevalence_records() {
		return prevalence_records;
	}

	public void setPrevalence_records(List<HashMap<String, String>> prevalence_records) {
		this.prevalence_records = prevalence_records;
	}

	public List<String> getDisease_synonyms() {
		return disease_synonyms;
	}

	public void setDisease_synonyms(List<String> disease_synonyms) {
		this.disease_synonyms = disease_synonyms;
	}

	public String getDisease_name() {
		return disease_name;
	}

	public void setDisease_name(String disease_name) {
		this.disease_name = disease_name;
	}

	public List<String> getSources() {
		return sources;
	}

	public void setSources(List<String> sources) {
		this.sources = sources;
	}
}

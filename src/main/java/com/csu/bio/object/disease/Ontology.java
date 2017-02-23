package com.csu.bio.object.disease;

import java.util.HashMap;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.csu.bio.object.po.Concept;

@Document(collection = "umls_disease")
public class Ontology {

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
	 * do , hpo , efo fields
	 */

	@Field("def")
	private String definition;

	@Field("comment")
	private String comment;

	@Field("subset")
	private List<String> subsets;

	@Field("namespace")
	private String namespace;

	@Field("is_a")
	private List<String> relationships_of_is_a;

	@Field("part_of")
	private List<String> relationships_of_part_of;

	@Field("alt_id")
	private List<String> alternate_ids;

	@Field("created_by")
	private String created_by;

	@Field("created_date")
	private String created_date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public HashMap<String, List<String>> getDisease_xrefs() {
		return disease_xrefs;
	}

	public void setDisease_xrefs(HashMap<String, List<String>> disease_xrefs) {
		this.disease_xrefs = disease_xrefs;
	}

	public List<String> getSources() {
		return sources;
	}

	public void setSources(List<String> sources) {
		this.sources = sources;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<String> getSubsets() {
		return subsets;
	}

	public void setSubsets(List<String> subsets) {
		this.subsets = subsets;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public List<String> getRelationships_of_is_a() {
		return relationships_of_is_a;
	}

	public void setRelationships_of_is_a(List<String> relationships_of_is_a) {
		this.relationships_of_is_a = relationships_of_is_a;
	}

	public List<String> getRelationships_of_part_of() {
		return relationships_of_part_of;
	}

	public void setRelationships_of_part_of(List<String> relationships_of_part_of) {
		this.relationships_of_part_of = relationships_of_part_of;
	}

	public List<String> getAlternate_ids() {
		return alternate_ids;
	}

	public void setAlternate_ids(List<String> alternate_ids) {
		this.alternate_ids = alternate_ids;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
}

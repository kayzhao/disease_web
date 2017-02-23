package com.csu.bio.object.disease;

import java.util.HashMap;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.csu.bio.object.po.Concept;

@Document(collection = "umls_disease")
public class MESH {

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
	 * mesh fields
	 */
	@Field("note")
	private String note;

	@Field("see_also")
	private List<String> see_also;

	@Field("last_updated")
	private String last_updated;

	@Field("semantic_type")
	private List<String> semantic_types;

	@Field("semantic_type_id")
	private List<String> semantic_type_ids;

	@Field("record_type")
	private String record_type;

	@Field("tree")
	private List<String> mesh_trees;

	@Field("descriptor_class")
	private String descriptor_class;

	@Field("term")
	private String term;

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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<String> getSee_also() {
		return see_also;
	}

	public void setSee_also(List<String> see_also) {
		this.see_also = see_also;
	}

	public String getLast_updated() {
		return last_updated;
	}

	public void setLast_updated(String last_updated) {
		this.last_updated = last_updated;
	}

	public List<String> getSemantic_types() {
		return semantic_types;
	}

	public void setSemantic_types(List<String> semantic_types) {
		this.semantic_types = semantic_types;
	}

	public List<String> getSemantic_type_ids() {
		return semantic_type_ids;
	}

	public void setSemantic_type_ids(List<String> semantic_type_ids) {
		this.semantic_type_ids = semantic_type_ids;
	}

	public String getRecord_type() {
		return record_type;
	}

	public void setRecord_type(String record_type) {
		this.record_type = record_type;
	}

	public List<String> getMesh_trees() {
		return mesh_trees;
	}

	public void setMesh_trees(List<String> mesh_trees) {
		this.mesh_trees = mesh_trees;
	}

	public String getDescriptor_class() {
		return descriptor_class;
	}

	public void setDescriptor_class(String descriptor_class) {
		this.descriptor_class = descriptor_class;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}
}

package com.csu.bio.object.model;

import java.util.HashMap;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.csu.bio.object.po.Concept;

@Document(collection = "disease")
public class Disease {

	@Id
	private String id;

	@Field("xref")
	private HashMap<String, List<String>> disease_mapping;

	private List<String> synonym;

	private List<HashMap<String, String>> disease_relationships;

	@Field("ruis")
	private List<String> umls_relationship_identifiers;

	@Field("concepts")
	private List<Concept> umls_disease_concepts;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getSynonym() {
		return synonym;
	}

	public void setSynonym(List<String> synonym) {
		this.synonym = synonym;
	}

	public HashMap<String, List<String>> getDisease_mapping() {
		return disease_mapping;
	}

	public void setDisease_mapping(HashMap<String, List<String>> disease_mapping) {
		this.disease_mapping = disease_mapping;
	}

	public List<HashMap<String, String>> getDisease_relationships() {
		return disease_relationships;
	}

	public void setDisease_relationships(List<HashMap<String, String>> disease_relationships) {
		this.disease_relationships = disease_relationships;
	}

	public List<String> getUmls_relationship_identifiers() {
		return umls_relationship_identifiers;
	}

	public void setUmls_relationship_identifiers(List<String> umls_relationship_identifiers) {
		this.umls_relationship_identifiers = umls_relationship_identifiers;
	}

	public List<Concept> getUmls_disease_concepts() {
		return umls_disease_concepts;
	}

	public void setUmls_disease_concepts(List<Concept> umls_disease_concepts) {
		this.umls_disease_concepts = umls_disease_concepts;
	}
}

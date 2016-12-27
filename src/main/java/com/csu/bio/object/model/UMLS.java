package com.csu.bio.object.model;

import java.util.HashMap;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "umls")
public class UMLS {

	@Id
	private String id;

	private HashMap<String, List<String>> xref;

	private List<String> synonym;

	private List<HashMap<String, String>> relationships;

	private List<String> ruis;

	// private List<HashMap<String, String>> snps;
	// private List<HashMap<String, String>> genes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public HashMap<String, List<String>> getXref() {
		return xref;
	}

	public void setXref(HashMap<String, List<String>> xref) {
		this.xref = xref;
	}

	public List<String> getSynonym() {
		return synonym;
	}

	public void setSynonym(List<String> synonym) {
		this.synonym = synonym;
	}

	public List<HashMap<String, String>> getRelationships() {
		return relationships;
	}

	public void setRelationships(List<HashMap<String, String>> relationships) {
		this.relationships = relationships;
	}

	public List<String> getRuis() {
		return ruis;
	}

	public void setRuis(List<String> ruis) {
		this.ruis = ruis;
	}

}

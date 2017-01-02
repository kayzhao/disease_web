package com.csu.bio.object.original;

import java.util.HashMap;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.csu.bio.object.po.Gene_KEGG;

@Document(collection = "kegg")
public class KEGG {

	@Id
	private String id;

	private HashMap<String, List<String>> xref;

	private String name;

	private HashMap<String, List<String>> reference;

	private List<String> drugs;

	private String category;

	private String description;

	@Field("genes")
	private List<Gene_KEGG> genes;

	@Field("markers")
	private List<Gene_KEGG> markers;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<String, List<String>> getReference() {
		return reference;
	}

	public void setReference(HashMap<String, List<String>> reference) {
		this.reference = reference;
	}

	public List<String> getDrugs() {
		return drugs;
	}

	public void setDrugs(List<String> drugs) {
		this.drugs = drugs;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Gene_KEGG> getGenes() {
		return genes;
	}

	public void setGenes(List<Gene_KEGG> genes) {
		this.genes = genes;
	}

	public List<Gene_KEGG> getMarkers() {
		return markers;
	}

	public void setMarkers(List<Gene_KEGG> markers) {
		this.markers = markers;
	}
}

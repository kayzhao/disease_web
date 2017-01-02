package com.csu.bio.object.original;

import java.util.HashMap;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "do")
public class DiseaseOntogoly {

	@Id
	private String id;

	private HashMap<String, List<String>> xref;

	private List<String> synonym;

	private String name;

	private List<String> is_a;

	private List<String> alt_id;

	private String def;

	private List<String> subset;

	private String comment;

	private String created_by;

	private String created_date;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getIs_a() {
		return is_a;
	}

	public void setIs_a(List<String> is_a) {
		this.is_a = is_a;
	}

	public List<String> getAlt_id() {
		return alt_id;
	}

	public void setAlt_id(List<String> alt_id) {
		this.alt_id = alt_id;
	}

	public String getDef() {
		return def;
	}

	public void setDef(String def) {
		this.def = def;
	}

	public List<String> getSubset() {
		return subset;
	}

	public void setSubset(List<String> subset) {
		this.subset = subset;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
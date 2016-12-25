package com.csu.bio.object.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.csu.bio.object.po.KeyValue;

@Document(collection = "do")
public class DiseaseOntogoly {

	@Id
	private String id;

	private List<String> synonym;

	private String name;

	private List<String> is_a;

	private String created_by;

	private String created_date;

	private String comment;

	private String def;

	private HashMap<String, List<String>> xref;

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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDef() {
		return def;
	}

	public void setDef(String def) {
		this.def = def;
	}

	public HashMap<String, List<String>> getXref() {
		return xref;
	}

	public void setXref(HashMap<String, List<String>> xref) {
		this.xref = xref;
	}
}

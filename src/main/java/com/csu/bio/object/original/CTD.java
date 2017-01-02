package com.csu.bio.object.original;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.csu.bio.object.model.Chemical;
import com.csu.bio.object.po.GO;
import com.csu.bio.object.po.Gene_KEGG;
import com.csu.bio.object.po.Pathway;

@Document(collection = "ctd")
public class CTD {

	@Id
	private String id;

	private List<Pathway> pathways;

	@Field("go_bp")
	private List<GO> go_bp;

	@Field("go_mf")
	private List<GO> go_mf;

	@Field("go_cc")
	private List<GO> go_cc;

	@Field("chemicals")
	private List<Chemical> chemicals;

	private List<Map<String, String>> genes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Pathway> getPathways() {
		return pathways;
	}

	public void setPathways(List<Pathway> pathways) {
		this.pathways = pathways;
	}

	public List<GO> getGo_bp() {
		return go_bp;
	}

	public void setGo_bp(List<GO> go_bp) {
		this.go_bp = go_bp;
	}

	public List<GO> getGo_mf() {
		return go_mf;
	}

	public void setGo_mf(List<GO> go_mf) {
		this.go_mf = go_mf;
	}

	public List<GO> getGo_cc() {
		return go_cc;
	}

	public void setGo_cc(List<GO> go_cc) {
		this.go_cc = go_cc;
	}

	public List<Chemical> getChemicals() {
		return chemicals;
	}

	public void setChemicals(List<Chemical> chemicals) {
		this.chemicals = chemicals;
	}

	public List<Map<String, String>> getGenes() {
		return genes;
	}

	public void setGenes(List<Map<String, String>> genes) {
		this.genes = genes;
	}
}

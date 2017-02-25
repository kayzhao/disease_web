package com.csu.bio.object.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author kayzhao
 * @version 2016年12月27日
 * 
 *          for the CTD database
 */

@Document(collection = "go")
public class GO {
	/**
	 * common fields
	 */
	@Id
	private String id;

	@TextIndexed
	@Field("disease_id")
	private String disease_id;

	@TextIndexed
	@Field("umls_cui")
	private String umls_cui;

	@TextIndexed
	@Field("disease_name")
	private String disease_name;

	@Field("source")
	private String source;

	@TextIndexed
	@Field("annotation_type")
	private String annotation_type;

	/**
	 * go fields
	 */
	@TextIndexed
	@Field("go_id")
	private String go_id;

	@TextIndexed
	@Field("go_name")
	private String go_name;

	@Field("inference_gene_qty")
	private int inference_gene_qty;

	@Field("inference_gene_symbols")
	private List<String> inference_gene_symbols;

	/**
	 * pathway fields
	 */
	@Field("pathway_id")
	private String pathway_id;

	@Field("pathway_name")
	private String pathway_name;

	@Field("inference_gene_symbol")
	private String inference_gene_symbol;

	private String data_type;

	public String getData_type() {
		return data_type;
	}

	public void setData_type(String data_type) {
		this.data_type = data_type;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDisease_id() {
		return disease_id;
	}

	public void setDisease_id(String disease_id) {
		this.disease_id = disease_id;
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

	public String getAnnotation_type() {
		return annotation_type;
	}

	public void setAnnotation_type(String annotation_type) {
		this.annotation_type = annotation_type;
	}

	public String getGo_id() {
		return go_id;
	}

	public void setGo_id(String go_id) {
		this.go_id = go_id;
	}

	public String getGo_name() {
		return go_name;
	}

	public void setGo_name(String go_name) {
		this.go_name = go_name;
	}

	public int getInference_gene_qty() {
		return inference_gene_qty;
	}

	public void setInference_gene_qty(int inference_gene_qty) {
		this.inference_gene_qty = inference_gene_qty;
	}

	public List<String> getInference_gene_symbols() {
		return inference_gene_symbols;
	}

	public void setInference_gene_symbols(List<String> inference_gene_symbols) {
		this.inference_gene_symbols = inference_gene_symbols;
	}

	public String getPathway_id() {
		return pathway_id;
	}

	public void setPathway_id(String pathway_id) {
		this.pathway_id = pathway_id;
	}

	public String getPathway_name() {
		return pathway_name;
	}

	public void setPathway_name(String pathway_name) {
		this.pathway_name = pathway_name;
	}

	public String getInference_gene_symbol() {
		return inference_gene_symbol;
	}

	public void setInference_gene_symbol(String inference_gene_symbol) {
		this.inference_gene_symbol = inference_gene_symbol;
	}

	public String getUmls_cui() {
		return umls_cui;
	}

	public void setUmls_cui(String umls_cui) {
		this.umls_cui = umls_cui;
	}
}

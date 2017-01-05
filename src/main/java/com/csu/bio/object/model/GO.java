package com.csu.bio.object.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author kayzhao
 * @version 2016年12月27日
 * 
 *          for the CTD database
 */

@Document
public class GO {
	/**
	 * common fields
	 */
	@Id
	private String id;

	@Field("disease_id")
	private String disease_id;

	@Field("disease_name")
	private String disease_name;

	@Field("source")
	private String source;

	@Field("annotation_type")
	private String annotation_type;

	/**
	 * go fields
	 */
	@Field("go_id")
	private String gene_id;

	@Field("go_name")
	private String gene_name;

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

	public String getGene_id() {
		return gene_id;
	}

	public void setGene_id(String gene_id) {
		this.gene_id = gene_id;
	}

	public String getGene_name() {
		return gene_name;
	}

	public void setGene_name(String gene_name) {
		this.gene_name = gene_name;
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
}

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
public class Chemical {
	@Id
	private String id;

	@Field("disease")
	private String disease_id;

	@Field("pubmed")
	private List<String> pubmed;

	@Field("source")
	private String data_source;

	@Field("inference_score")
	private double inference_score;

	@Field("direct_evidence")
	private List<String> direct_evidence;

	@Field("omim")
	private List<String> omim;

	@Field("inference_gene_symbol")
	private String inference_gene_symbol;

	@Field("chemical")
	private String chemical;

	@Field("casrn")
	private String casrn;

	@Field("source")
	private String source;

	public String getCasrn() {
		return casrn;
	}

	public void setCasrn(String casrn) {
		this.casrn = casrn;
	}

	public List<String> getDirect_evidence() {
		return direct_evidence;
	}

	public void setDirect_evidence(List<String> direct_evidence) {
		this.direct_evidence = direct_evidence;
	}

	public List<String> getOmim() {
		return omim;
	}

	public void setOmim(List<String> omim) {
		this.omim = omim;
	}

	public String getInference_gene_symbol() {
		return inference_gene_symbol;
	}

	public void setInference_gene_symbol(String inference_gene_symbol) {
		this.inference_gene_symbol = inference_gene_symbol;
	}

	public List<String> getPubmed() {
		return pubmed;
	}

	public void setPubmed(List<String> pubmed) {
		this.pubmed = pubmed;
	}

	public String getChemical() {
		return chemical;
	}

	public void setChemical(String chemical) {
		this.chemical = chemical;
	}

	public double getInference_score() {
		return inference_score;
	}

	public void setInference_score(double inference_score) {
		this.inference_score = inference_score;
	}

	public String getData_source() {
		return data_source;
	}

	public void setData_source(String data_source) {
		this.data_source = data_source;
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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}

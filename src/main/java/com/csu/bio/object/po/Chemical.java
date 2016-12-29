package com.csu.bio.object.po;

import java.util.List;

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

	@Field("pubmed")
	private List<String> pubmed;

	@Field("gene")
	private String gene;

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
}

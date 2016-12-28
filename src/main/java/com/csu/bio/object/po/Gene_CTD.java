package com.csu.bio.object.po;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author kayzhao
 * @version 2016年12月27日
 * 
 *          for the CTDgenes Collection
 */

@Document
public class Gene_CTD {

	private String inference_chemical_name;

	private List<String> pubmed;

	private String gene;

	private double inference_score;

	private List<String> direct_evidence;

	private List<String> omim;

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

	public String getInference_chemical_name() {
		return inference_chemical_name;
	}

	public void setInference_chemical_name(String inference_chemical_name) {
		this.inference_chemical_name = inference_chemical_name;
	}

	public List<String> getPubmed() {
		return pubmed;
	}

	public void setPubmed(List<String> pubmed) {
		this.pubmed = pubmed;
	}

	public String getGene() {
		return gene;
	}

	public void setGene(String gene) {
		this.gene = gene;
	}

	public double getInference_score() {
		return inference_score;
	}

	public void setInference_score(double inference_score) {
		this.inference_score = inference_score;
	}
}

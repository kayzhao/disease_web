package com.csu.bio.object.po;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author kayzhao
 * @version 2016年12月27日
 */

@Document
public class Gene {

	@Field("#pmids")
	private int pmids;

	private List<String> source;

	@Field("#snps")
	private int snps;

	private double score;

	private String gene_name;

	private int gene_id;

	public int getPmids() {
		return pmids;
	}

	public void setPmids(int pmids) {
		this.pmids = pmids;
	}

	public List<String> getSource() {
		return source;
	}

	public void setSource(List<String> source) {
		this.source = source;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getGene_name() {
		return gene_name;
	}

	public void setGene_name(String gene_name) {
		this.gene_name = gene_name;
	}

	public int getGene_id() {
		return gene_id;
	}

	public void setGene_id(int gene_id) {
		this.gene_id = gene_id;
	}
}

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
public class SNP {

	@Field("alt")
	private String alt;

	@Field("pos")
	private String pos;

	@Field("source")
	private String source;

	@Field("gene_symbol")
	private String gene_symbol;

	@Field("ref")
	private String ref;

	@Field("gene_id")
	private int gene_id;

	@Field("rsid")
	private String rsid;

	@Field("score")
	private double score;

	@Field("gene_name")
	private String gene_name;

	@Field("chr")
	private String chr;

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getGene_symbol() {
		return gene_symbol;
	}

	public void setGene_symbol(String gene_symbol) {
		this.gene_symbol = gene_symbol;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public int getGene_id() {
		return gene_id;
	}

	public void setGene_id(int gene_id) {
		this.gene_id = gene_id;
	}

	public String getRsid() {
		return rsid;
	}

	public void setRsid(String rsid) {
		this.rsid = rsid;
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

	public String getChr() {
		return chr;
	}

	public void setChr(String chr) {
		this.chr = chr;
	}
}

package com.csu.bio.object.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author kayzhao
 */

@Document(collection = "snp")
public class SNP {
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

	@Field("gene_id")
	private String gene_id;

	@Field("gene_name")
	private String gene_name;

	/**
	 * disgenet fields
	 */
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

	@Field("rsid")
	private String rsid;

	@Field("score")
	private double score;

	@Field("chromosome")
	private String chromosome;

	@Field("pubmed")
	private String pubmed;

	@Field("chr")
	private String chr;

	@Field("description")
	private String description;

	@Field("year")
	private int year;

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

	public String getChromosome() {
		return chromosome;
	}

	public void setChromosome(String chromosome) {
		this.chromosome = chromosome;
	}

	public String getChr() {
		return chr;
	}

	public void setChr(String chr) {
		this.chr = chr;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getUmls_cui() {
		return umls_cui;
	}

	public void setUmls_cui(String umls_cui) {
		this.umls_cui = umls_cui;
	}

	public String getPubmed() {
		return pubmed;
	}

	public void setPubmed(String pubmed) {
		this.pubmed = pubmed;
	}
}
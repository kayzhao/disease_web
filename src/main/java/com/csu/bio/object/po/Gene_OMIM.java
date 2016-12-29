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
public class Gene_OMIM {

	@Field("entry_type")
	private String entry_type;

	@Field("ensembl")
	private List<String> ensembl;

	@Field("entrezgene")
	private int entrezgene;

	@Field("hgnc")
	private String hgnc;

	public String getEntry_type() {
		return entry_type;
	}

	public void setEntry_type(String entry_type) {
		this.entry_type = entry_type;
	}

	public List<String> getEnsembl() {
		return ensembl;
	}

	public void setEnsembl(List<String> ensembl) {
		this.ensembl = ensembl;
	}

	public int getEntrezgene() {
		return entrezgene;
	}

	public void setEntrezgene(int entrezgene) {
		this.entrezgene = entrezgene;
	}

	public String getHgnc() {
		return hgnc;
	}

	public void setHgnc(String hgnc) {
		this.hgnc = hgnc;
	}
}

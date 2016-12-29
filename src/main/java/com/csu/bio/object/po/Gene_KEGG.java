package com.csu.bio.object.po;

import java.util.HashMap;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author kayzhao
 * @version 2016年12月27日
 */

@Document
public class Gene_KEGG {

	@Field("gene_ref")
	private HashMap<String, List<String>> gene_ref;

	@Field("gene_name")
	private String gene_name;

	public HashMap<String, List<String>> getGene_ref() {
		return gene_ref;
	}

	public void setGene_ref(HashMap<String, List<String>> gene_ref) {
		this.gene_ref = gene_ref;
	}

	public String getGene_name() {
		return gene_name;
	}

	public void setGene_name(String gene_name) {
		this.gene_name = gene_name;
	}
}

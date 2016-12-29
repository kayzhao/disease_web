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
public class Pathway {

	@Field("inference_gene_symbol")
	private String inference_gene_symbol;;

	@Field("pathway")
	private String pathway;

	public String getInference_gene_symbol() {
		return inference_gene_symbol;
	}

	public void setInference_gene_symbol(String inference_gene_symbol) {
		this.inference_gene_symbol = inference_gene_symbol;
	}

	public String getPathway() {
		return pathway;
	}

	public void setPathway(String pathway) {
		this.pathway = pathway;
	}
}

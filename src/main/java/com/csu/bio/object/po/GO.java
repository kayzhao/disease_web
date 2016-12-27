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
public class GO {

	private List<String> inference_gene_symbols;;

	private String go;

	public List<String> getInference_gene_symbols() {
		return inference_gene_symbols;
	}

	public void setInference_gene_symbols(List<String> inference_gene_symbols) {
		this.inference_gene_symbols = inference_gene_symbols;
	}

	public String getGo() {
		return go;
	}

	public void setGo(String go) {
		this.go = go;
	}
}

package com.csu.bio.object.original;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.csu.bio.object.po.Gene;
import com.csu.bio.object.po.SNP;

@Document(collection = "disgenet")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)

public class Disgenet {

	@Id
	private String id;

	private List<Gene> genes;

	private List<SNP> snps;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Gene> getGenes() {
		return genes;
	}

	public void setGenes(List<Gene> genes) {
		this.genes = genes;
	}

	public List<SNP> getSnps() {
		return snps;
	}

	public void setSnps(List<SNP> snps) {
		this.snps = snps;
	}
}

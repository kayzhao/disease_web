package com.csu.bio.object.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.csu.bio.object.po.Gene_CTD;

@Document(collection = "ctdgenes")
public class CTDGenes {

	@Id
	private String id;

	private List<Gene_CTD> genes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Gene_CTD> getGenes() {
		return genes;
	}

	public void setGenes(List<Gene_CTD> genes) {
		this.genes = genes;
	}
}

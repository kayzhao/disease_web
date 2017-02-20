package com.csu.bio.object.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author kayzhao
 * @version 2016年12月27日
 * 
 *          for the CTDgenes Collection
 */

@Document(collection = "gene")
public class Gene {

	/**
	 * common fields
	 */
	@Id
	private String id;

	@Field("disease_id")
	@TextIndexed
	private String disease_id;

	@Field("map_id")
	private String disease_map_id;

	@TextIndexed
	@Field("disease_name")
	private String disease_name;

	@TextIndexed
	@Field("gene_id")
	private String gene_id;

	@TextIndexed
	@Field("gene_name")
	private String gene_name;

	@Field("source")
	private String source;

	/**
	 * ctd fields
	 */
	@Field("inference_chemical_name")
	private String inference_chemical_name;

	@Field("pubmed")
	private List<String> pubmed_references;

	@Field("inference_score")
	private double inference_score;

	@Field("direct_evidence")
	private List<String> direct_evidence;

	@Field("omim")
	private List<String> omim_ids;

	/**
	 * kegg fields
	 */

	@Field("gene_ref")
	private HashMap<String, List<String>> kegg_gene_ref;

	@Field("type")
	private String kegg_association_type;

	/**
	 * omim fields
	 */
	@Field("entry_type")
	private String entry_type;

	@Field("ensembl")
	private List<String> ensembl_id;

	@Field("entrezgene")
	private int entrezgene_id;

	@Field("hgnc")
	private String hgnc_id;

	/**
	 * disgenet fields
	 */

	@Field("origin_source")
	private List<String> origin_data_source;

	@Field("num_of_pmids")
	private int num_of_pmids;

	@Field("num_of_snps")
	private int num_of_snps;

	@Field("score")
	private double disgenet_score;

	@Field("description")
	private String description;

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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getInference_chemical_name() {
		return inference_chemical_name;
	}

	public void setInference_chemical_name(String inference_chemical_name) {
		this.inference_chemical_name = inference_chemical_name;
	}

	public List<String> getPubmed_references() {
		return pubmed_references;
	}

	public void setPubmed_references(List<String> pubmed_references) {
		this.pubmed_references = pubmed_references;
	}

	public double getInference_score() {
		return inference_score;
	}

	public void setInference_score(double inference_score) {
		this.inference_score = inference_score;
	}

	public List<String> getDirect_evidence() {
		return direct_evidence;
	}

	public void setDirect_evidence(List<String> direct_evidence) {
		this.direct_evidence = direct_evidence;
	}

	public List<String> getOmim_ids() {
		return omim_ids;
	}

	public void setOmim_ids(List<String> omim_ids) {
		this.omim_ids = omim_ids;
	}

	public HashMap<String, List<String>> getKegg_gene_ref() {
		return kegg_gene_ref;
	}

	public void setKegg_gene_ref(HashMap<String, List<String>> kegg_gene_ref) {
		this.kegg_gene_ref = kegg_gene_ref;
	}

	public String getKegg_association_type() {
		return kegg_association_type;
	}

	public void setKegg_association_type(String kegg_association_type) {
		this.kegg_association_type = kegg_association_type;
	}

	public String getEntry_type() {
		return entry_type;
	}

	public void setEntry_type(String entry_type) {
		this.entry_type = entry_type;
	}

	public List<String> getEnsembl_id() {
		return ensembl_id;
	}

	public void setEnsembl_id(List<String> ensembl_id) {
		this.ensembl_id = ensembl_id;
	}

	public int getEntrezgene_id() {
		return entrezgene_id;
	}

	public void setEntrezgene_id(int entrezgene_id) {
		this.entrezgene_id = entrezgene_id;
	}

	public String getHgnc_id() {
		return hgnc_id;
	}

	public void setHgnc_id(String hgnc_id) {
		this.hgnc_id = hgnc_id;
	}

	public int getNum_of_pmids() {
		return num_of_pmids;
	}

	public void setNum_of_pmids(int num_of_pmids) {
		this.num_of_pmids = num_of_pmids;
	}

	public List<String> getOrigin_data_source() {
		return origin_data_source;
	}

	public void setOrigin_data_source(List<String> origin_data_source) {
		this.origin_data_source = origin_data_source;
	}

	public int getNum_of_snps() {
		return num_of_snps;
	}

	public void setNum_of_snps(int num_of_snps) {
		this.num_of_snps = num_of_snps;
	}

	public double getDisgenet_score() {
		return disgenet_score;
	}

	public void setDisgenet_score(double disgenet_score) {
		this.disgenet_score = disgenet_score;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDisease_map_id() {
		return disease_map_id;
	}

	public void setDisease_map_id(String disease_map_id) {
		this.disease_map_id = disease_map_id;
	}
}

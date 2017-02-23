package com.csu.bio.object.disease;

import java.util.HashMap;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import com.csu.bio.object.po.Concept;

@Document(collection = "umls_disease")
public class Disease {

	/**
	 * common fields
	 */
	@Id
	@TextIndexed
	private String id;

	@TextIndexed
	@Field("synonym")
	private List<String> disease_synonyms;

	@TextIndexed
	@Field("name")
	private String disease_name;

	@Field("xref")
	private HashMap<String, List<String>> disease_xrefs;

	@Field("source")
	private List<String> sources;

	/**
	 * umls fields
	 */
	@Field("relationships")
	private List<HashMap<String, String>> disease_relationships;

	@Field("ruis")
	private List<String> relationship_identifiers;

	@Field("concepts")
	private List<Concept> disease_concepts;

	/**
	 * merge docs
	 */
	@Field("DOID")
	private List<Ontology> disease_ontology;

	@Field("HP")
	private List<Ontology> hpo;

	@Field("EFO")
	private List<Ontology> efo;

	@Field("KEGG")
	private List<KEGG> kegg;

	@Field("MESH")
	private List<MESH> mesh;

	@Field("OMIM")
	private List<OMIM> omim;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getDisease_synonyms() {
		return disease_synonyms;
	}

	public void setDisease_synonyms(List<String> disease_synonyms) {
		this.disease_synonyms = disease_synonyms;
	}

	public String getDisease_name() {
		return disease_name;
	}

	public void setDisease_name(String disease_name) {
		this.disease_name = disease_name;
	}

	public HashMap<String, List<String>> getDisease_xrefs() {
		return disease_xrefs;
	}

	public void setDisease_xrefs(HashMap<String, List<String>> disease_xrefs) {
		this.disease_xrefs = disease_xrefs;
	}

	public List<String> getSources() {
		return sources;
	}

	public void setSources(List<String> sources) {
		this.sources = sources;
	}

	public List<HashMap<String, String>> getDisease_relationships() {
		return disease_relationships;
	}

	public void setDisease_relationships(List<HashMap<String, String>> disease_relationships) {
		this.disease_relationships = disease_relationships;
	}

	public List<String> getRelationship_identifiers() {
		return relationship_identifiers;
	}

	public void setRelationship_identifiers(List<String> relationship_identifiers) {
		this.relationship_identifiers = relationship_identifiers;
	}

	public List<Concept> getDisease_concepts() {
		return disease_concepts;
	}

	public void setDisease_concepts(List<Concept> disease_concepts) {
		this.disease_concepts = disease_concepts;
	}

	public List<Ontology> getDisease_ontology() {
		return disease_ontology;
	}

	public void setDisease_ontology(List<Ontology> disease_ontology) {
		this.disease_ontology = disease_ontology;
	}

	public List<Ontology> getHpo() {
		return hpo;
	}

	public void setHpo(List<Ontology> hpo) {
		this.hpo = hpo;
	}

	public List<Ontology> getEfo() {
		return efo;
	}

	public void setEfo(List<Ontology> efo) {
		this.efo = efo;
	}

	public List<KEGG> getKegg() {
		return kegg;
	}

	public void setKegg(List<KEGG> kegg) {
		this.kegg = kegg;
	}

	public List<MESH> getMesh() {
		return mesh;
	}

	public void setMesh(List<MESH> mesh) {
		this.mesh = mesh;
	}

	public List<OMIM> getOmim() {
		return omim;
	}

	public void setOmim(List<OMIM> omim) {
		this.omim = omim;
	}

	/*
	 * @Field("ORPHANET") private List<Ontology> orphanet;
	 * 
	 * @Field("DOID") private List<Ontology> disease_notology;
	 * 
	 * @Field("HP") private List<Ontology> human_phenotype_ontology;
	 * 
	 * @Field("EFO") private List<Ontology> experimental_ontology;
	 * 
	 * @Field("KEGG") private List<KEGG> kyoto_encyclopedia_gene_genomes;
	 * 
	 * @Field("MESH") private List<MESH> medical_subject_headings;
	 * 
	 * @Field("OMIM") private List<OMIM> online_mendelian_inheritance_man;
	 * 
	 * @Field("ORPHANET") private List<Ontology> orphanet;
	 */
}

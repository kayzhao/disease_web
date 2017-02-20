package com.csu.bio.object.model;

import java.util.HashMap;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.csu.bio.object.po.Concept;

@Document(collection = "disease")
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

	@TextIndexed
	@Field("source")
	private List<String> sources;

	/**
	 * umls fields
	 */
	@Field("relationships")
	private List<HashMap<String, String>> disease_relationships;

	@Field("ruis")
	private List<String> umls_relationship_identifiers;

	@Field("concepts")
	private List<Concept> umls_disease_concepts;

	/**
	 * do , hpo , efo fields
	 */

	@Field("def")
	private String definition;

	@Field("comment")
	private String comment;

	@Field("subset")
	private List<String> subsets;

	@Field("namespace")
	private String namespace;

	@Field("is_a")
	private List<String> relationships_of_is_a;

	@Field("part_of")
	private List<String> relationships_of_part_of;

	@Field("alt_id")
	private List<String> alternate_ids;

	@Field("created_by")
	private String created_by;

	@Field("created_date")
	private String created_date;

	/**
	 * kegg fields
	 */
	@Field("catrgory")
	private String disease_category;

	@Field("description")
	private String disease_description;

	/**
	 * omim fields
	 */
	@Field("note")
	private String note;

	@Field("see_also")
	private List<String> see_also;

	@Field("last_updated")
	private String last_updated;

	@Field("semantic_type")
	private List<String> semantic_types;

	@Field("semantic_type_id")
	private List<String> semantic_type_ids;

	@Field("record_type")
	private String record_type;

	@Field("tree")
	private List<String> mesh_trees;

	@Field("descriptor_class")
	private String descriptor_class;

	@Field("term")
	private String term;

	/**
	 * omim fields
	 */
	@Field("type")
	private String type;

	@Field("title")
	private String title;

	@Field("alternative")
	private List<HashMap<String, String>> alternatives;

	@Field("symbol")
	private String symbol;

	@Field("included")
	private List<HashMap<String, String>> included_recodes;

	/**
	 * orphanet fields
	 */
	@Field("definition_citation")
	private String definition_citation;

	@Field("definition")
	private String orphanet_definition;

	@Field("definitions")
	private String orphanet_definitions;

	@Field("preferred_label")
	private String preferred_label;

	@Field("parents")
	private List<String> parents;

	@Field("tree_view")
	private List<String> tree_views;

	@Field("mapping")
	private HashMap<String, List<String>> disease_mappings;

	@Field("type_of_inheritance")
	private List<String> type_of_inheritance_records;

	@Field("ave_age_of_death")
	private List<String> average_age_of_death_records;

	@Field("ave_age_of_onset")
	private List<String> average_age_of_onset_records;

	@Field("prevalence")
	private List<HashMap<String, String>> prevalence_records;

	/**
	 * associations flag
	 */
	@Field("drugs")
	private Boolean has_drug_associations;

	@Field("genes")
	private Boolean has_gene_associations;

	@Field("gos")
	private Boolean has_go_associations;

	@Field("snps")
	private Boolean has_snp_associations;

	@Field("pathways")
	private Boolean has_pathway_associations;

	@Field("markers")
	private Boolean has_marker_associations;

	@Field("phenotypes")
	private Boolean has_phenotype_associations;

	@Field("chemicals")
	private Boolean has_chemical_associations;

	@Field("lncrnas")
	private Boolean has_lncrna_associations;

	@Field("mirnas")
	private Boolean has_mirna_associations;

	/**
	 * getters and setters
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public HashMap<String, List<String>> getDisease_xrefs() {
		return disease_xrefs;
	}

	public void setDisease_xrefs(HashMap<String, List<String>> disease_xrefs) {
		this.disease_xrefs = disease_xrefs;
	}

	public String getDefinition_citation() {
		return definition_citation;
	}

	public void setDefinition_citation(String definition_citation) {
		this.definition_citation = definition_citation;
	}

	public String getOrphanet_definition() {
		return orphanet_definition;
	}

	public void setOrphanet_definition(String orphanet_definition) {
		this.orphanet_definition = orphanet_definition;
	}

	public String getOrphanet_definitions() {
		return orphanet_definitions;
	}

	public void setOrphanet_definitions(String orphanet_definitions) {
		this.orphanet_definitions = orphanet_definitions;
	}

	public String getPreferred_label() {
		return preferred_label;
	}

	public void setPreferred_label(String preferred_label) {
		this.preferred_label = preferred_label;
	}

	public List<String> getParents() {
		return parents;
	}

	public void setParents(List<String> parents) {
		this.parents = parents;
	}

	public List<String> getTree_views() {
		return tree_views;
	}

	public void setTree_views(List<String> tree_views) {
		this.tree_views = tree_views;
	}

	public List<String> getType_of_inheritance_records() {
		return type_of_inheritance_records;
	}

	public void setType_of_inheritance_records(List<String> type_of_inheritance_records) {
		this.type_of_inheritance_records = type_of_inheritance_records;
	}

	public List<String> getAverage_age_of_death_records() {
		return average_age_of_death_records;
	}

	public void setAverage_age_of_death_records(List<String> average_age_of_death_records) {
		this.average_age_of_death_records = average_age_of_death_records;
	}

	public List<String> getAverage_age_of_onset_records() {
		return average_age_of_onset_records;
	}

	public void setAverage_age_of_onset_records(List<String> average_age_of_onset_records) {
		this.average_age_of_onset_records = average_age_of_onset_records;
	}

	public HashMap<String, List<String>> getDisease_mappings() {
		return disease_mappings;
	}

	public void setDisease_mappings(HashMap<String, List<String>> disease_mappings) {
		this.disease_mappings = disease_mappings;
	}

	public List<HashMap<String, String>> getPrevalence_records() {
		return prevalence_records;
	}

	public void setPrevalence_records(List<HashMap<String, String>> prevalence_records) {
		this.prevalence_records = prevalence_records;
	}

	public List<HashMap<String, String>> getDisease_relationships() {
		return disease_relationships;
	}

	public void setDisease_relationships(List<HashMap<String, String>> disease_relationships) {
		this.disease_relationships = disease_relationships;
	}

	public List<String> getUmls_relationship_identifiers() {
		return umls_relationship_identifiers;
	}

	public void setUmls_relationship_identifiers(List<String> umls_relationship_identifiers) {
		this.umls_relationship_identifiers = umls_relationship_identifiers;
	}

	public List<Concept> getUmls_disease_concepts() {
		return umls_disease_concepts;
	}

	public void setUmls_disease_concepts(List<Concept> umls_disease_concepts) {
		this.umls_disease_concepts = umls_disease_concepts;
	}

	public List<String> getDisease_synonyms() {
		return disease_synonyms;
	}

	public void setDisease_synonyms(List<String> disease_synonyms) {
		this.disease_synonyms = disease_synonyms;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDisease_name() {
		return disease_name;
	}

	public void setDisease_name(String disease_name) {
		this.disease_name = disease_name;
	}

	public List<String> getSubsets() {
		return subsets;
	}

	public void setSubsets(List<String> subsets) {
		this.subsets = subsets;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public List<String> getRelationships_of_is_a() {
		return relationships_of_is_a;
	}

	public void setRelationships_of_is_a(List<String> relationships_of_is_a) {
		this.relationships_of_is_a = relationships_of_is_a;
	}

	public List<String> getRelationships_of_part_of() {
		return relationships_of_part_of;
	}

	public void setRelationships_of_part_of(List<String> relationships_of_part_of) {
		this.relationships_of_part_of = relationships_of_part_of;
	}

	public List<String> getAlternate_ids() {
		return alternate_ids;
	}

	public void setAlternate_ids(List<String> alternate_ids) {
		this.alternate_ids = alternate_ids;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public Boolean getHas_drug_associations() {
		return has_drug_associations;
	}

	public void setHas_drug_associations(Boolean has_drug_associations) {
		this.has_drug_associations = has_drug_associations;
	}

	public Boolean getHas_gene_associations() {
		return has_gene_associations;
	}

	public void setHas_gene_associations(Boolean has_gene_associations) {
		this.has_gene_associations = has_gene_associations;
	}

	public Boolean getHas_go_associations() {
		return has_go_associations;
	}

	public void setHas_go_associations(Boolean has_go_associations) {
		this.has_go_associations = has_go_associations;
	}

	public Boolean getHas_snp_associations() {
		return has_snp_associations;
	}

	public void setHas_snp_associations(Boolean has_snp_associations) {
		this.has_snp_associations = has_snp_associations;
	}

	public Boolean getHas_pathway_associations() {
		return has_pathway_associations;
	}

	public void setHas_pathway_associations(Boolean has_pathway_associations) {
		this.has_pathway_associations = has_pathway_associations;
	}

	public Boolean getHas_marker_associations() {
		return has_marker_associations;
	}

	public void setHas_marker_associations(Boolean has_marker_associations) {
		this.has_marker_associations = has_marker_associations;
	}

	public Boolean getHas_phenotype_associations() {
		return has_phenotype_associations;
	}

	public void setHas_phenotype_associations(Boolean has_phenotype_associations) {
		this.has_phenotype_associations = has_phenotype_associations;
	}

	public Boolean getHas_chemical_associations() {
		return has_chemical_associations;
	}

	public void setHas_chemical_associations(Boolean has_chemical_associations) {
		this.has_chemical_associations = has_chemical_associations;
	}

	public Boolean getHas_lncrna_associations() {
		return has_lncrna_associations;
	}

	public void setHas_lncrna_associations(Boolean has_lncrna_associations) {
		this.has_lncrna_associations = has_lncrna_associations;
	}

	public Boolean getHas_mirna_associations() {
		return has_mirna_associations;
	}

	public void setHas_mirna_associations(Boolean has_mirna_associations) {
		this.has_mirna_associations = has_mirna_associations;
	}

	public List<String> getSources() {
		return sources;
	}

	public void setSources(List<String> sources) {
		this.sources = sources;
	}

	public String getDisease_category() {
		return disease_category;
	}

	public void setDisease_category(String disease_category) {
		this.disease_category = disease_category;
	}

	public String getDisease_description() {
		return disease_description;
	}

	public void setDisease_description(String disease_description) {
		this.disease_description = disease_description;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<String> getSee_also() {
		return see_also;
	}

	public void setSee_also(List<String> see_also) {
		this.see_also = see_also;
	}

	public String getLast_updated() {
		return last_updated;
	}

	public void setLast_updated(String last_updated) {
		this.last_updated = last_updated;
	}

	public List<String> getSemantic_types() {
		return semantic_types;
	}

	public void setSemantic_types(List<String> semantic_types) {
		this.semantic_types = semantic_types;
	}

	public List<String> getSemantic_type_ids() {
		return semantic_type_ids;
	}

	public void setSemantic_type_ids(List<String> semantic_type_ids) {
		this.semantic_type_ids = semantic_type_ids;
	}

	public String getRecord_type() {
		return record_type;
	}

	public void setRecord_type(String record_type) {
		this.record_type = record_type;
	}

	public List<String> getMesh_trees() {
		return mesh_trees;
	}

	public void setMesh_trees(List<String> mesh_trees) {
		this.mesh_trees = mesh_trees;
	}

	public String getDescriptor_class() {
		return descriptor_class;
	}

	public void setDescriptor_class(String descriptor_class) {
		this.descriptor_class = descriptor_class;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<HashMap<String, String>> getAlternatives() {
		return alternatives;
	}

	public void setAlternatives(List<HashMap<String, String>> alternatives) {
		this.alternatives = alternatives;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public List<HashMap<String, String>> getIncluded_recodes() {
		return included_recodes;
	}

	public void setIncluded_recodes(List<HashMap<String, String>> included_recodes) {
		this.included_recodes = included_recodes;
	}
}

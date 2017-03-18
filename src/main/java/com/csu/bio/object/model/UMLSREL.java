package com.csu.bio.object.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * for the LncRNA collection
 * 
 * @author kayzhao
 */

@Document(collection = "umls2umls")
public class UMLSREL {
	/**
	 * common fields
	 */
	@Id
	@TextIndexed
	private String disease_id;

	@Field("aq")
	private List<String> allowed_qualifier;

	@Field("chd")
	private List<String> children;

	@Field("del")
	private List<String> delted_concept;

	@Field("par")
	private List<String> parent;

	@Field("qb")
	private List<String> qualified_by;

	@Field("rb")
	private List<String> broader;

	@Field("rl")
	private List<String> similar_or_alike;

	@Field("rn")
	private List<String> narrower;

	@Field("ro")
	private List<String> other_than;

	@Field("rq")
	private List<String> related_possobly_synonymous;

	@Field("ru")
	private List<String> related_unspecified;

	@Field("sib")
	private List<String> sibling;

	@Field("sy")
	private List<String> synonymy;

	@Field("xr")
	private List<String> not_related;

	public String getDisease_id() {
		return disease_id;
	}

	public void setDisease_id(String disease_id) {
		this.disease_id = disease_id;
	}

	public List<String> getAllowed_qualifier() {
		return allowed_qualifier;
	}

	public void setAllowed_qualifier(List<String> allowed_qualifier) {
		this.allowed_qualifier = allowed_qualifier;
	}

	public List<String> getChildren() {
		return children;
	}

	public void setChildren(List<String> children) {
		this.children = children;
	}

	public List<String> getDelted_concept() {
		return delted_concept;
	}

	public void setDelted_concept(List<String> delted_concept) {
		this.delted_concept = delted_concept;
	}

	public List<String> getParent() {
		return parent;
	}

	public void setParent(List<String> parent) {
		this.parent = parent;
	}

	public List<String> getQualified_by() {
		return qualified_by;
	}

	public void setQualified_by(List<String> qualified_by) {
		this.qualified_by = qualified_by;
	}

	public List<String> getBroader() {
		return broader;
	}

	public void setBroader(List<String> broader) {
		this.broader = broader;
	}

	public List<String> getSimilar_or_alike() {
		return similar_or_alike;
	}

	public void setSimilar_or_alike(List<String> similar_or_alike) {
		this.similar_or_alike = similar_or_alike;
	}

	public List<String> getNarrower() {
		return narrower;
	}

	public void setNarrower(List<String> narrower) {
		this.narrower = narrower;
	}

	public List<String> getOther_than() {
		return other_than;
	}

	public void setOther_than(List<String> other_than) {
		this.other_than = other_than;
	}

	public List<String> getRelated_possobly_synonymous() {
		return related_possobly_synonymous;
	}

	public void setRelated_possobly_synonymous(List<String> related_possobly_synonymous) {
		this.related_possobly_synonymous = related_possobly_synonymous;
	}

	public List<String> getRelated_unspecified() {
		return related_unspecified;
	}

	public void setRelated_unspecified(List<String> related_unspecified) {
		this.related_unspecified = related_unspecified;
	}

	public List<String> getSibling() {
		return sibling;
	}

	public void setSibling(List<String> sibling) {
		this.sibling = sibling;
	}

	public List<String> getSynonymy() {
		return synonymy;
	}

	public void setSynonymy(List<String> synonymy) {
		this.synonymy = synonymy;
	}

	public List<String> getNot_related() {
		return not_related;
	}

	public void setNot_related(List<String> not_related) {
		this.not_related = not_related;
	}
}

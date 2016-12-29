package com.csu.bio.object.po;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author kayzhao
 * @version 2016年12月27日
 */

@Document
public class Concept {

	@Field("lui")
	private String unique_identifier_for_term;

	@Field("aui")
	private String unique_identifier_for_atom;

	@Field("term_status")
	private String term_status;

	@Field("atom_status")
	private String atom_status;

	@Field("sui")
	private String unique_identifier_for_string;

	@Field("string_type")
	private String string_type;

	@Field("suppress")
	private String suppressible_flag;

	@Field("cvf")
	private String content_view_flag;

	@Field("source_dui")
	private String source_asserted_descriptor_identifier;

	@Field("source_cui")
	private String source_asserted_concept_identifier;

	@Field("source_term_type")
	private String source_term_type;

	@Field("source_restriction_level")
	private int source_restriction_level;

	public String getUnique_identifier_for_term() {
		return unique_identifier_for_term;
	}

	public void setUnique_identifier_for_term(String unique_identifier_for_term) {
		this.unique_identifier_for_term = unique_identifier_for_term;
	}

	public String getUnique_identifier_for_atom() {
		return unique_identifier_for_atom;
	}

	public void setUnique_identifier_for_atom(String unique_identifier_for_atom) {
		this.unique_identifier_for_atom = unique_identifier_for_atom;
	}

	public String getTerm_status() {
		return term_status;
	}

	public void setTerm_status(String term_status) {
		this.term_status = term_status;
	}

	public String getAtom_status() {
		return atom_status;
	}

	public void setAtom_status(String atom_status) {
		this.atom_status = atom_status;
	}

	public String getUnique_identifier_for_string() {
		return unique_identifier_for_string;
	}

	public void setUnique_identifier_for_string(String unique_identifier_for_string) {
		this.unique_identifier_for_string = unique_identifier_for_string;
	}

	public String getString_type() {
		return string_type;
	}

	public void setString_type(String string_type) {
		this.string_type = string_type;
	}

	public String getSuppressible_flag() {
		return suppressible_flag;
	}

	public void setSuppressible_flag(String suppressible_flag) {
		this.suppressible_flag = suppressible_flag;
	}

	public String getContent_view_flag() {
		return content_view_flag;
	}

	public void setContent_view_flag(String content_view_flag) {
		this.content_view_flag = content_view_flag;
	}

	public String getSource_asserted_descriptor_identifier() {
		return source_asserted_descriptor_identifier;
	}

	public void setSource_asserted_descriptor_identifier(String source_asserted_descriptor_identifier) {
		this.source_asserted_descriptor_identifier = source_asserted_descriptor_identifier;
	}

	public String getSource_asserted_concept_identifier() {
		return source_asserted_concept_identifier;
	}

	public void setSource_asserted_concept_identifier(String source_asserted_concept_identifier) {
		this.source_asserted_concept_identifier = source_asserted_concept_identifier;
	}

	public String getSource_term_type() {
		return source_term_type;
	}

	public void setSource_term_type(String source_term_type) {
		this.source_term_type = source_term_type;
	}

	public int getSource_restriction_level() {
		return source_restriction_level;
	}

	public void setSource_restriction_level(int source_restriction_level) {
		this.source_restriction_level = source_restriction_level;
	}
}

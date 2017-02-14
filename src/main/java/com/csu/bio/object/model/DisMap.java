package com.csu.bio.object.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * for the LncRNA collection
 * 
 * @author kayzhao
 */

@Document(collection = "dismap")
public class DisMap {
	/**
	 * common fields
	 */
	@Id
	private String disease_id;

	@Field("doid")
	private List<String> doid;

	@Field("hp")
	private List<String> hp;

	@Field("icd10cm")
	private List<String> icd10cm;

	@Field("icd9cm")
	private List<String> icd9cm;

	@Field("kegg")
	private List<String> kegg;

	@Field("mesh")
	private List<String> mesh;

	@Field("omim")
	private List<String> omim;

	@Field("orphanet")
	private List<String> orphanet;

	@Field("umls_cui")
	private List<String> umls_cui;

	@Field("other")
	private List<String> other_id;

	public String getDisease_id() {
		return disease_id;
	}

	public void setDisease_id(String disease_id) {
		this.disease_id = disease_id;
	}

	public List<String> getDoid() {
		return doid;
	}

	public void setDoid(List<String> doid) {
		this.doid = doid;
	}

	public List<String> getHpo() {
		return hp;
	}

	public void setHpo(List<String> hp) {
		this.hp = hp;
	}

	public List<String> getIcd10cm() {
		return icd10cm;
	}

	public void setIcd10cm(List<String> icd10cm) {
		this.icd10cm = icd10cm;
	}

	public List<String> getIcd9cm() {
		return icd9cm;
	}

	public void setIcd9cm(List<String> icd9cm) {
		this.icd9cm = icd9cm;
	}

	public List<String> getKegg() {
		return kegg;
	}

	public void setKegg(List<String> kegg) {
		this.kegg = kegg;
	}

	public List<String> getMesh() {
		return mesh;
	}

	public void setMesh(List<String> mesh) {
		this.mesh = mesh;
	}

	public List<String> getOmim() {
		return omim;
	}

	public void setOmim(List<String> omim) {
		this.omim = omim;
	}

	public List<String> getOrphanet() {
		return orphanet;
	}

	public void setOrphanet(List<String> orphanet) {
		this.orphanet = orphanet;
	}

	public List<String> getUmls_cui() {
		return umls_cui;
	}

	public void setUmls_cui(List<String> umls_cui) {
		this.umls_cui = umls_cui;
	}

	public List<String> getOther_id() {
		return other_id;
	}

	public void setOther_id(List<String> other_id) {
		this.other_id = other_id;
	}
}

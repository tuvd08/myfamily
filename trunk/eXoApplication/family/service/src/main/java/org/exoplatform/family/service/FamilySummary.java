package org.exoplatform.family.service;

import java.util.List;

public class FamilySummary {
	private String id;
	private List<String> familyId;
	private List<String> familyName;
	
	public FamilySummary() {
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}

	public List<String> getFamilyId() {
		return familyId;
	}
	public void setFamilyId(List<String> familyId) {
		this.familyId = familyId;
	}

	public List<String> getFamilyName() {
		return familyName;
	}
	public void setFamilyName(List<String> familyName) {
		this.familyName = familyName;
	}

}

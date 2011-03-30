package org.exoplatform.family.service;

import java.util.ArrayList;
import java.util.List;

import org.exoplatform.family.service.impl.FamilyNodeTypes;

public class FamilySummary {
	private String id;
	private List<String> familyId;
	private List<String> familyName;
	private String isAdmin = "false";
	
	public FamilySummary() {
		setId("Empty");
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getIsAdmin() {
		return isAdmin;
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

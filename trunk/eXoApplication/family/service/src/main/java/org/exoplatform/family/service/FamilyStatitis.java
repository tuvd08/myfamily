package org.exoplatform.family.service;

public class FamilyStatitis {
  public static final String STATITIS_ID = "familyStatitis";
// thong ke 3 doi
  private String parentId;
  private String parentPatch;
  private long memberChildren; // con
  private long memberGrandchildren; // chau
  private long MemberDescendants; // chat
  private long generationCount; // tong so the he tinh tu gia dinh nay den the he cuoi cung.
  private long allMemberCount; // tong so con chau chat chut chit ...
  private long allBoyMemberCount; // tong so nam trong tong so con chau chat chut chit.

  public FamilyStatitis() {
  }

  public FamilyStatitis(String parentId) {
    this.parentId = parentId;
  }
  
  /**
   * @return the parentId
   */
  public String getParentId() {
    return parentId;
  }

  /**
   * @param parentId the parentId to set
   */
  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  /**
   * @return the parentPatch
   */
  public String getParentPatch() {
    return parentPatch;
  }

  /**
   * @param parentPatch the parentPatch to set
   */
  public void setParentPatch(String parentPatch) {
    this.parentPatch = parentPatch;
  }

  /**
   * @return the memberChildren
   */
  public long getMemberChildren() {
    return memberChildren;
  }
  /**
   * @param memberChildren the memberChildren to set
   */
  public void setMemberChildren(long memberChildren) {
    this.memberChildren = memberChildren;
  }
  /**
   * @return the memberGrandchildren
   */
  public long getMemberGrandchildren() {
    return memberGrandchildren;
  }
  /**
   * @param memberGrandchildren the memberGrandchildren to set
   */
  public void setMemberGrandchildren(long memberGrandchildren) {
    this.memberGrandchildren = memberGrandchildren;
  }
  /**
   * @return the memberDescendants
   */
  public long getMemberDescendants() {
    return MemberDescendants;
  }
  /**
   * @param memberDescendants the memberDescendants to set
   */
  public void setMemberDescendants(long memberDescendants) {
    MemberDescendants = memberDescendants;
  }
  /**
   * @return the generationCount
   */
  public long getGenerationCount() {
    return generationCount;
  }
  /**
   * @param generationCount the generationCount to set
   */
  public void setGenerationCount(long generationCount) {
    this.generationCount = generationCount;
  }
  /**
   * @return the allMemberCount
   */
  public long getAllMemberCount() {
    return allMemberCount;
  }
  /**
   * @param allMemberCount the allMemberCount to set
   */
  public void setAllMemberCount(long allMemberCount) {
    this.allMemberCount = allMemberCount;
  }
  /**
   * @return the allBoyMemberCount
   */
  public long getAllBoyMemberCount() {
    return allBoyMemberCount;
  }
  /**
   * @param allBoyMemberCount the allBoyMemberCount to set
   */
  public void setAllBoyMemberCount(long allBoyMemberCount) {
    this.allBoyMemberCount = allBoyMemberCount;
  }
}

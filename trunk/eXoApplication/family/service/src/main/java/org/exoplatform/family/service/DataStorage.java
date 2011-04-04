package org.exoplatform.family.service;

import java.util.List;


public interface DataStorage {
  public Family getFamily(String familyId) throws Exception;
  void saveFamily(Family family, boolean isNew) throws Exception;
  public Family removeFamily(String familyId) throws Exception;
  public List<Family>getListFamily() throws Exception ;
  public FamilySummary getFamilySummary() throws Exception ;
}

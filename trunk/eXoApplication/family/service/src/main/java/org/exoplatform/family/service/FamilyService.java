/*
 * Copyright (C) 2003-2011 by Mr. Vu Duy Tu.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see<http://www.gnu.org/licenses/>.
 */
package org.exoplatform.family.service;

import java.util.List;

/**
 * Created by the Yen Tu
 * Author : Vu Duy Tu
 *          duytucntt@gmail.com
 * 10:13:28 Apr 1, 2011
 */
public interface FamilyService {
  
  Family getFamily(String familyId) throws Exception;

  /**
   * Save family.
   * @param family the family
   * @param isNew is the new
   * @param isVote is the vote
   * @throws Exception the exception
   */
  void saveFamily(Family family, boolean isNew) throws Exception;

  /**
   * Removes the family.
   * 
   * @param familyId
   * @return the family
   * @throws Exception the exception
   */
  public Family removeFamily(String familyId) throws Exception;

  public List<Family>getPageFamily() throws Exception ;
  
  /**
   * Gets the family summary.
   * 
   * @param groupOfUser group
   * @return the family summary
   * @throws Exception the exception
   */
  public FamilySummary getFamilySummary() throws Exception ;
}

/***************************************************************************
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
 ***************************************************************************/
package org.exoplatform.family.service ;

import java.util.Calendar;

import org.exoplatform.services.jcr.util.IdGenerator;
/**
 * Created by The eXo Platform SARL
 * Author : Vu Duy Tu
 * 				duytucntt@gmail.com
 * Apr 1, 2011
 */
public class Family { 
  public static final String FAMILY = "family";
  
	private String id;
	private String parentPath;
	private String oldParentPath;
// thong tin chung
	private long generationIndex;
	private String owner;
// ten the hien tren cay gia pha. Hien theo ten nguoi lien quan truc tiep den cay gia pha.
	private String name;
// mo ta chung ve gia dinh
	private String discription;
// lien ket den gia dinh cha
	private String[] relations;
// la con nuoi hay ko
	private boolean isFosterchild;
	
	
// trang thai
	private Calendar createdDate;
	private Calendar modifiedDate;
	private String modifiedBy;
	private boolean isClosed = false ;
	public Family() {
		id = FAMILY + IdGenerator.generate() ;
	}

	public Family(String id) {
	  this.id = id;
	}

	/**
   * @return the id
   */
  public String getId() {
    return id;
  }
  /**
   * @param id the id to set
   */
  public void setId(String id) {
    this.id = id;
  }
  /**
   * @return the parentPath
   */
  public String getParentPath() {
    return parentPath;
  }
  /**
   * @param parentPath the parentPath to set
   */
  public void setParentPath(String parentPath) {
    this.parentPath = parentPath;
  }
  /**
   * @return the oldParentPath
   */
  public String getOldParentPath() {
    return oldParentPath;
  }
  /**
   * @param oldParentPath the oldParentPath to set
   */
  public void setOldParentPath(String oldParentPath) {
    this.oldParentPath = oldParentPath;
  }
  /**
   * @return the generationIndex
   */
  public long getGenerationIndex() {
    return generationIndex;
  }
  /**
   * @param generationIndex the generationIndex to set
   */
  public void setGenerationIndex(long generationIndex) {
    this.generationIndex = generationIndex;
  }
  /**
   * @return the owner
   */
  public String getOwner() {
    return owner;
  }
  /**
   * @param owner the owner to set
   */
  public void setOwner(String owner) {
    this.owner = owner;
  }
  /**
   * @return the name
   */
  public String getName() {
    return name;
  }
  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }
  /**
   * @return the discription
   */
  public String getDiscription() {
    return discription;
  }
  /**
   * @param discription the discription to set
   */
  public void setDiscription(String discription) {
    this.discription = discription;
  }
  /**
   * @return the relations
   */
  public String[] getRelations() {
    return relations;
  }
  /**
   * @param relations the relations to set
   */
  public void setRelations(String[] relations) {
    this.relations = relations;
  }
  /**
   * @return the isFosterchild
   */
  public boolean isFosterchild() {
    return isFosterchild;
  }
  /**
   * @param isFosterchild the isFosterchild to set
   */
  public void setFosterchild(boolean isFosterchild) {
    this.isFosterchild = isFosterchild;
  }
  /**
   * @return the createdDate
   */
  public Calendar getCreatedDate() {
    return createdDate;
  }
  /**
   * @param createdDate the createdDate to set
   */
  public void setCreatedDate(Calendar createdDate) {
    this.createdDate = createdDate;
  }
  /**
   * @return the modifiedDate
   */
  public Calendar getModifiedDate() {
    return modifiedDate;
  }
  /**
   * @param modifiedDate the modifiedDate to set
   */
  public void setModifiedDate(Calendar modifiedDate) {
    this.modifiedDate = modifiedDate;
  }
  /**
   * @return the modifiedBy
   */
  public String getModifiedBy() {
    return modifiedBy;
  }
  /**
   * @param modifiedBy the modifiedBy to set
   */
  public void setModifiedBy(String modifiedBy) {
    this.modifiedBy = modifiedBy;
  }
  /**
   * @return the isClosed
   */
  public boolean isClosed() {
    return isClosed;
  }
  /**
   * @param isClosed the isClosed to set
   */
  public void setClosed(boolean isClosed) {
    this.isClosed = isClosed;
  }
	
}














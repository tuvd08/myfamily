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
  public static String FAMILY = "family";
	private String id;
	private String parentPath;
	private String oldParentPath;
	private String owner;
	private Calendar createdDate;
	private Calendar modifiedDate;
	private String modifiedBy;
	private boolean isClosed = false ;
	public Family() {
		id = FAMILY + IdGenerator.generate() ;
	}
	
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	
	public String getParentPath() { return parentPath; }
	public void setParentPath(String path) { this.parentPath = path; }
	
	public void setOldParentPath(String oldParentPath) { this.oldParentPath = oldParentPath;}
	public String getOldParentPath() { return oldParentPath; }

	public String getOwner(){return owner;}
	public void setOwner(String owner){this.owner = owner;}
	
	public Calendar getCreatedDate(){return createdDate;}
	public void setCreatedDate(Calendar createdDate){this.createdDate = createdDate;}
	
	public String getModifiedBy(){return modifiedBy;}
	public void setModifiedBy(String modifiedBy){this.modifiedBy = modifiedBy;}
	
	public Calendar getModifiedDate(){return modifiedDate;}
	public void setModifiedDate(Calendar modifiedDate){this.modifiedDate = modifiedDate;}
	
	public boolean getIsClosed() { return isClosed;}
	public void setIsClosed(boolean isClosed) { this.isClosed = isClosed;}
	
	
}














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
package org.exoplatform.family.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.PathNotFoundException;
import javax.jcr.Session;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;

import org.exoplatform.family.service.DataStorage;
import org.exoplatform.family.service.Family;
import org.exoplatform.family.service.FamilySummary;
import org.exoplatform.ks.common.jcr.KSDataLocation;
import org.exoplatform.ks.common.jcr.PropertyReader;
import org.exoplatform.ks.common.jcr.SessionManager;
import org.exoplatform.services.jcr.ext.common.SessionProvider;
import org.exoplatform.services.jcr.ext.hierarchy.NodeHierarchyCreator;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;

/**
 * Created by the Yen Tu
 * Author : Vu Duy Tu
 *          duytucntt@gmail.com
 * 10:13:28 PM Apr 1, 2011 
 */

public class JCRDataStorage implements	DataStorage, FamilyNodeTypes {
	private static final Log log = ExoLogger.getLogger(JCRDataStorage.class);
	private NodeHierarchyCreator nodeHierarchyCreator_;
	private SessionManager sessionManager;
	KSDataLocation dataLocator;

  public JCRDataStorage(NodeHierarchyCreator nodeHierarchyCreator, KSDataLocation dataLocator) {
    nodeHierarchyCreator_ = nodeHierarchyCreator;
    this.dataLocator = dataLocator;
    this.sessionManager = dataLocator.getSessionManager();
  }

	public Node getNodeByPath(String nodePath, SessionProvider sessionProvider) throws Exception {
    return (Node) getSession(sessionProvider).getItem(nodePath);
  }
  
  @SuppressWarnings("deprecation")
	public Session getSession(SessionProvider sprovider) throws Exception{
  	return sessionManager.getSession(sprovider);
  }
  
  private Node getPublicFamilyHomeNode(SessionProvider sProvider) throws Exception {
  	return null;
  }

  private Node getFamilyAppHomeNode(SessionProvider sProvider) throws Exception {
  	Node privateApp = getNodeByPath(nodeHierarchyCreator_.getJcrPath("groupsPath"), sProvider);
  	return privateApp;
  }

  private Node getParentNode(SessionProvider sProvider, String parentId) throws Exception {
  	return null;
  }
  
  private Node getNode(Node nodeApp, String ids) throws Exception {
    Node node = null;
    if(ids.indexOf("/") < 0) node = nodeApp.addNode(ids);
    else {
      String []ar = ids.split("/");
      for (int i = 0; i < ar.length; i++) {
        try {
          node = nodeApp.getNode(ar[i]);
        } catch (PathNotFoundException e) {
          node = nodeApp.addNode(ar[i], JCRTYPE.NT_UNSTRUCTURED);
        }
        nodeApp = node;
      }
      if(nodeApp.isNew()) nodeApp.getSession().save();
      else nodeApp.getParent().save();
    }
    return node;
  }
  
	public Family getFamily(String familyId) throws Exception {
		SessionProvider sProvider = SessionProvider.createSystemProvider();
		try {
		} catch (Exception e) {
		} finally {
			sProvider.close();
		}
		return null;	
	}

	private Node getNodeById(SessionProvider sProvider, String familyId) throws Exception {
		QueryManager qm = getSession(sProvider).getWorkspace().getQueryManager();
		StringBuffer queryString = new StringBuffer(JCRTYPE.JCR_ROOT);
		queryString.append("//element(*,").append(EXO_FAMILY).append(")").append("[fn:name() = '").append(familyId).append("']");
		Query query = qm.createQuery(queryString.toString(), Query.XPATH);
		QueryResult result = query.execute();
		NodeIterator iter = result.getNodes();
		if(iter.getSize() > 0) return iter.nextNode();
		return null;
	}
	
	private Family getFamilyNode(Node familyNode) throws Exception {
		if(familyNode == null) return null;
		Family familyNew = new Family();
		familyNew.setId(familyNode.getName());
		familyNew.setParentPath(familyNode.getParent().getPath());
		PropertyReader reader = new PropertyReader(familyNode);
		familyNew.setOwner(reader.string(EXO_OWNER));
		familyNew.setModifiedBy(reader.string(EXO_MODIFIED_BY));
		familyNew.setCreatedDate(reader.calendar(EXO_CREATED_DATE));
		familyNew.setModifiedDate(reader.calendar(EXO_MODIFIED_DATE));
		//...
		return familyNew ;
	}
	
	public List<Family>getListFamily() throws Exception {
		SessionProvider sProvider = SessionProvider.createSystemProvider();
		List<Family> listFamily = new ArrayList<Family>();
		try {
		} catch (Exception e) {
			log.error("Failed to get page family",e);
		} finally {
			sProvider.close();
		}
		return listFamily;
	}
	
	public FamilySummary getFamilySummary() throws Exception {
		SessionProvider sProvider = SessionProvider.createSystemProvider();
		FamilySummary family = new FamilySummary();
		try {
		} catch (Exception e) {
			log.error("Failed to get family summary", e);
		} finally {
			sProvider.close();
		}
		return family;
		
	}
	
	
	public Family removeFamily(String familyId) throws Exception {
		SessionProvider sProvider = SessionProvider.createSystemProvider();
		Family family = null;
		try {
		} catch (Exception e) {
			log.error("Failed to remove family: "+familyId, e);
		} finally {
			sProvider.close();
		}
		return family;
	}

	public void saveFamily(Family family, boolean isNew) throws Exception {
		SessionProvider sProvider = SessionProvider.createSystemProvider();
		try {
		} catch (Exception e) {
			log.error("Failed to save family: " + family.getId(), e);
		} finally {
			sProvider.close();
		}
		
	}

	
	
  
}

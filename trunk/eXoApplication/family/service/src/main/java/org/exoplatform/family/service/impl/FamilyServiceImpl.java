/*
 * Copyright (C) 2003-2007 eXo Platform SAS.
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

import java.util.List;

import org.exoplatform.container.component.ComponentPlugin;
import org.exoplatform.container.xml.InitParams;
import org.exoplatform.ks.common.jcr.KSDataLocation;
import org.exoplatform.management.jmx.annotations.NameTemplate;
import org.exoplatform.management.jmx.annotations.Property;
import org.exoplatform.family.service.Family;
import org.exoplatform.family.service.FamilyService;
import org.exoplatform.family.service.FamilySummary;
import org.exoplatform.services.jcr.ext.hierarchy.NodeHierarchyCreator;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.picocontainer.Startable;

@NameTemplate(@Property(key="service", value="family"))
public class FamilyServiceImpl implements Startable, FamilyService {
	private JCRDataStorage            storage_;
	private KSDataLocation dataLocator;
	private static final Log log = ExoLogger.getLogger(FamilyServiceImpl.class);
	
  public FamilyServiceImpl(InitParams params, KSDataLocation locator, NodeHierarchyCreator nodeHierarchyCreator) throws Exception {
  	this.dataLocator = locator;
  	storage_ = new JCRDataStorage(nodeHierarchyCreator, dataLocator);
  }
  
  public void start() {
  	try {
  		log.info("initializing Family default data...");
		} catch (Exception e) {
			log.error("Failed to initializing default data for family: ", e);
		}
  }

	public void stop() {}

	public Family getFamily(String familyId) throws Exception {
		return storage_.getFamily(familyId);
	}

	public Family removeFamily(String familyId) throws Exception {
		return storage_.removeFamily(familyId);
	}

	public void saveFamily(Family family, boolean isNew) throws Exception {
		storage_.saveFamily(family, isNew);
	}

	public List<Family> getPageFamily() throws Exception {
		return storage_.getPageFamily();
	}

	public FamilySummary getFamilySummary() throws Exception {
		return storage_.getFamilySummary();
	}

  
}

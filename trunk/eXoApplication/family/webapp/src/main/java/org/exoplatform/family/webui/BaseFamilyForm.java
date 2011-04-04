/*
 * Copyright (C) 2011-2011 by Mr. Vu Duy Tu.
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
package org.exoplatform.family.webui;

import org.exoplatform.container.ExoContainerContext;
import org.exoplatform.family.service.FamilyService;
import org.exoplatform.ks.common.webui.BaseUIForm;
import org.exoplatform.webui.core.UIComponent;

/**
 * Base class for UIForm used in family application. Provides convenience methods to access the service
 * 
 */
public class BaseFamilyForm extends BaseUIForm {

	private FamilyService familyService;

	/**
	 * Get a reference to the forum service
	 * 
	 * @return
	 */
	protected FamilyService getfamilyService() {
		if (familyService == null) {
			familyService = (FamilyService) ExoContainerContext.getCurrentContainer().getComponentInstanceOfType(FamilyService.class);
		}
		return familyService;
	}

	/**
	 * Set family service (used by unit tests)
	 * 
	 * @param familyService
	 */
	protected void setFamilyService(FamilyService familyService) {
		this.familyService = familyService;
	}

	protected <T extends UIComponent> T openPopup(Class<T> componentType, String popupId, int width, int height) throws Exception {
		UIFamilyPortlet familyPortlet = getAncestorOfType(UIFamilyPortlet.class);
		return openPopup(familyPortlet, componentType, popupId, width, height);
	}

	protected <T extends UIComponent> T openPopup(Class<T> componentType, int width, int height) throws Exception {
		UIFamilyPortlet familyPortlet = getAncestorOfType(UIFamilyPortlet.class);
		return openPopup(familyPortlet, componentType, width, height);
	}

	protected <T extends UIComponent> T openPopup(Class<T> componentType, int width) throws Exception {
		return openPopup(componentType, width, 0);
	}

	protected <T extends UIComponent> T openPopup(Class<T> componentType, String popupId, int width) throws Exception {
		return openPopup(componentType, popupId, width, 0);
	}
}

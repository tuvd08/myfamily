/***************************************************************************
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
 ***************************************************************************/
package org.exoplatform.family.webui;

import javax.portlet.PortletMode;

import org.exoplatform.ks.common.webui.UIPopupAction;
import org.exoplatform.web.application.RequestContext;
import org.exoplatform.webui.application.WebuiApplication;
import org.exoplatform.webui.application.WebuiRequestContext;
import org.exoplatform.webui.application.portlet.PortletRequestContext;
import org.exoplatform.webui.config.annotation.ComponentConfig;
import org.exoplatform.webui.core.UIPopupMessages;
import org.exoplatform.webui.core.UIPortletApplication;
import org.exoplatform.webui.core.lifecycle.UIApplicationLifecycle;

/**
 * Created by The by Mr. Vu Duy Tu 
 * Author : Vu Duy Tu 
 *          duytucntt@gmail.com 
 * Apr 1, 2011
 */

@ComponentConfig(
		lifecycle = UIApplicationLifecycle.class,
		template = "app:/templates/family/webui/UIFamilyPortlet.gtmpl"
)
public class UIFamilyPortlet extends UIPortletApplication {
	private boolean isAdmin = false;
	private String userId = "";

	public UIFamilyPortlet() throws Exception {
		addChild(UIPopupAction.class, null, "UIFamilyPopupAction");
	}

	public void processRender(WebuiApplication app, WebuiRequestContext context) throws Exception {
		PortletRequestContext portletReqContext = (PortletRequestContext) context;
		if (portletReqContext.getApplicationMode() == PortletMode.VIEW) {
		} else if (portletReqContext.getApplicationMode() == PortletMode.EDIT) {
		}
		super.processRender(app, context);
	}

	public void renderPopupMessages() throws Exception {
		UIPopupMessages popupMess = getUIPopupMessages();
		if (popupMess == null)
			return;
		WebuiRequestContext context = RequestContext.getCurrentInstance();
		popupMess.processRender(context);
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public String getUserId() {
		return userId;
	}

	public void cancelAction() throws Exception {
		WebuiRequestContext context = RequestContext.getCurrentInstance();
		UIPopupAction popupAction = getChild(UIPopupAction.class);
		popupAction.deActivate();
		context.addUIComponentToUpdateByAjax(popupAction);
	}

}

/***************************************************************************
 * Copyright (C) 2003-2007 by Mr. Vu Duy Tu.
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
/**
 * 
 */

package org.exoplatform.family;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.lang.StringUtils;
import org.exoplatform.portal.application.PortalRequestContext;
import org.exoplatform.portal.webui.util.Util;

/**
 * Created by The eXo Platform SARL 
 * Author : Vu Duy Tu 
 *          duytucntt@gmail.com 
 * Apr 1, 2011
 */

public class Utils {
	public static final String FAMILY = "family".intern();

	public static final int MAXSIGNATURE = 300;
	public static final int MAXTITLE = 100;
	public static final long MAXMESSAGE = 10000;

	public static String getFormatDate(String format, Date myDate) {
		/*
		 * h,hh,H, m, mm, d, dd, DDD, DDDD, M, MM, MMM, MMMM, yy, yyyy
		 */
		if (myDate == null)
			return "";
		if (!isEmpty(format)) {
			if (format.indexOf("DDDD") >= 0)
				format = format.replaceAll("DDDD", "EEEE");
			if (format.indexOf("DDD") >= 0)
				format = format.replaceAll("DDD", "EEE");
		}
		PortalRequestContext portalContext = Util.getPortalRequestContext();
		Locale locale = new Locale(portalContext.getLocale().getLanguage(), portalContext.getLocale().getCountry());
		Format formatter = new SimpleDateFormat(format, locale);
		return formatter.format(myDate);
	}

	public static boolean isValidEmailAddresses(String addressList) throws Exception {
		if (isEmpty(addressList))
			return true;
		addressList = StringUtils.remove(addressList, " ");
		addressList = StringUtils.replace(addressList, ";", ",");
		try {
			InternetAddress[] iAdds = InternetAddress.parse(addressList, true);
			String emailRegex = "[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[_A-Za-z0-9-.]+\\.[A-Za-z]{2,5}";
			for (int i = 0; i < iAdds.length; i++) {
				if (!iAdds[i].getAddress().matches(emailRegex))
					return false;
			}
		} catch (AddressException e) {
			return false;
		}
		return true;
	}

	public static boolean isEmpty(String str) {
		if (str == null || str.trim().length() == 0)
			return true;
		else
			return false;
	}

	public static String removeZeroFirstNumber(String str) {
		if (!isEmpty(str)) {
			str = str.trim();
			StringBuilder s = new StringBuilder();
			int i = 0;
			while ((i + 1) < str.length() && (str.charAt(i) == '0' || str.charAt(i) == ' ')) {
				s.append(str.charAt(i));
				++i;
			}
			str = str.replaceFirst(s.toString(), "");
		}
		return str;
	}

	public static String getSubString(String str, int max) {
		if (!isEmpty(str)) {
			int l = str.length();
			if (l > max) {
				str = str.substring(0, max);
				int space = str.lastIndexOf(" ");
				if (space > (max - 6))
					str = str.substring(0, space) + "...";
				else
					str = str + "...";
			}
		}
		return str;
	}

	public static String[] getColor() {
		return new String[] { "blue", "DarkGoldenRod", "green", "yellow", "BlueViolet", "orange", "darkBlue", "IndianRed", "DarkCyan", "lawnGreen" };
	}

	public static String unCodeHTML(String s) {
		if (s != null && s.trim().length() > 0) {
			s = s.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&#39", "'");
		} else
			s = "";
		return s;
	}

	public static String enCodeHTML(String s) {
		StringBuffer buffer = new StringBuffer();
		if (s != null) {
			s = s.replaceAll("(<p>((\\&nbsp;)*)(\\s*)?</p>)|(<p>((\\&nbsp;)*)?(\\s*)</p>)", "<br/>").trim();
			s = s.replaceFirst("(<br/>)*", "");
			s = s.replaceAll("(\\w|\\$)(>?,?\\.?\\*?\\!?\\&?\\%?\\]?\\)?\\}?)(<br/><br/>)*", "$1$2");
			for (int j = 0; j < s.trim().length(); j++) {
				char c = s.charAt(j);
				if ((int) c == 60) {
					buffer.append("&lt;");
				} else if ((int) c == 62) {
					buffer.append("&gt;");
				} else if (c == '\'') {
					buffer.append("&#39");
				} else {
					buffer.append(c);
				}
			}
		}
		return buffer.toString();
	}


	public static Calendar getGreenwichMeanTime() {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setLenient(false);
		int gmtoffset = calendar.get(Calendar.DST_OFFSET) + calendar.get(Calendar.ZONE_OFFSET);
		calendar.setTimeInMillis(System.currentTimeMillis() - gmtoffset);
		return calendar;
	}
}

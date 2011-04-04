/*
 * Copyright (C) 2011-2011 by Mr. Vu Duy Tu .
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see<http://www.gnu.org/licenses/>.
 */
package org.exoplatform.family.service;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by the Yen Tu
 * Author : Vu Duy Tu
 *          duytucntt@gmail.com
 * 10:13:28 PM - Apr 4, 2011  
 */
public class Utils {

  public static Calendar getGreenwichMeanTime() {
    Calendar calendar = GregorianCalendar.getInstance();
    calendar.setLenient(false);
    int gmtoffset = calendar.get(Calendar.DST_OFFSET) + calendar.get(Calendar.ZONE_OFFSET);
    calendar.setTimeInMillis(System.currentTimeMillis() - gmtoffset);
    return calendar;
  }
  
  public static boolean isEmpty(String s) {
    return (s == null || s.trim().length() <= 0)?true:false;
  }
}

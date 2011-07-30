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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see<http://www.gnu.org/licenses/>.
 */
package org.exoplatform.family.service.impl;

public interface FamilyNodeTypes {

  public static final String EXO_ID                   = "exo:id";

  public static final String EXO_SEX                  = "exo:sex";

  public static final String EXO_NAME                 = "exo:name";

  public static final String EXO_CITE                 = "exo:cite";

  public static final String EXO_NOTE                 = "exo:note";

  public static final String EXO_INFO                 = "exo:info";

  public static final String EXO_OWNER                = "exo:owner";

  public static final String EXO_FAMILY               = "exo:family";

  public static final String EXO_MEMBER               = "exo:member";

  public static final String EXO_DETAIL               = "exo:detail";

  public static final String EXO_DIED_DAY             = "exo:diedDay";

  public static final String EXO_HISTORY              = "exo:history";

  public static final String EXO_COMMENT              = "exo:comment";

  public static final String EXO_BIRTH_DAY            = "exo:birthDay";

  public static final String EXO_CITE_NOTE            = "exo:citeNote";

  public static final String EXO_FIRS_NAME            = "exo:firsName";

  public static final String EXO_IS_ACTIVE            = "exo:isActive";

  public static final String EXO_FULL_NAME            = "exo:fullName";

  public static final String EXO_CITE_DATE            = "exo:citeDate";

  public static final String EXO_USER_NOTE            = "exo:userNote";

  public static final String EXO_FILE_NAME            = "exo:fileName";

  public static final String EXO_USER_NAME            = "exo:userName";

  public static final String EXO_GENEALOGY            = "exo:genealogy";

  public static final String EXO_EXTRA_WIFE           = "exo:extraWife";

  public static final String EXO_HAS_FAMILY           = "exo:hasFamily";

  public static final String EXO_RELATIVES            = "exo:relatives";

  public static final String EXO_FAMILY_USER          = "exo:familyUser";

  public static final String EXO_FAMILY_HOME          = "exo:familyHome";

  public static final String EXO_DESCIPTION           = "exo:desciption";

  public static final String EXO_MODIFIED_BY          = "exo:modifiedBy";

  public static final String EXO_UPLOAD_DATE          = "exo:uploadDate";

  public static final String EXO_FAMILY_NOTE          = "exo:familyNote";

  public static final String EXO_CITE_FAMILY          = "exo:citeFamily";

  public static final String EXO_FAMILY_ALBUM         = "exo:familyAlbum";

  public static final String EXO_FAMILY_ADMIN         = "exo:familyAdmin";

  public static final String EXO_CREATED_DATE         = "exo:createdDate";

  public static final String EXO_ANNOUNCEMENT         = "exo:announcement";

  public static final String EXO_MODIFIED_DATE        = "exo:modifiedDate";

  public static final String EXO_CITE_ALL_VALUES      = "exo:citeAllValues";

  public static final String EXO_IS_FOSTERCHILD       = "exo:isFosterchild";

  public static final String EXO_ALL_MEMBER_COUNT     = "exo:allMemberCount";

  public static final String EXO_FAMILY_NOTE_HOME     = "exo:familyNoteHome";

  public static final String EXO_FAMILY_STATITIS      = "exo:familyStatitis";

  public static final String EXO_CITE_FAMILY_HOME     = "exo:citeFamilyHome";

  public static final String EXO_FAMILY_ALBUM_HOME    = "exo:familyAlbumHome";

  public static final String EXO_FAMILY_ADMIN_HOME    = "exo:familyAdminHome";

  public static final String EXO_GENERATION_COUNT     = "exo:generationCount";

  public static final String EXO_GENERATION_INDEX     = "exo:generationIndex";

  public static final String EXO_FAMILY_ATTACHMENT    = "exo:familyAttachment";

  public static final String EXO_FAMILY_PUBLIC_HOME   = "exo:familyPublicHome";

  public static final String EXO_CITE_FOR_GENESLOGY   = "exo:citeForGeneslogy";

  public static final String EXO_ALL_BOY_MEMBER_COUNT = "exo:allBoyMemberCount";

  public static final String EXO_FAMILY_PRIVATE_HOME  = "exo:familyPrivateHome";

  public static final String EXO_GENEALOGY_ALBUM_HOME = "exo:genealogyAlbumHome";

  public static final String AT                       = "@";

  public static final String EMPTY_STR                = "";

  public interface JCRTYPE {

    public static final String TEXT_HTML         = "text/html";

    public static final String JCR_ROOT          = "/jcr:root";

    public static final String NT_UNSTRUCTURED   = "nt:unstructured";

    public static final String NT_FILE           = "nt:file";

    public static final String NT_RESOURCE       = "nt:resource";

    public static final String FN_NAME           = "fn:name()";

    public static final String JCR_CONTENT       = "jcr:content";

    public static final String JCR_MIME_TYPE     = "jcr:mimeType";

    public static final String JCR_LAST_MODIFIED = "jcr:lastModified";

    public static final String JCR_DATA          = "jcr:data";
  }

}

package org.exoplatform.family.service.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.exoplatform.container.ExoContainerContext;
import org.exoplatform.family.service.FamilyService;
import org.exoplatform.family.service.Utils;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.services.rest.resource.ResourceContainer;

@Path("private/ks/family")
public class FamilyWebservice implements ResourceContainer {
  private static final Log   log      = ExoLogger.getLogger(FamilyWebservice.class);

  final public static String APP_TYPE = "family".intern();

  public FamilyWebservice() {
  }

  @GET
  @Path("/viewfamily/{resourceid}")
  //
  @Produces(MediaType.APPLICATION_JSON)
  public Response viewFamily(@PathParam("resourceid") String familyId) throws Exception {
    CacheControl cacheControl = new CacheControl();
    cacheControl.setNoCache(true);
    cacheControl.setNoStore(true);
    FamilyService familyService = (FamilyService) ExoContainerContext.getCurrentContainer().getComponentInstanceOfType(FamilyService.class);
    if (!Utils.isEmpty(familyId)) {
      try {
       
      } catch (Exception e) {
        log.error("Can not get family by id: " + familyId, e);
      }
    }
    return Response.ok(null, MediaType.APPLICATION_JSON).cacheControl(cacheControl).build();
  }
}

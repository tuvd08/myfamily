eXo.require("eXo.projects.Module");
eXo.require("eXo.projects.Product");

function getModule(params) {
  var ws = params.ws;
  var portal = params.portal;
  var module = new Module();

  module.version = "${project.version}";
  module.relativeMavenRepo = "org/exoplatform/ks";
  module.relativeSRCRepo = "ks";
  module.name = "ks";
  
  var commonsVersion = "${org.exoplatform.commons.version}";

  module.commons = {};
  module.commons.extension = 
    new Project("org.exoplatform.commons", "exo.platform.commons.extension.webapp", "war", commonsVersion);
  module.commons.extension.deployName = "commons-extension";
  
  module.comet = {};
  module.comet.cometd =
    new Project("org.exoplatform.commons", "exo.platform.commons.comet.webapp", "war", commonsVersion).
    addDependency(new Project("org.mortbay.jetty", "cometd-bayeux", "jar", "${org.mortbay.jetty.cometd-bayeux.version}")).
    addDependency(new Project("org.mortbay.jetty", "jetty-util", "jar", "${org.mortbay.jetty.jetty-util.version}")).
    addDependency(new Project("org.mortbay.jetty", "cometd-api", "jar", "${org.mortbay.jetty.cometd-api.version}")).
    addDependency(new Project("org.exoplatform.commons", "exo.platform.commons.comet.service", "jar", commonsVersion));
  module.comet.cometd.deployName = "cometd";
  
  module.webuiExt = new Project("org.exoplatform.commons", "exo.platform.commons.webui.ext", "jar", commonsVersion);

  
  // KS

  // KS components
  module.component = {};
  module.component.common = new Project("org.exoplatform.ks", "exo.ks.component.common", "jar", module.version).
                            addDependency(new Project("org.exoplatform.commons", "exo.platform.commons.component", "jar", commonsVersion)).
                            addDependency(new Project("org.exoplatform.commons", "exo.platform.commons.webui", "jar", commonsVersion));
  module.component.rendering = new Project("org.exoplatform.ks", "exo.ks.component.rendering", "jar", module.version);
  module.component.bbcode = new Project("org.exoplatform.ks", "exo.ks.component.bbcode", "jar", module.version);

  // KS apps
  module.eXoApplication = {};
  module.eXoApplication.upgrade = new Project("org.exoplatform.commons", "exo.platform.commons.component.upgrade", "jar", commonsVersion).
    addDependency(new Project("org.exoplatform.commons", "exo.platform.commons.component.product", "jar", commonsVersion));
  module.eXoApplication.common = new Project("org.exoplatform.ks", "exo.ks.eXoApplication.common", "jar", module.version).
    addDependency(new Project("org.exoplatform.ks", "exo.ks.component.upgrade", "jar",  module.version));
  
  //FAMILY
  module.eXoApplication.family = 
    new Project("org.exoplatform.ks", "exo.ks.eXoApplication.family.webapp", "war", module.version).
    addDependency(new Project("org.exoplatform.ks", "exo.ks.eXoApplication.family.service", "jar",  module.version));
  module.eXoApplication.family.deployName = "family";

  // KS we resources and services
  module.web = {}
  module.web.ksResources = 
    new Project("org.exoplatform.ks", "exo.ks.web.ksResources", "war", module.version) ;

  // KS extension for tomcat
  module.extension = {};
  module.extension.webapp = 
    new Project("org.exoplatform.ks", "exo.ks.extension.webapp", "war", module.version);
  module.extension.webapp.deployName = "ks-extension";
   
  module.server = {}
  module.server.tomcat = {}
  module.server.tomcat.patch =
    new Project("org.exoplatform.ks", "exo.ks.server.tomcat.patch", "jar", module.version);
	
  module.server.jboss = {}
  module.server.jboss.patchear =
    new Project("org.exoplatform.ks", "exo.ks.server.jboss.patch-ear", "jar", module.version);
   
  // KS demo 
  module.demo = {};
  // demo portal
  module.demo.portal =
    new Project("org.exoplatform.ks", "exo.ks.demo.webapp", "war", module.version).
    addDependency(new Project("org.exoplatform.ks", "exo.ks.demo.config", "jar", module.version));
  module.demo.portal.deployName = "ksdemo";  
	
  module.demo.cometd=
    new Project("org.exoplatform.ks", "exo.ks.demo.cometd-war", "war", module.version);
  module.demo.cometd.deployName = "cometd-ksdemo";
	   
  // demo rest endpoint	   
  module.demo.rest =
    new Project("org.exoplatform.ks", "exo.ks.demo.rest-ksdemo", "war", module.version).
    addDependency(ws.frameworks.servlet);
  module.extension.deployName = "rest-ksdemo"; 
   
  return module;
}

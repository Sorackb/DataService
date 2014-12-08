package org.lucassouza.dataservice.controller.service;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.lucassouza.datamapper.model.businessrule.MappingRuleBR;

/**
 *
 * @author Lucas Souza [sorackb@gmail.com]
 */
public class ConfigurationLoaderServlet implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    MappingRuleBR.load();
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
  }
}

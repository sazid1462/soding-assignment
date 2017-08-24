package com.project.demo;

import io.swagger.config.Scanner;
import io.swagger.config.SwaggerConfig;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.config.DefaultJaxrsConfig;
import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.models.Info;
import io.swagger.models.Swagger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.ws.rs.core.Application;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class App extends Application
{
    public static void main( String[] args ) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        // Setup API resources
        ResourceConfig config = new ResourceConfig();
        config.packages("com.project.demo", "io.swagger.jaxrs.json", "io.swagger.jaxrs.listing");
        ServletHolder servlet = new ServletHolder(new ServletContainer(config));
        context.addServlet(servlet, "/api/*");
//
//        servlet.setInitOrder(2);
//        servlet.setInitParameter("com.sun.jersey.config.property.packages",
//                "com.project.demo;io.swagger.jaxrs.json;io.swagger.jaxrs.listing;");
//
//        // Setup Swagger servlet
        ServletHolder swaggerServlet = context.addServlet(DefaultJaxrsConfig.class, "/swagger-core");
        swaggerServlet.setInitOrder(1);
        swaggerServlet.setInitParameter("api.version", "1.0.0");

        // Setup Swagger-UI static resources
        String resourceBasePath = App.class.getResource("/swagger-ui").toExternalForm();
        context.setWelcomeFiles(new String[] {"index.html"});
        context.setResourceBase(resourceBasePath);
        context.addServlet(new ServletHolder(new DefaultServlet()), "/*");

        context.setContextPath("/");
        server.setHandler(context);

        server.start();
        server.join();
    }

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> set = new HashSet<Class<?>>();

        set.add(Resource.class);

        set.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        set.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        return set;
    }
}

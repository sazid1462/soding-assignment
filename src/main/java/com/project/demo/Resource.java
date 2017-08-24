package com.project.demo;

import com.google.gson.Gson;
import io.swagger.annotations.Api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Api(basePath = "/api", value = "/api", description = "") // Swagger
@Path("/")
public class Resource {

    @GET
    @Path("/resourceConfig")
    @Produces(MediaType.APPLICATION_JSON)
    public String resourceConfig() {
       return Constants.SWAGGER_JSON;
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public String listAll() {
        Gson g = new Gson();
        return g.toJson(DBHandler.getAllTasks());
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTask(@QueryParam("id") String id) {
        Gson g = new Gson();
        return g.toJson(DBHandler.getTask(id));
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String createTask(@FormParam("id") String id, @FormParam("name") String name, @FormParam("assignee") String assignee, @FormParam("reporter") String reporter) {
        TaskObject taskObject = new TaskObject();
        taskObject.id = id;
        taskObject.name = name;
        taskObject.assignee = assignee;
        taskObject.reporter = reporter;

        return "<h2>Created task " + DBHandler.createTask(taskObject) + "</h2>";
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String updateTask(@FormParam("id") String id, @FormParam("name") String name, @FormParam("assignee") String assignee, @FormParam("reporter") String reporter) {
        TaskObject taskObject = new TaskObject();
        taskObject.id = id;
        taskObject.name = name;
        taskObject.assignee = assignee;
        taskObject.reporter = reporter;

        return "<h2>Updated task " + DBHandler.updateTask(taskObject) + "</h2>";
    }

    @GET
    @Path("/delete")
    @Produces(MediaType.TEXT_HTML)
    public String updateTask(@QueryParam("id") String id) {
        return "<h2>Deleted task " + DBHandler.deleteTask(id) + "</h2>";
    }
}

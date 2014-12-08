package org.lucassouza.dataservice.controller.service;

import java.util.LinkedHashMap;
import java.util.Set;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.lucassouza.datamapper.model.businessrule.DataMapperBR;
import org.lucassouza.datamapper.type.RequestType;

/**
 *
 * @author Lucas Souza [sorackb@gmail.com]
 */
@Path("/resource")
public class ResourceSR {

  @GET
  @Path("/search/{resourceName}")
  public Response getList(@PathParam("resourceName") String resourceName, @Context UriInfo info) {
    Set<String> parameterNameList = info.getQueryParameters().keySet();
    LinkedHashMap<String, Object> parameterList = new LinkedHashMap<>();
    DataMapperBR dataMapperBR = new DataMapperBR();
    String responseJson;
    String errorMessage;

    for (String parameterName : parameterNameList) {
      parameterList.put(parameterName, info.getQueryParameters().getFirst(parameterName));
    }

    try {
      responseJson = dataMapperBR.performAllActions(resourceName,
              RequestType.SEARCH, parameterList);

      return Response.status(Response.Status.OK)
              .type(MediaType.APPLICATION_JSON)
              .entity(responseJson).build();
    } catch (Exception ex) {
      errorMessage = ex.getMessage();

      if (errorMessage == null || errorMessage.trim().isEmpty()) {
        errorMessage = ex.toString();
      }
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
              .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN
                      + ";charset=UTF-8")
              .entity(errorMessage).build();
    }
  }

  @GET
  @Path("/{resourceName}")
  public Response getResource(@PathParam("resourceName") String resourceName, @Context UriInfo info) {
    Set<String> parameterNameList = info.getQueryParameters().keySet();
    LinkedHashMap<String, Object> parameterList = new LinkedHashMap<>();
    DataMapperBR dataMapperBR = new DataMapperBR();
    String responseJson;
    String errorMessage;

    for (String parameterName : parameterNameList) {
      parameterList.put(parameterName, info.getQueryParameters().getFirst(parameterName));
    }

    try {
      responseJson = dataMapperBR.performAllActions(resourceName,
              RequestType.GET, parameterList);

      return Response.status(Response.Status.OK)
              .type(MediaType.APPLICATION_JSON)
              .entity(responseJson).build();
    } catch (Exception ex) {
      errorMessage = ex.getMessage();

      if (errorMessage == null || errorMessage.trim().isEmpty()) {
        errorMessage = ex.toString();
      }
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
              .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN
                      + ";charset=UTF-8")
              .entity(errorMessage).build();
    }
  }

  @DELETE
  @Path("/{resourceName}")
  public Response deleteResource(@PathParam("resourceName") String resourceName, @Context UriInfo info) {
    Set<String> parameterNameList = info.getQueryParameters().keySet();
    LinkedHashMap<String, Object> parameterList = new LinkedHashMap<>();
    DataMapperBR dataMapperBR = new DataMapperBR();
    String responseJson;
    String errorMessage;

    for (String parameterName : parameterNameList) {
      parameterList.put(parameterName, info.getQueryParameters().getFirst(parameterName));
    }

    try {
      responseJson = dataMapperBR.performAllActions(resourceName,
              RequestType.DELETE, parameterList);

      return Response.status(Response.Status.OK)
              .type(MediaType.APPLICATION_JSON)
              .entity(responseJson).build();
    } catch (Exception ex) {
      errorMessage = ex.getMessage();

      if (errorMessage == null || errorMessage.trim().isEmpty()) {
        errorMessage = ex.toString();
      }
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
              .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN
                      + ";charset=UTF-8")
              .entity(errorMessage).build();
    }
  }

  @POST
  public Response postResource(String requestJson) {
    DataMapperBR dadoRN = new DataMapperBR();
    String responseJson;
    String errorMessage;

    try {
      responseJson = dadoRN.performAllActions(requestJson, RequestType.POST);

      return Response.status(Response.Status.OK)
              .type(MediaType.APPLICATION_JSON)
              .entity(responseJson).build();
    } catch (Exception ex) {
      errorMessage = ex.getMessage();

      if (errorMessage == null || errorMessage.trim().isEmpty()) {
        errorMessage = ex.toString();
      }
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
              .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN
                      + ";charset=UTF-8")
              .entity(errorMessage).build();
    }
  }

  @PUT
  public Response putResource(String requestJson) {
    DataMapperBR dataMapperBR = new DataMapperBR();
    String responseJson;
    String errorMessage;

    try {
      responseJson = dataMapperBR.performAllActions(requestJson, RequestType.PUT);

      return Response.status(Response.Status.OK)
              .type(MediaType.APPLICATION_JSON)
              .entity(responseJson).build();
    } catch (Exception ex) {
      errorMessage = ex.getMessage();

      if (errorMessage == null || errorMessage.trim().isEmpty()) {
        errorMessage = ex.toString();
      }
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
              .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN
                      + ";charset=UTF-8")
              .entity(errorMessage).build();
    }
  }
}

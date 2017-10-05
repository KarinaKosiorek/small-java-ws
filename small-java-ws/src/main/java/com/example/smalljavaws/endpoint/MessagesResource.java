package com.example.smalljavaws.endpoint;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.smalljavaws.model.Message;
import com.example.smalljavaws.service.MessageServiceImpl;

@Component
@Path("/messages")
public class MessagesResource {

  @Autowired
  private MessageServiceImpl messageService;

  @GET
  @Produces(value = MediaType.APPLICATION_JSON)
  public List<Message> getMessages() {
    return messageService.listAll();
  }

  @GET
  @Path("/{messageId}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getMessage(@PathParam("messageId") Long id) {
    try {
      Message message = messageService.getById(id);
      return Response.ok(message, MediaType.APPLICATION_JSON).build();
    } catch (Exception e) {
      return Response.serverError().build();
    }
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response saveOrUpdateMessage(Message message) {
    try {
      Message result = messageService.saveOrUpdate(message);
      return Response.ok(result, MediaType.APPLICATION_JSON).build();
    } catch (Exception e) {
      return Response.serverError().build();
    }
  }

  @DELETE
  @Path("/{messageId}")
  public Response deleteMessage(@PathParam("messageId") Long id) {
    try {
      messageService.delete(id);
      return Response.ok().build();
    } catch (Exception e) {
      return Response.serverError().build();
    }
  }
}

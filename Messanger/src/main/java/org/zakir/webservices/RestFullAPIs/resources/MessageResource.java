package org.zakir.webservices.RestFullAPIs.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.zakir.webservices.RestFullAPIs.model.Message;
import org.zakir.webservices.RestFullAPIs.resources.beans.MessageFilterBean;
import org.zakir.webservices.RestFullAPIs.services.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService = new MessageService();

	// http://localhost:8080/Messanger/webapi/messages
	@GET
	/*
	 * Lets remove all QueryParam and replace it to BeanParam
	 * public List<Message> getMessages(@QueryParam("year") int year, @QueryParam("start") int start,
			@QueryParam("size") int size)
	 */
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
		if (filterBean.getYear() > 0) {
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		if(filterBean.getStart() >= 0 && filterBean.getSize() > 0) {
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return messageService.getAllMessages();
	}
	
	
	/**
	 * Below method will give you location in header of response
	 * location →http://localhost:8080/Messanger/webapp/messages/4
	 */
	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo) throws URISyntaxException {
		System.out.println(uriInfo.getAbsolutePath());
		Message newMessage = messageService.addMessage(message);
		
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
				.entity(newMessage)
				.build();
		//return messageService.addMessage(message);
	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long Id, Message message) {
		message.setId(Id);
		return messageService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long Id) {
		messageService.removeMessage(Id);
	}

	// http://localhost:8080/Messanger/webapi/messages/{messageId}
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long Id, @Context UriInfo uriInfo) {
		
		
		Message message = messageService.getMessage(Id);
		String uri = uriInfo.getRequestUriBuilder()
							.path(MessageResource.class)
							.path(Long.toString(message.getId()))
							.build()
							.toString();
		
		message.addLink(uri, "self");
		return message;
	}
	
	@Path("/{messageId}/comments") //When this path matches, hand over the request to SUB RESOURCD below
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
	
}

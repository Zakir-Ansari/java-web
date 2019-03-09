package org.zakir.webservices.RestFullAPIs.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.zakir.webservices.RestFullAPIs.model.ErrorMessage;

@Provider   //It registers Data Not Found exception in JAXRS to prevent tomcat exceptions 
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(),404,"documentation: anything.com" );
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}

}
//You can create more Exception mappers 
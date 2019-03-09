package org.zakir.webservices.RestFullAPIs.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.APPLICATION_JSON)
public class InjectDemoResource {

	//In case of matrix param, accessing is done by ';'
	//Header param is use in case of custom header values, useful in authentication and security
	@GET
	@Path("annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
											@HeaderParam("customHeaderValue") String header,
											@CookieParam("cookie") String cookie) {
		return "Matrix Param: " + matrixParam + " Header param: " + header + " Cookie: " + cookie;
	}
	
	//Context can be annotated to special type of argument
	@GET
	@Path("context")
	public String getParamUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
		String path = uriInfo.getAbsolutePath().toString();
		String Cookies = headers.getCookies().toString();
		return "Path: " + path + " & Cookies: " + Cookies;
		//This will give "Path: http://localhost:8080/Messanger/webapi/injectdemo/context"
	}	
}

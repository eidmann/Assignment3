package main.java.api;

import java.lang.annotation.Target;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("response")
public class ResponseMessage {

	// private static Statement stmt;
	// private static ResultSet results;

	@GET
	@Produces("application/json")
	public Response Message() {
		String App = new App().testActors();
		return Response.ok(App).build();
	}

// ------ POST med FORM -------
//	@POST
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response newActorByForm(@FormParam("first") String fname, @FormParam("last") String lname)
//			throws URISyntaxException {
//
//		if (!(fname.isEmpty()) && !(lname.isEmpty())) {
//			Person auto_id = new App().createActors(fname, lname);
//			return Response.created(URI.create("response/" + auto_id)).build();
//		} else {
//			return Response.status(400).entity(new Message("saknar parametrar")).build();
//		}
//	}
//
//	// ------- POST med OBJECT --------
//
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response newActor(Person p) throws URISyntaxException {
//
//		if (!(p.getFname().isEmpty()) && !(p.getLname().isEmpty())) {
//			Person auto_id = new App().createActors(p.getFname(), p.getLname());
//			return Response.created(URI.create("response/" + auto_id)).build();
//		} else {
//			return Response.status(400).entity(new Message("saknar parametrar")).build();
//		}
//	}

}

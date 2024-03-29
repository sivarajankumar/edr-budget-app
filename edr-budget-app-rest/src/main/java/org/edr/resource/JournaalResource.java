package org.edr.resource;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.edr.po.Journaal;
import org.edr.po.jpa.JournaalPO;
import org.edr.services.BoekingService;
import org.edr.services.JournaalService;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;

@Path("journaal")
public class JournaalResource {

	@Autowired
	JournaalService journaalService;

	@Autowired
	BoekingService boekingService;

	@Path("/upload")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public void createJournaal(@FormDataParam("journaalbestand") InputStream fileInputStream) {
		journaalService.loadJournaalFromStream(new BufferedReader(new InputStreamReader(fileInputStream)));
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Journaal> findJournaal(@QueryParam("jaar") int jaar) {
		return journaalService.findJournaal(jaar);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void saveBoekingen(JournaalPO journaal) {
		boekingService.saveBoekingen(journaal);
	}

}

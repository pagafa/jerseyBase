package com.gallegofalcon.pablo.jerseyBase.controller;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gallegofalcon.pablo.jerseyBase.entity.User;
import com.gallegofalcon.pablo.jerseyBase.service.StorageService;

@Singleton
@Path("/hello")
public class Hello {

	@Inject
	private StorageService storageService;

	@GET
	@Path("{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String say(final @PathParam("name") @NotNull String name) {
		User user = new User();
		user.setName(name);
		storageService.addUser(user);

		return "Hello " + user.getName() + "(" + user.getId() + ")";
	}
}

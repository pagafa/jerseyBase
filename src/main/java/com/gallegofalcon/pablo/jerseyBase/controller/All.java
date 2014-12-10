package com.gallegofalcon.pablo.jerseyBase.controller;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gallegofalcon.pablo.jerseyBase.entity.User;
import com.gallegofalcon.pablo.jerseyBase.service.StorageService;

@Singleton
@Path("/all")
public class All {

	@Inject
	private StorageService storageService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> locate() {
		return storageService.listUsers();
	}
}

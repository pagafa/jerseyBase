package com.gallegofalcon.pablo.jerseyBase.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gallegofalcon.pablo.jerseyBase.entity.User;
import com.gallegofalcon.pablo.jerseyBase.manager.StorageManager;

@Service
@Singleton
public class StorageService {
	private static final Logger logger = LoggerFactory.getLogger(StorageService.class);

	@Inject
	private StorageManager storageManager;

	public void addUser(final User user) {
		storageManager.addUser(user);
	}

	public List<User> listUsers() {
		return storageManager.listUsers();
	}
}

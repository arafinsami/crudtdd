package com.crudtdd.driving_adapter;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.crudtdd.user.AppUserModel;
import com.crudtdd.user.AppUserService;
import com.crudtdd.utils.ResourceNotFoundException;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class AppUserStoreHandlar {

	private final AppUserService appUserService;
	
	private final AppUserStoreModelHandlarMapper appUserStoreModelHandlarMapper;
	
	public AppUserStoreModel findByEmail(String email) {
		log.info("started calling client find user by email---{}", email);
		Optional<AppUserModel> appUserMessageModel = Optional.of(appUserService.findByEmail(email).orElseThrow(ResourceNotFoundException::new));
		return appUserStoreModelHandlarMapper.from(appUserMessageModel.get());
	}

	public AppUserStoreModel saveUser(AppUserStoreModel appUserStoreModel) {
		Optional<AppUserModel> appUserMessageModel = Optional.of(appUserStoreModelHandlarMapper.to(appUserStoreModel));
		if (appUserMessageModel.isEmpty()) {
			log.info("saving failed ----{}", appUserMessageModel);
		}
		return appUserStoreModelHandlarMapper.from(appUserMessageModel.get());
	}
}

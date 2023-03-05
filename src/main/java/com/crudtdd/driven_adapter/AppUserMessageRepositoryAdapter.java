package com.crudtdd.driven_adapter;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.crudtdd.user.AppUserModel;
import com.crudtdd.utils.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class AppUserMessageRepositoryAdapter implements AppUserMessageRepository {

	private final AppUserMessageClient appUserMessageClient;

	@Override
	public AppUserModel findByEmail(String email) {
		log.info("started calling client find user by email---{}", email);
		Optional<AppUserMessageModel> appUserMessageModel = Optional
				.of(appUserMessageClient.findByEmail(email).orElseThrow(ResourceNotFoundException::new));
		return AppUserMessageModelAdapter.from(appUserMessageModel.get());
	}

	@Override
	public AppUserModel saveUser(AppUserModel appUserModel) {
		Optional<AppUserMessageModel> appUserMessageModel = Optional.of(AppUserMessageModelAdapter.to(appUserModel));
		if (appUserMessageModel.isEmpty()) {
			log.info("saving failed ----{}", appUserMessageModel);
		}
		return AppUserMessageModelAdapter.from(appUserMessageModel.get());
	}

}

package com.crudtdd.user;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.crudtdd.driven_adapter.AppUserMessageRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppUserServiceAdapter implements AppUserService {

	private final AppUserMessageRepository appUserMessageRepository;

	@Override
	public Optional<AppUserModel> findByEmail(String email) {
		return Optional.of(appUserMessageRepository.findByEmail(email));
	}

	@Override
	public Optional<AppUserModel> saveUser(AppUserModel appUserModel) {
		return Optional.of(appUserMessageRepository.saveUser(appUserModel));
	}

}

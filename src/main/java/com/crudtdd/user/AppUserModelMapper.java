package com.crudtdd.user;

import org.springframework.stereotype.Component;

import com.crudtdd.entity.AppUser;

@Component
public class AppUserModelMapper {

	public AppUserModel to(AppUser appUser) {
		return AppUserModel.builder()
				.firstName(appUser.getFirstName())
				.lastName(appUser.getLastName())
				.email(appUser.getEmail())
				.build();
	}
}

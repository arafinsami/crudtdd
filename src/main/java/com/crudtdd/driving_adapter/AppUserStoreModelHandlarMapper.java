package com.crudtdd.driving_adapter;

import org.springframework.stereotype.Component;

import com.crudtdd.user.AppUserModel;

@Component
public class AppUserStoreModelHandlarMapper {

	public AppUserModel to(AppUserStoreModel appUserStoreModel) {
		return AppUserModel.builder()
				.firstName(appUserStoreModel.getFirstName())
				.lastName(appUserStoreModel.getLastName())
				.email(appUserStoreModel.getEmail())
				.build();
	}
	
	public AppUserStoreModel from(AppUserModel appUserModel) {
		return AppUserStoreModel.builder()
				.firstName(appUserModel.getFirstName())
				.lastName(appUserModel.getLastName())
				.email(appUserModel.getEmail())
				.build();
	}
}

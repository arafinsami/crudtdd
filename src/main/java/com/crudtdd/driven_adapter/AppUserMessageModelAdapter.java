package com.crudtdd.driven_adapter;

import com.crudtdd.user.AppUserModel;

public class AppUserMessageModelAdapter {

	public static AppUserMessageModel to(AppUserModel appUserModel) {
		return AppUserMessageModel.builder()
				.firstName(appUserModel.getFirstName())
				.lastName(appUserModel.getLastName())
				.email(appUserModel.getEmail())
				.build();
	}
	
	public static AppUserModel from(AppUserMessageModel appUserMessageModel) {
		return AppUserModel.builder()
				.firstName(appUserMessageModel.getFirstName())
				.lastName(appUserMessageModel.getLastName())
				.email(appUserMessageModel.getEmail())
				.build();
	}
}

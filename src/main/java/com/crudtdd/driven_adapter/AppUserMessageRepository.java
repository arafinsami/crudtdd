package com.crudtdd.driven_adapter;

import com.crudtdd.user.AppUserModel;

public interface AppUserMessageRepository {

	AppUserModel findByEmail(String email);

	AppUserModel saveUser(AppUserModel appUserModel);
}

package com.crudtdd.user;

import java.util.Optional;

public interface AppUserService {

	Optional<AppUserModel> findByEmail(String userName);

	Optional<AppUserModel> saveUser(AppUserModel appUserModel);
}

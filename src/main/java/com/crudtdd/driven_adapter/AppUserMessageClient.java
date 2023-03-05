package com.crudtdd.driven_adapter;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crudtdd.user.AppUserModel;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@FeignClient(name = "app-user-message-client", url = "http://localhost:7000")
public interface AppUserMessageClient {

	@GetMapping("/data/app-user/{email}")
	Optional<AppUserMessageModel> findByEmail(@PathVariable("email") String email);

	@PostMapping("/data/app-user/save")
	AppUserMessageModel saveUser(@RequestBody AppUserModel appUserMessageModel);

}

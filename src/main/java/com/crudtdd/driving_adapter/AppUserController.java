package com.crudtdd.driving_adapter;

import static com.crudtdd.utils.ResponseBuilder.success;
import static org.springframework.http.ResponseEntity.ok;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudtdd.user.AppUserModel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Tag(name = "user api")
@RequestMapping("/user")
@RequiredArgsConstructor
public class AppUserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppUserStoreHandlar.class);
	
	private final AppUserStoreHandlar appUserStoreHandlar;
	
	private final AppUserStoreModelHandlarMapper appUserStoreModelHandlarMapper;

	@GetMapping("/lists")
	@Operation(summary = "show lists of users", description = "lists of users")
	@ApiResponse(responseCode = "200", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = AppUserStoreModel.class)) })
	public ResponseEntity<JSONObject> findAll() {
		return ok(success(null).getJson());
	}
	
	
	@PostMapping("/save")
	@Operation(summary = "save user", description = "save user")
	@ApiResponse(responseCode = "200", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = AppUserStoreModel.class)) })
	public ResponseEntity<JSONObject> save(@RequestBody AppUserStoreModel appUserStoreModel) {
		AppUserStoreModel model = appUserStoreHandlar.saveUser(appUserStoreModel);
		AppUserModel appUserModel = appUserStoreModelHandlarMapper.to(model);
		return ok(success(appUserModel).getJson());
	}
}

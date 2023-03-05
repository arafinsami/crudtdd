package com.crudtdd.user;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder(toBuilder = true)
public class AppUserModel {

	private String firstName;

	private String lastName;

	private String email;
}

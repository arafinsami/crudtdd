package com.crudtdd.driven_adapter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class AppUserMessageModel {

	private String firstName;

	private String lastName;

	private String email;
}

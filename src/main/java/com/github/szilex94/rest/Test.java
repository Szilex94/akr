package com.github.szilex94.rest;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Test {

	@NotNull
	private String s1;

	@NotEmpty
	private String s2;

}

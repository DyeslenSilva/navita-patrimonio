package com.spring.component;

import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;

public class JsonError {
	public static String build (BindingResult result) {
		return new StringBuilder("{\n" +
				  result.getFieldErrors().stream()
				    .map(erro -> "\"" + erro.getField() + "\" : \"" + erro.getDefaultMessage() + "\"")
				    .collect(Collectors.joining(",\n")) + "\n}"
					).toString();
	}
}

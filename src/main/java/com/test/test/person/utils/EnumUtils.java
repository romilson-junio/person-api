package com.test.test.person.utils;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.http.converter.HttpMessageNotReadableException;

import com.test.test.person.model.enums.EnumSex;

public class EnumUtils {
	
	public static String getMessage(HttpMessageNotReadableException e) {
		String message = null;
		if (e.getCause() != null && e.getCause().getMessage() != null) {
			
			if(e.getCause().getMessage().contains(EnumSex.class.getName())) {
				String values = Arrays.stream(EnumSex.values()).map(Enum::toString).collect(Collectors.joining(", ", "", ""));
				int lastIndex = values.lastIndexOf(", ");
				values = values.substring(0, lastIndex) + " e " + values.substring(lastIndex + 2);
				message = String.format("Sexo informado inválido! Os valores permitidos são %s", values);	
			}
            
        }
		return message;
	}

}

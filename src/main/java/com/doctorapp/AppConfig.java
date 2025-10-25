package com.doctorapp;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class AppConfig {

	@Bean
	ModelMapper mapper() {
		return new ModelMapper();
	}
	
	@Bean
	ObjectMapper objectMapper() {
		 ObjectMapper objectMapper = new ObjectMapper();
	        objectMapper.registerModule(new JavaTimeModule());
	        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	        return objectMapper;
	}
}

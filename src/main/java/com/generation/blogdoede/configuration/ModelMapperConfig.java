package com.generation.blogdoede.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuração do ModelMapper
 * 
 * @author Edgar Soares Marinho
 * @date 03/02/2022
 * @version 0.1.1-SNAPSHOT
 * 
 */

@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}

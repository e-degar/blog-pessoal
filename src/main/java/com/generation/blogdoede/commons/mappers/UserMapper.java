package com.generation.blogdoede.commons.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.generation.blogdoede.domain.model.User;
import com.generation.blogdoede.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	UserDTO toModel(UserDTO dto);
	User userToDTO(User user);

}

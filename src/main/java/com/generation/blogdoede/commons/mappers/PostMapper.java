package com.generation.blogdoede.commons.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.generation.blogdoede.domain.model.Post;
import com.generation.blogdoede.dto.PostDTO;

@Mapper(componentModel = "spring")
public interface PostMapper {
	
	PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);
	
	PostDTO postToDTO(Post post);
	Post toModel(PostDTO postDto);
	
}

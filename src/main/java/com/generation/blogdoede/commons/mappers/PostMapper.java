package com.generation.blogdoede.commons.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.generation.blogdoede.domain.model.Post;
import com.generation.blogdoede.dto.PostDTO;

@Mapper
public interface PostMapper {
	
	PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);
	
	PostDTO toDTO(Post post);
	Post toModel(PostDTO postDto);

}

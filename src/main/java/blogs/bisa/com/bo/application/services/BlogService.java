package blogs.bisa.com.bo.application.services;

import java.util.List;
import java.util.UUID;

import blogs.bisa.com.bo.domain.dto.BlogsDto;
import blogs.bisa.com.bo.domain.dto.ComentarioDto;
import blogs.bisa.com.bo.domain.dto.PersonaDto;
import blogs.bisa.com.bo.port.adapter.in.entities.BlogsEntity;
import blogs.bisa.com.bo.port.adapter.in.entities.ComentarioEntity;
import blogs.bisa.com.bo.port.adapter.in.entities.PersonaEntity;

public interface BlogService {

	public PersonaEntity crearAutor(PersonaDto pPerona);

	public BlogsEntity crearBlog(BlogsDto pBlog);
	
	 public BlogsEntity updateBlog(BlogsDto pBlog);

	public BlogsEntity findBlogById(UUID pIdBlog);

	public List<BlogsEntity> findAllBlogs();

	public ComentarioEntity crearCometario(ComentarioDto pComentario);
}

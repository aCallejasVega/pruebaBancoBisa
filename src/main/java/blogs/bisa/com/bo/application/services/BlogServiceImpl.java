package blogs.bisa.com.bo.application.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import blogs.bisa.com.bo.application.dao.BlogDao;
import blogs.bisa.com.bo.application.dao.ComentarioDao;
import blogs.bisa.com.bo.application.dao.PersonaDao;
import blogs.bisa.com.bo.application.exception.ProcessException;
import blogs.bisa.com.bo.domain.dto.BlogsDto;
import blogs.bisa.com.bo.domain.dto.ComentarioDto;
import blogs.bisa.com.bo.domain.dto.PersonaDto;
import blogs.bisa.com.bo.port.adapter.in.entities.BlogsEntity;
import blogs.bisa.com.bo.port.adapter.in.entities.ComentarioEntity;
import blogs.bisa.com.bo.port.adapter.in.entities.PersonaEntity;
import jakarta.transaction.Transactional;

@Service
public class BlogServiceImpl implements BlogService {

	private final BlogDao blogDao;
	private final ComentarioDao comentarioDao;
	private final PersonaDao personaDao;

	BlogServiceImpl(BlogDao blogDao, ComentarioDao comentarioDao, PersonaDao personaDao) {
		this.blogDao = blogDao;
		this.comentarioDao = comentarioDao;
		this.personaDao = personaDao;
	}
	@Transactional
	public PersonaEntity crearAutor(PersonaDto pPerona) {
		pPerona.setTipoPersona("AUTOR");
		PersonaEntity vPersona = new PersonaDto.Builder().buildPersona(pPerona).build();
		return this.personaDao.save(vPersona);
	}
	@Transactional
	public BlogsEntity crearBlog(BlogsDto pBlog) {
		
		if(pBlog.getIdAutor()==null) {
			throw new ProcessException("NO SE ENCONTRO NINGUN AUTOR ASOCIADO AL ID.");
		}
		
		try {
			Optional<PersonaEntity>  vAutor = personaDao.findById(pBlog.getIdAutor());
			if(pBlog.getIdAutor()==null) {
				throw new ProcessException("NO SE ENCONTRO NINGUN AUTOR ASOCIADO AL ID.");
			}	
			BlogsEntity vBlogs = new BlogsDto.Builder().buildBlog(pBlog).build();
			vBlogs.setAutor(vAutor.get());
			return this.blogDao.save(vBlogs);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	@Transactional
	public BlogsEntity updateBlog(BlogsDto pBlog) {

		if(pBlog.getIdBlog()==null) {
			throw new ProcessException("NO SE ENCONTRO NINGUN BLOG ASOCIADO AL ID.");
		}
		
		try {
			Optional<BlogsEntity> vBlogs = this.blogDao.findById(pBlog.getIdBlog());
			if(vBlogs.isEmpty()) {
				throw new ProcessException("NO SE ENCONTRO NINGUN BLOG ASOCIADO AL ID.");
			}	
			vBlogs.get().setTitulo(pBlog.getTitulo());
			vBlogs.get().setTema(pBlog.getTema());
			vBlogs.get().setContenido(pBlog.getContenido());
			vBlogs.get().setPerioricidad(pBlog.getPerioricidad());
			vBlogs.get().setPermiteComentarios(pBlog.getPermiteComentarios());
			return this.blogDao.save(vBlogs.get());
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
		
		
		
	}

	
	public BlogsEntity findBlogById(UUID pIdBlog) {

		if (pIdBlog == null) {
			throw new ProcessException("NO SE ENCONTRO NINGUN BLOG ASOCIADO AL ID.");
		}
		try {
			BlogsEntity vBlog = this.blogDao.findBlogById(pIdBlog).orElse(null);
			return vBlog;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	public List<BlogsEntity> findAllBlogs() {
		try {
			return this.blogDao.findAllBlogs();
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}

	}
	@Transactional
	public ComentarioEntity crearCometario(ComentarioDto pComentario) {
		
		
		if(pComentario.getIdBlogs()==null) {
			throw new ProcessException("NO SE ENCONTRO NINGUN BLOG ASOCIADO AL ID.");
		}		
		
		try {			
			Optional<BlogsEntity>  vBlog = this.blogDao.findById(pComentario.getIdBlogs());
			if(vBlog.isEmpty()) {
				throw new ProcessException("NO SE ENCONTRO NINGUN BLOG ASOCIADO AL ID.");
			}			
			ComentarioEntity vComentario = new ComentarioDto.Builder().buildComentario(pComentario).build();
			pComentario.getComentarista().setTipoPersona("COMENTARISTA");
			PersonaEntity vComentarista = new PersonaDto.Builder().buildPersona(pComentario.getComentarista()).build();
			vComentarista = this.personaDao.save(vComentarista);
			vComentario.setComentarista(vComentarista);
			vComentario.setIdBlog(vBlog.get());
			return this.comentarioDao.save(vComentario);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}

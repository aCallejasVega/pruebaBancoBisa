package blogs.bisa.com.bo.domain.dto;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import blogs.bisa.com.bo.port.adapter.in.entities.BlogsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlogsDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private UUID idBlog;
	private Long idAutor;
    private String titulo;
    private Long idClaveTema;
    private String tema;
    private String contenido;
    private String perioricidad;
    private Boolean permiteComentarios;
	@JsonIgnore
    private Date fechaCreacion;
	@JsonIgnore
    private Date fechaModificacion;
    private String estado;  
    private PersonaDto autor;
	@JsonIgnore
    private List<ComentarioDto> comentarioEntityList;
    
    
   
    
    
    public BlogsDto(
    		UUID idBlog,
    		Long idAutor,
    		String titulo, 
    		String tema,
    		String contenido,
    		Boolean permiteComentarios,
    		String estado) {
    	this.idBlog=idBlog;
    	this.idAutor=idAutor;
    	this.titulo=titulo;
    	this.tema=tema;
    	this.contenido=contenido;
    	this.permiteComentarios=permiteComentarios;
    	this.estado=estado;
    }
    
    public static class Builder{
    	private BlogsEntity blogsEntity;

		public Builder() {			
			this.blogsEntity = new BlogsEntity();
		}
    	
		
		public Builder buildBlog(BlogsDto pBlog) {
			
			if(pBlog.getIdBlog()==null) {
				pBlog.setFechaCreacion(new Date());
			}else {
				System.out.println("XXXXXXXXXXXXXXX inagreso");
				pBlog.setIdBlog(pBlog.getIdBlog());
				pBlog.setFechaModificacion(new Date());
			}			
			blogsEntity.setTitulo(pBlog.getTitulo());
			blogsEntity.setTema(pBlog.getTema());
			blogsEntity.setContenido(pBlog.getContenido());
			blogsEntity.setPerioricidad(pBlog.getPerioricidad());
			blogsEntity.setPermiteComentarios(pBlog.getPermiteComentarios());
			blogsEntity.setEstado("ACTIVO");
		
		
			return this;
			
		}
		public BlogsEntity build() {
			return blogsEntity;
		}
    	
    }
    
    
}
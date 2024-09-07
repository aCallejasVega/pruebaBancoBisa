package blogs.bisa.com.bo.domain.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import blogs.bisa.com.bo.port.adapter.in.entities.ComentarioEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComentarioDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private UUID idComentario;
	private UUID idBlogs;
	private String titulo;
	private String descripcion;
	private Date fechaComentario;
	private String estado;
	private int puntuacion;
	private BlogsDto blog;
	private PersonaDto comentarista;

	public ComentarioDto newComentario(BlogsDto pBlog, PersonaDto pPersona) {
		ComentarioDto vComentario = new ComentarioDto();
		vComentario.setFechaComentario(new Date());
		vComentario.setPuntuacion(0);
		vComentario.setEstado("ACTIVO");
		vComentario.setBlog(pBlog);
		vComentario.setComentarista(pPersona);
		return vComentario;
	}

	public static class Builder {
		private ComentarioEntity comentarioEntity;

		public Builder() {
			this.comentarioEntity = new ComentarioEntity();
		}

		public Builder buildComentario(ComentarioDto pComentario) {
			comentarioEntity.setTitulo(pComentario.getTitulo());
			comentarioEntity.setDescripcion(pComentario.getDescripcion());
			comentarioEntity.setFechaComentario(pComentario.getFechaComentario());
			comentarioEntity.setPuntuacion(pComentario.getPuntuacion());
			comentarioEntity.setFechaCreacion(new Date());
			return this;

		}

		public ComentarioEntity build() {
			return comentarioEntity;
		}

	}

}

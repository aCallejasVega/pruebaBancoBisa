package blogs.bisa.com.bo.domain.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


import blogs.bisa.com.bo.port.adapter.in.entities.PersonaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonaDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idPersona;
	private String nombre;
	private String paterno;
	private String materno;
	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/La_Paz")
	private Date fechaNacimiento;
	private String pais;
	private String correoElectronico;
	private Long idTipoPersona;
	private String tipoPersona;
	@JsonIgnore
	private Date fechaCreacion;
	@JsonIgnore
	private Date fechaModificacion;
	@JsonIgnore
	private List<BlogsDto> blogsEntityList;
	@JsonIgnore
	private List<ComentarioDto> comentarioEntityList;

	public PersonaDto newPersona() {
		PersonaDto vPersona = new PersonaDto();
		vPersona.setFechaCreacion(new Date());
		return vPersona;
	}

	public static class Builder {
		private PersonaEntity personaEntity;

		public Builder() {
			this.personaEntity = new PersonaEntity();
		}

		public Builder buildPersona(PersonaDto pPersona) {
			
			
			personaEntity.setNombre(pPersona.getNombre());
			personaEntity.setPaterno(pPersona.getPaterno());
			personaEntity.setMaterno(pPersona.getMaterno());
			personaEntity.setFechaNacimiento(pPersona.getFechaNacimiento());
			personaEntity.setPais(pPersona.getPais());
			personaEntity.setTipoPersona(pPersona.getIdTipoPersona());
			personaEntity.setCorreoElectronico(pPersona.getCorreoElectronico());
			personaEntity.setFechaCreacion(new Date());
			return this;

		}

		public PersonaEntity build() {
			return personaEntity;
		}

	}

}

package blogs.bisa.com.bo.port.adapter.in.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "personas")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idPersona", nullable = false)
	private Long idPersona;
	@Column(length = 100)
	private String nombre;
	@Column(length = 100)
	private String paterno;
	@Column(length = 100)
	private String materno;
	@Column()
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	@Column(length = 60)
	private String pais;
	@Column()
	private String correoElectronico;
	@Column(name = "tipo_persona", length = 10)
	private Long tipoPersona;
	@JsonIgnore
	@Column()
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
	@JsonIgnore
	@Column()
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;	
	@JsonIgnore
	@OneToMany(mappedBy = "autor")
	private List<BlogsEntity> blogsEntityList;
	@JsonIgnore
	@OneToMany(mappedBy = "comentarista")
	private List<ComentarioEntity> comentarioEntityList;

}

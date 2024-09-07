package blogs.bisa.com.bo.port.adapter.in.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;



@Data
@Entity
@Table(name = "blogs")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlogsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column( nullable = false)
    private UUID idBlog;
    @Column(length = 250)
    private String titulo;
    @Column()
    private String tema;
    @Column(length = 2147483647)
    private String contenido;
    private String perioricidad;
    @Column()
    private Boolean permiteComentarios;
    @JsonIgnore
    @Column()
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @JsonIgnore
    @Column()
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Column(length = 10)
    private String estado;  
  
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona")
    @ManyToOne
    private PersonaEntity autor;
    @JsonIgnore
    @OneToMany(mappedBy = "idBlog")
    private List<ComentarioEntity> comentarioEntityList;

    
    
    
    
    
    
}
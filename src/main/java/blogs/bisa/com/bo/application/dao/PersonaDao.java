package blogs.bisa.com.bo.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blogs.bisa.com.bo.port.adapter.in.entities.PersonaEntity;

@Repository
public interface PersonaDao  extends JpaRepository<PersonaEntity, Long>  {
	
}

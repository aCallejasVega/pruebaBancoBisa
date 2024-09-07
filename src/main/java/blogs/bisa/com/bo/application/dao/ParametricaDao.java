package blogs.bisa.com.bo.application.dao;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import blogs.bisa.com.bo.port.adapter.in.entities.BlogsEntity;
import blogs.bisa.com.bo.port.adapter.in.entities.ParametricaEntity;

@Repository
public interface ParametricaDao extends JpaRepository<ParametricaEntity, Long>{

	
	
}

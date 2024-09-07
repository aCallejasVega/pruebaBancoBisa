package blogs.bisa.com.bo.application.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blogs.bisa.com.bo.port.adapter.in.entities.ComentarioEntity;

@Repository
public interface ComentarioDao extends JpaRepository<ComentarioEntity, UUID> {

}

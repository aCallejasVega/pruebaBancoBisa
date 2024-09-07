package blogs.bisa.com.bo.application.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import blogs.bisa.com.bo.domain.dto.BlogsDto;
import blogs.bisa.com.bo.port.adapter.in.entities.BlogsEntity;

@Repository
public interface BlogDao extends JpaRepository<BlogsEntity, UUID>{

	
	@Query(" Select b " 
			+ " from BlogsEntity  b  "			
			+ " Where b.idBlog= :pIdBlog ")
	public Optional<BlogsEntity> findBlogById(@Param("pIdBlog") UUID pIdBlog);
	
	
	@Query(" Select b " 
			+ " from BlogsEntity  b "
			)
	public List<BlogsEntity> findAllBlogs();
}

package blogs.bisa.com.bo.port.adapter.out.controllers;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blogs.bisa.com.bo.application.services.BlogService;
import blogs.bisa.com.bo.domain.dto.BlogsDto;
import blogs.bisa.com.bo.domain.dto.ComentarioDto;
import blogs.bisa.com.bo.domain.dto.PersonaDto;


@RestController
@RequestMapping("api/v1/blogs/")
@CrossOrigin(origins = "*")
public class BlogsController {
	
	
	@Autowired
	private BlogService blogService;	
	
	
	@GetMapping(path = "findAll", produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> findAll() throws RemoteException {
		Map<String, Object> response = new HashMap<>();
		response.put("estado", HttpStatus.NO_CONTENT.value());
		response.put("data", this.blogService.findAllBlogs());
		response.put("fechaOperacion", new Date());
		return new ResponseEntity<>(response, HttpStatus.OK);
	
	}
	
	@GetMapping(path = "findById/{pIdBlog}", produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> findById(@PathVariable("pIdBlog") UUID pIdBlog) throws RemoteException {
		Map<String, Object> response = new HashMap<>();
		response.put("estado", HttpStatus.NO_CONTENT.value());
		response.put("data", this.blogService.findBlogById(pIdBlog));
		response.put("fechaOperacion", new Date());
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	

	@PostMapping(path = "addAutor", produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> addAutor(@RequestBody PersonaDto pAutor) throws RemoteException {
			
		Map<String, Object> response = new HashMap<>();
		response.put("estado", HttpStatus.NO_CONTENT.value());
		response.put("data", this.blogService.crearAutor(pAutor));
		response.put("fechaOperacion", new Date());
		return new ResponseEntity<>(response, HttpStatus.OK);	
		
	}
	
	@PostMapping(path = "addBlog", produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> addBlog(@RequestBody BlogsDto pBlog) throws RemoteException {
		Map<String, Object> response = new HashMap<>();
		response.put("estado", HttpStatus.NO_CONTENT.value());
		response.put("data", this.blogService.crearBlog(pBlog));
		response.put("fechaOperacion", new Date());
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
	@PostMapping(path = "updateBlog", produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> updateBlog(@RequestBody BlogsDto pBlog) throws RemoteException {
		Map<String, Object> response = new HashMap<>();
		response.put("estado", HttpStatus.NO_CONTENT.value());
		response.put("data", this.blogService.updateBlog(pBlog));
		response.put("fechaOperacion", new Date());
		return new ResponseEntity<>(response, HttpStatus.OK);		
	}
	
	@PostMapping(path = "addComentario", produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> addBlog(@RequestBody ComentarioDto pComentario) throws RemoteException {
		Map<String, Object> response = new HashMap<>();
		response.put("estado", HttpStatus.NO_CONTENT.value());
		response.put("data", this.blogService.crearCometario(pComentario));
		response.put("fechaOperacion", new Date());
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}

}

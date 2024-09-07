# pruebaBancoBisa
Aplicación APIs REST que permite la gestión de blogs, esta aplicación permite crear, actualizar y obtener blogs y registrar comentarios en los blogs.


•	Título:  EVALUACIÓN DE CAPACIDADES TÉCNICAS – BANCO BISA.
•	Descripción del proyecto: Aplicación APIs REST que permite la gestión de blogs, esta aplicación permite crear, actualizar y obtener blogs y registrar comentarios en los blogs.
•	Estado del proyecto: CONCLUIDO.
•	Características de la aplicación y demostración: esta aplicación está desarrollada bajo el Framework Spring Boot – JAVA, cuenta con una arquitectura HEXAGONAL y CENTRADA EN EL DOMINIO.  La aplicación implementa la base de datos H2 para realizar la persistencia de la información y la consulta de la misma.
•	Acceso al proyecto: para ejecutar el proyecto es necesario tener instalado un JDK o Open-JDK en la versión 19 o superior. 
1.	Debemos descargar el proyecto del repositorio GIT de la siguiente url:
      https://github.com/aCallejasVega/pruebaBancoBisa.git
2.	En el proyecto se encuentra compilado el archivo:
      blogs.bisa.com.bo-0.0.1-SNAPSHOT.jar
3.	Para ejecutar este proyecto debemos dirigirnos a la ubicación del proyecto blogs.bisa.com.bo-0.0.1-SNAPSHOT.jar y ejecutar el siguiente comando:
               Java –jar blogs.bisa.com.bo-0.0.1-SNAPSHOT.jar
4.	Las url para acceder a los Enpoint son las siguientes.
•	EndPoint para adicionar un Autor de un Blog:
o	METODO: POST.
o	URL: http://localhost:9080/api/v1/blogs/addAutor
o	Parametros de entrada Body : 
             {
	    "nombre":"ADALID",
	    "paterno":"CALLEJAS",
	    "materno":"VEGA",
	    "fechaNacimiento":"21/09/1983",
	    "pais":"BOLIVIA",
	    "correoElectronico":"adalidvega@gmail.com",
	    "idTipoPersona":"1"
	}
o	Parametros de Salida: 

	{
	    "estado": 204,
	    "data": {
        	"idPersona": 1,
	        "nombre": "ADALID",
        	"paterno": "CALLEJAS",
	        "materno": "VEGA",
        	"fechaNacimiento": "1983-09-21T04:00:00.000+00:00",
	        "pais": "BOLIVIA",
        	"correoElectronico": "adalidvega@gmail.com",
	        "tipoPersona": 1
	    },
	    "fechaOperacion": "2024-09-07T20:52:26.568+00:00"
	}




•	EndPoint para adicionar un Blog por Autor:
o	METODO: POST.
o	URL: http://localhost:9080/api/v1/blogs/addBlog
o	Parametros de entrada Body : 

	{
    
	    "idAutor": "1",
	    "titulo": "CIENCIA DE DATOS PYTHON sssss",
	    "tema": "CIENCIA",
	    "contenido": " xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxx",
	    "perioricidad": "DIARIA",
	    "permiteComentarios": "true"
	}

o	Parametros de Salida: 
		{
    	"estado": 204,
	    "data": {
        	"idBlog": "5a914f2a-aec6-4fdf-8d14-9ed5d7e9fae7",
	        "titulo": "CIENCIA DE DATOS PYTHON sssss",
        	"tema": "CIENCIA",
	        "contenido": " xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxx",
        	"perioricidad": "DIARIA",
	        "permiteComentarios": true,
        	"estado": "ACTIVO",
	        "autor": {
        	    "idPersona": 1,
	            "nombre": "ADALID",
        	    "paterno": "CALLEJAS",
	            "materno": "VEGA",
        	    "fechaNacimiento": "1983-09-20",
	            "pais": "BOLIVIA",
        	    "correoElectronico": "adalidvega@gmail.com",
	            "tipoPersona": 1
        	}
	    },
	    "fechaOperacion": "2024-09-07T20:52:42.848+00:00"
	}
 




•	EndPoint para actualizar un Blog por Autor:
o	METODO: POST.
o	URL: http://localhost:9080/api/v1/blogs/updateBlog
o	Parametros de entrada Body : 

	{
    
	    "idBlog": "5a914f2a-aec6-4fdf-8d14-9ed5d7e9fae7",
	    "titulo": "CIENCIA DE DATOS PYTHON",
	    "tema": "CIENCIA",
	    "contenido": " xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxx",
	    "perioricidad": "DIARIA",
	    "permiteComentarios": "true"
	}



o	Parametros de Salida : 


	{
	    "estado": 204,
	    "data": {
        	"idBlog": "5a914f2a-aec6-4fdf-8d14-9ed5d7e9fae7",
	        "titulo": "CIENCIA DE DATOS PYTHON",
        	"tema": "CIENCIA",
	        "contenido": " xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxx",
        	"perioricidad": "DIARIA",
	        "permiteComentarios": true,
        	"estado": "ACTIVO",
	        "autor": {
        	    "idPersona": 1,
	            "nombre": "ADALID",
        	    "paterno": "CALLEJAS",
	            "materno": "VEGA",
        	    "fechaNacimiento": "1983-09-20",
	            "pais": "BOLIVIA",
        	    "correoElectronico": "adalidvega@gmail.com",
	            "tipoPersona": 1
        	}
	    },
	    "fechaOperacion": "2024-09-07T20:53:21.081+00:00"
}






•	EndPoint para adicionar un Comentario:
o	METODO: POST.
o	URL: http://localhost:9080/api/v1/blogs/addComentario
o	Parametros de entrada Body : 

	{
	    "idBlogs": "5a914f2a-aec6-4fdf-8d14-9ed5d7e9fae7",
	    "titulo": "MUY BUEN POST ARTIFICIAL",
	    "descripcion": "CIENCIA",    
	    "puntuacion": "8",
	    "comentarista": {
        	"nombre": "ANDRES",
	        "paterno": "PAREDES",
        	"materno": "VEGA",
	        "fechaNacimiento": "05/09/1993",
        	"pais": "BOLIVIA",
	        "correoElectronico": "adresvega@gmail.com"       
    	}
	}


o	Parametros de Salida :


	{
	    "estado": 204,
	    "data": {
        	"idComentario": "95e2a8b5-c4e2-4ec9-8693-8a7842569a14",
	        "titulo": "MUY BUEN POST ARTIFICIAL",
        	"descripcion": "CIENCIA",
	        "puntuacion": 8,
        	"fechaCreacion": "2024-09-07T20:54:09.213+00:00",
	        "idBlog": {
        	    "idBlog": "5a914f2a-aec6-4fdf-8d14-9ed5d7e9fae7",
	            "titulo": "CIENCIA DE DATOS PYTHON",
        	    "tema": "CIENCIA",
	            "contenido": " xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxx",
        	    "perioricidad": "DIARIA",
	            "permiteComentarios": true,
        	    "estado": "ACTIVO",
	            "autor": {
        	        "idPersona": 1,
                	"nombre": "ADALID",
	                "paterno": "CALLEJAS",
        	        "materno": "VEGA",
                	"fechaNacimiento": "1983-09-20",
	                "pais": "BOLIVIA",
        	        "correoElectronico": "adalidvega@gmail.com",
                	"tipoPersona": 1
	            }
        	},
	        "comentarista": {
        	    "idPersona": 2,
	            "nombre": "ANDRES",
        	    "paterno": "PAREDES",
	            "materno": "VEGA",
        	    "fechaNacimiento": "1993-09-05T04:00:00.000+00:00",
	            "pais": "BOLIVIA",
        	    "correoElectronico": "adresvega@gmail.com"
        	}
    	},
	    "fechaOperacion": "2024-09-07T20:54:09.217+00:00"
	}




•	EndPoint para listar todos los Blogs:
o	METODO: get.
o	URL: http://localhost:9080/api/v1/blogs/findAll
o	Parametros de entrada: ninuna 
o	Parametros de Salida :
•	{
•	    "estado": 204,
•	    "data": [
•	        {
•	            "idBlog": "5a914f2a-aec6-4fdf-8d14-9ed5d7e9fae7",
•	            "titulo": "CIENCIA DE DATOS PYTHON",
•	            "tema": "CIENCIA",
•	            "contenido": " xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxx",
•	            "perioricidad": "DIARIA",
•	            "permiteComentarios": true,
•	            "estado": "ACTIVO",
•	            "autor": {
•	                "idPersona": 1,
•	                "nombre": "ADALID",
•	                "paterno": "CALLEJAS",
•	                "materno": "VEGA",
•	                "fechaNacimiento": "1983-09-20",
•	                "pais": "BOLIVIA",
•	                "correoElectronico": "adalidvega@gmail.com",
•	                "tipoPersona": 1
•	            }
•	        }
•	    ],
•	    "fechaOperacion": "2024-09-07T20:54:48.005+00:00"
•	}


•	EndPoint para buscar un Blog:
o	METODO: get.
o	URL: http://localhost:9080/api/v1/blogs/findById/24fe6667-7487-4117-ae8a-8b250aeb252a
o	Parametros de entrada: idBlog 
o	Parametros de salida: 

{
    "idBlog": "24fe6667-7487-4117-ae8a-8b250aeb252a",
    "titulo": "CIENCIA DE DATOS PYTHON",
    "tema": "CIENCIA",
    "contenido": " xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxx",
    "perioricidad": "DIARIA",
    "permiteComentarios": true,
    "estado": "ACTIVO",
    "autor": {
        "idPersona": 1,
        "nombre": "ADALID",
        "paterno": "CALLEJAS",
        "materno": "VEGA",
        "fechaNacimiento": "1983-09-20",
        "pais": "BOLIVIA",
        "correoElectronico": "adalidvega@gmail.com",
        "tipoPersona": 1
    }
}



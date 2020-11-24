package com.sd.myMediaList.Exceptions.Util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sd.myMediaList.Exceptions.StatusNotFoundException;
import com.sd.myMediaList.Exceptions.TipoNotFoundException;
import com.sd.myMediaList.Exceptions.UsuarioNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(TipoNotFoundException.class)
	public ResponseEntity<ErrorDetails> handlerTipoException(TipoNotFoundException e, HttpServletRequest request) {
		e.printStackTrace();
		ErrorDetails error = new ErrorDetails();
		error.setStatus(404l);
		error.setTitle("Tipo not found exception.");
		error.setUrl("http://erros.teste.com/404");
		error.setTimestamp(System.currentTimeMillis());
		error.setMessage(e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

	}

	@ExceptionHandler(UsuarioNotFoundException.class)
	public ResponseEntity<ErrorDetails> handlerUsuarioException(UsuarioNotFoundException e,
			HttpServletRequest request) {
		e.printStackTrace();
		ErrorDetails error = new ErrorDetails();
		error.setStatus(404l);
		error.setTitle("Usuario not found exception.");
		error.setUrl("http://erros.teste.com/404");
		error.setTimestamp(System.currentTimeMillis());
		error.setMessage(e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

	}

	@ExceptionHandler(StatusNotFoundException.class)
	public ResponseEntity<ErrorDetails> handlerStatusException(StatusNotFoundException e, HttpServletRequest request) {
		e.printStackTrace();
		ErrorDetails error = new ErrorDetails();
		error.setStatus(404l);
		error.setTitle("Status not found exception.");
		error.setUrl("http://erros.teste.com/404");
		error.setTimestamp(System.currentTimeMillis());
		error.setMessage(e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

	}

}

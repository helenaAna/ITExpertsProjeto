package com.itexperts.projetofinal.controller.handle;

import java.text.MessageFormat;
import java.time.Instant;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.itexperts.projetofinal.model.exception.ErroPadrao;
import com.itexperts.projetofinal.service.exception.ContaException;
import com.itexperts.projetofinal.service.exception.RecursoNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandle {

	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public ResponseEntity<ErroPadrao> entidadeNaoEncontrada(RecursoNaoEncontradoException e,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao erro = new ErroPadrao();
		erro.setTimeStamp(Instant.now());
		erro.setStatus(status.value());
		erro.setError("Recurso não encontrado");
		erro.setMessage(e.getMessage());
		erro.setPath(request.getRequestURI());

		return ResponseEntity.status(status).body(erro);

	}

	@ExceptionHandler(ContaException.class)
	public ResponseEntity<ErroPadrao> contaConflito(ContaException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.CONFLICT;
		ErroPadrao erro = new ErroPadrao();
		erro.setTimeStamp(Instant.now());
		erro.setStatus(status.value());
		erro.setError("Conta com conflito");
		erro.setMessage(e.getMessage());
		erro.setPath(request.getRequestURI());

		return ResponseEntity.status(status).body(erro);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErroPadrao> validationException(ConstraintViolationException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErroPadrao erro = new ErroPadrao();
		erro.setTimeStamp(Instant.now());
		erro.setStatus(status.value());
		erro.setError("Valores informados não aceitos!");

		erro.setMessages(new ArrayList<>());
		int i = 0;
		for (ConstraintViolation<?> constraint : e.getConstraintViolations()) {
			erro.getMessages().add(MessageFormat.format("{0} - {1}",++i, constraint.getMessageTemplate()));
		}

		erro.setPath(request.getRequestURI());

		return ResponseEntity.status(status).body(erro);
	}
}

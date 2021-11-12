package com.omar.emsbackend.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class DuplicateResourceException extends RuntimeException {

  private static final long serialVersionIUD = 1L;

  public DuplicateResourceException(String message) {
    super(message);
  }

}

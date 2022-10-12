package com.cniback.cniback.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FormationIntrouvableException extends Throwable {
public	FormationIntrouvableException(String s) {
	super(s);
}
}

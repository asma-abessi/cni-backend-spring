package com.cniback.cniback.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CongeIntrouvableException extends Throwable {
public	CongeIntrouvableException(String s) {
	super(s);
}
}

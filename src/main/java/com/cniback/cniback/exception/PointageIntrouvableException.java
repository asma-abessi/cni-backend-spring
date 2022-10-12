
package com.cniback.cniback.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PointageIntrouvableException extends Throwable {
public	PointageIntrouvableException(String s) {
	super(s);
}
}

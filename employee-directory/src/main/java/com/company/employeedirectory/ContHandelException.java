package com.company.employeedirectory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ContHandelException {
// creating an exception handeler for not found id
@ExceptionHandler
ResponseEntity<ResponseExctionBody>IDNotFound(IdException idNotF){
	ResponseExctionBody reb=new ResponseExctionBody();
	reb.setStsausCode(HttpStatus.NOT_FOUND.value());
	reb.setMessage(idNotF.getMessage());
	reb.setTimpstamps(System.currentTimeMillis());
	return new ResponseEntity<ResponseExctionBody>(reb,HttpStatus.NOT_FOUND);
}
//creating handeler for not integer value
@ExceptionHandler
ResponseEntity<ResponseExctionBody>IDNotInt(NumberFormatException idNI){
	ResponseExctionBody reb=new ResponseExctionBody();
	reb.setStsausCode(HttpStatus.NOT_ACCEPTABLE.value());
	reb.setMessage(idNI.getMessage());
	reb.setTimpstamps(System.currentTimeMillis());
	return new ResponseEntity<ResponseExctionBody>(reb,HttpStatus.NOT_ACCEPTABLE);
}
//creating handeler for any exception
@ExceptionHandler
ResponseEntity<ResponseExctionBody>IDNotInt(Exception ex){
	ResponseExctionBody reb=new ResponseExctionBody();
	reb.setStsausCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
	reb.setMessage(ex.getMessage());
	reb.setTimpstamps(System.currentTimeMillis());
	return new ResponseEntity<ResponseExctionBody>(reb,HttpStatus.INTERNAL_SERVER_ERROR);
}
}

package com.masai.exceptions;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	 @ExceptionHandler(AccountException.class)
	 public ResponseEntity<MyError> MyAccounterrorHandler(AccountException ae, WebRequest req){
		 MyError myerror=new MyError();
		 myerror.setTimestamp(LocalDateTime.now());
		 myerror.setMessage(ae.getMessage());
		 myerror.setDetails(req.getDescription(false));
		return new ResponseEntity<MyError>(myerror, HttpStatus.BAD_REQUEST);
	 }
	 
	 @ExceptionHandler(InsufficentBalanceException.class)
	 public ResponseEntity<MyError> MyInsufficientbalanceHandler(InsufficentBalanceException ibe, WebRequest req){
		 MyError myerror=new MyError();
		 myerror.setTimestamp(LocalDateTime.now());
		 myerror.setMessage(ibe.getMessage());
		 myerror.setDetails(req.getDescription(false));
		 return new ResponseEntity<MyError>(myerror, HttpStatus.BAD_REQUEST);
	 }
	 
	 @ExceptionHandler(NoHandlerFoundException.class)
	 public ResponseEntity<MyError> NoHandler(NoHandlerFoundException ne, WebRequest req){
		 MyError myerror=new MyError();
		 myerror.setTimestamp(LocalDateTime.now());
		 myerror.setMessage(ne.getMessage());
		 myerror.setDetails(req.getDescription(false));
		 return new ResponseEntity<MyError>(myerror, HttpStatus.BAD_REQUEST);
	 }
	 
	 
} 

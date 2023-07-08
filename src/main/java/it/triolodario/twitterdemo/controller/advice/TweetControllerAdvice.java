package it.triolodario.twitterdemo.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import it.triolodario.twitterdemo.controller.exception.TweetNotFoundException;

@ControllerAdvice
public class TweetControllerAdvice {

	@ResponseBody
	@ExceptionHandler(TweetNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String tweetNotFoundHandler(TweetNotFoundException ex) {
		return ex.getMessage();
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public String handleExceptions(Exception ex) {
		return "Generic error: " + ex.getCause() + ex.getMessage();
	}

}

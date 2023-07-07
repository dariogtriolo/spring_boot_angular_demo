package it.triolodario.twitterdemo.controller.exception;

public class TweetNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String MESSAGE = "Could not find tweet: ";

	public TweetNotFoundException(Long id) {
		super(MESSAGE + id);
	}
}

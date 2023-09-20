package it.triolodario.twitterdemo.model;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Tweet {

	private @Id @GeneratedValue Long id;
	private String author;
	private String message;
	private Instant dateTime;

	public Tweet() {
	}

	public Tweet(String author, String message, Instant dateTime) {
		super();
		this.author = author;
		this.message = message;
		this.dateTime = dateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Instant getDateTime() {
		return dateTime;
	}

	public void setDateTime(Instant dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Tweet [id=" + id + ", author=" + author + ", message=" + message + ", dateTime=" + dateTime + "]";
	}

}

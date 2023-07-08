package it.triolodario.twitterdemo.controller.dto;

import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;

public class TweetDTO {

	@Schema(name = "id", example = "1", hidden = true)
	private Long id;
	
	@Schema(name = "author", example = "Mario")
	private String author;
	
	@Schema(name = "message", example = "a message")
	private String message;
	
	@Schema(name = "dateTime", example = "22:07 GMT - 07/07/2021")
	private String dateTime;

	public TweetDTO(Long id, String author, String message, String dateTime) {
		super();
		this.id = id;
		this.author = author;
		this.message = message;
		this.dateTime = dateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, dateTime, id, message);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TweetDTO other = (TweetDTO) obj;
		return Objects.equals(author, other.author) && Objects.equals(dateTime, other.dateTime)
				&& Objects.equals(id, other.id) && Objects.equals(message, other.message);
	}

	@Override
	public String toString() {
		return "TweetDTO [id=" + id + ", author=" + author + ", message=" + message + ", dateTime=" + dateTime + "]";
	}

}

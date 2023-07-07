package it.triolodario.twitterdemo.model;

public class Author {

	private long id;
	private String userId;
	private String email;

	public Author(String userId, String email) {
		super();
		this.userId = userId;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", userId=" + userId + ", email=" + email + "]";
	}

}

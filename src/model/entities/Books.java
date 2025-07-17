package model.entities;

import model.enums.Status;

public class Books {
	private Integer id;
	private String title;
	private String author;
	private Status status;

	public Books(Integer id, String title, String author, Status status) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Status getStatus() {
		return status;
	}
	
	public boolean isBorrowed() {
		return this.status == Status.BORROWED;
	}
	
	public boolean isAvailable() {
		return this.status == Status.AVAILABLE;
	}

	public void toBorrow() {
		this.status = status.BORROWED; 
	}

	public void toReturn() {
		this.status = status.AVAILABLE;
	}
	
	@Override 
	public String toString() {
		  return "ID: " + id + " | Title: " + title + " | Author: " + author + " | Status: " + status;
	}
	}
}

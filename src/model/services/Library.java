package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Books;
import model.entities.Users;
import model.enums.Status;

public class Library {

	private List<Books> listBooks = new ArrayList<>();
	private List<Users> listUsers = new ArrayList<>();

	public List<Books> getListBooks() {
		return listBooks;
	}

	public void booksRegister(Books book) {
		listBooks.add(book);
	}

	public List<Users> getListUsers() {
		return listUsers;
	}

	public void userRegister(Users user) {
		listUsers.add(user);
	}
	
	public void loan(int idBook) {
		Books book = searchBook(idBook);
		if(book != null && book.getStatus() != Status.AVAILABLE) {
			book.toBorrow();
			System.out.println("Book's borrowed. ");
		} 
		else {
			System.out.println("Book not found");
		}
	}
	
	public void returnBook(int idBook) {
		Books book = searchBook(idBook);
		if(book != null && book.getStatus() == Status.BORROWED) {
			book.toReturn();
			System.out.println("Books is not borrowed");
		}
		else {
			System.out.println("INVALID");
		}
	}
	
	
	public void toListBooks() {
		if(listBooks.isEmpty()) {
			System.out.println("No books registered yet.");
		}
		else {
			listBooks.forEach(System.out::println);
		}
	}
	
	private Books searchBook(int id) {
		for(Books b : listBooks) {
			if(b.getId() == id) {
				return b;
			}
		}
		return null;
	}
}

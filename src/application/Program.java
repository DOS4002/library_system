package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Books;
import model.entities.Users;
import model.enums.Status;
import model.services.Library;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		final String BOLD = "\033[1m";
		final String RESET = "\033[0m";
		Library library = new Library();
		int option;
		do {
			System.out.println(BOLD + "=== LIBRARY MENU ===" + RESET);
			System.out.println("1 - Register book");
			System.out.println("2 - Register user");
			System.out.println("3 - Borrow book");
			System.out.println("4 - Return book");
			System.out.println("5 - List books");
			System.out.println("6 - Quit");
			System.out.println();
			System.out.print("Option: ");
			option = sc.nextInt();
			sc.nextLine();
			switch (option) {
			case 1:
				System.out.print("Book's ID: ");
				Integer id = sc.nextInt();
				sc.nextLine();
				System.out.print("Book title: ");
				String title = sc.nextLine();
				System.out.print("Author: ");
				String author = sc.nextLine();
				library.booksRegister(new Books(id, title, author, Status.AVAILABLE));
				System.out.println("Book registered successfully.");
				System.out.println();
				break;

			case 2:
				System.out.print("User's ID: ");
				Integer idUser = sc.nextInt();
				sc.nextLine();
				System.out.print("User name: ");
				String name = sc.nextLine();

				library.userRegister(new Users(idUser, name));

				System.out.println("User registered successfully");
				System.out.println();
				break;
			case 3:
				System.out.print("ID para o empréstimo: ");
				int idEmp = sc.nextInt();
				sc.nextLine();
				library.loan(idEmp);
				System.out.println();
				break;
			case 4:
				System.out.print("ID para a devolução : ");
				int idDev = sc.nextInt();
				library.returnBook(idDev);
				System.out.println();
				break;
			case 5:
				library.toListBooks();
				break;
			case 6:
				System.out.print("Ending... ");

				break;
			default:
				System.out.println("ERROR!");
			}
		} while (option != 6);

		sc.close();
	}

}
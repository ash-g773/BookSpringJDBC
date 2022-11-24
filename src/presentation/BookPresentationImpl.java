package presentation;

import java.util.Collection;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entity.Book;
import service.BookService;
import service.BookServiceImpl;

@Component("presentation")
public class BookPresentationImpl implements BookPresentation {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	public void setBookPresentationImpl(BookService bookService) {
		this.bookService = bookService;
	}

	@Override
	public void showMenu() {
		System.out.println("===========================");
		System.out.println("Book Management System");
		System.out.println("1. List All Books");
		System.out.println("2. Search Book By ID");
		System.out.println("3. Add New Book");
		System.out.println("4. Delete a Book");
		System.out.println("5. Update number of copies");
		System.out.println("6. Exit");
		System.out.println("============================");

	}
	
	@Override
	public void performMenu(int choice) {
		Scanner scr = new Scanner(System.in);
		
		switch(choice) {
			case 1:
				Collection<Book> books = bookService.getAllBooks();
				for (Book book : books) {
					System.out.println(book);
				}
				break;
			case 2:
				System.out.println("Enter Book ID :");
				int id = scr.nextInt();
				Book book = bookService.searchBookById(id);
				if (book!=null) {
					System.out.println(book);
				} else {
					System.out.println("Book with ID " + id + " does not exist in our database");
				}
				break;
			case 3:
				Book newBook = new Book();
				
				System.out.println("Enter Book ID :");
				newBook.setBookId(scr.nextInt());
				System.out.println("Enter Book title");
				newBook.setBookName(scr.next());
				System.out.println("Enter Author name");
				newBook.setAuthorName(scr.next());
				System.out.println("Enter number of book copies");
				newBook.setNoOfCopies(scr.nextInt());
				
				if (bookService.addNewBook(newBook))
					System.out.println("Book has been added");
				else
					System.out.println("Book with ID " + newBook.getBookId() + " already exists");
				break;
			case 4:
				System.out.println("Enter Book ID : ");
				int bId=scr.nextInt();
				if(bookService.deleteBook(bId))
					System.out.println("Book with ID " + bId + " has been deleted");
				else
					System.out.println("Book with ID " + bId + " does not exist");
				break;
			case 5:
				System.out.println("Enter Book ID : ");
				int bId2 = scr.nextInt();
				System.out.println("Enter change in num of copies (+/-): ");
				int change = scr.nextInt();
				
				if (bookService.updateCopies(bId2, change))
					System.out.println("Book with ID " + bId2 + " now has " 
				+ bookService.searchBookById(bId2).getNoOfCopies() + " copies");
				else
					System.out.println("Book with ID " + bId2 + " could not be updated.");
				break;
			case 6:
				System.out.println("Thanks for using our Book Management System!");
				System.exit(0); 
			default:
				System.out.println("unknown input");
				break;
				
	}
	}
	

}

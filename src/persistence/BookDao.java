package persistence;

import java.util.Collection;

import entity.Book;



public interface BookDao {

	Collection<Book> getAllBooks();
	Book searchBook(int id);
	int insertBook(Book book);
	int deleteRecord(int id);
	int updateCopies(int id, int increment);
}
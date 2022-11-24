package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Book;
import persistence.BookDaoImpl;

class BookDaoTest {
	
	BookDaoImpl bookDaoImpl;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		bookDaoImpl = new BookDaoImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
		bookDaoImpl = null;
	}

	@Test
	void testGetAllBooks() {
		assertTrue(bookDaoImpl.getAllBooks().size()>0);
	}
	
	@Test
	void testInsertBook() {
		assertEquals(1, bookDaoImpl.insertBook(new Book(108, "title", "author", 10000)));
	}
	
	@Test
	void testSearchBook() {
		assertEquals(new Book(), bookDaoImpl.searchBook(101));
	}
	
	@Test
	void testDeleteBook() {
		assertEquals(1, bookDaoImpl.deleteRecord(108));
	}

}

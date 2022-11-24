package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import entity.Book;

public class BookRowMapper implements RowMapper<Book>{
	
	@Override
	public Book mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		
		int bookid = resultSet.getInt("BOOKID");
		String title = resultSet.getString("TITLE");
		String author = resultSet.getString("AUTHOR_NAME");
		int copies = resultSet.getInt("NUMOFCOPIES");
		
		Book book = new Book(bookid, title, author, copies);
		
		return book;
	}
	
	

}

package com.enriquemedina.JavaCorePractice.Datase.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookStoreService {
	private Connection connection = null;
	
	public void persistObjectGraph(Book book) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","root","password");
			
			PreparedStatement stmnt = connection.prepareStatement("INSERT INTO BOOK (ISBN, BOOK_NAME, PUBLISHER_CODE) VALUES (?,?,?)");
			stmnt.setString(1, book.id);
			stmnt.setString(2, book.publisher);
			stmnt.executeUpdate();
			stmnt.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}


class Book{
	String id;
	String publisher;
}
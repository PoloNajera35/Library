package com.libraryupa.dao;

import com.libraryupa.model.Book;
import com.libraryupa.util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String query = "SELECT id, title, author, isbn, available FROM Books";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                books.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("isbn"),
                        rs.getBoolean("available")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error getting books:");
            e.printStackTrace();
        }
        return books;
    }

    public void addBook(Book book) {
        String query = "INSERT INTO Books (title, author, isbn, available) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            if (conn == null) return;

            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getIsbn());
            pstmt.setBoolean(4, book.isAvailable());

            int rowsAffected = pstmt.executeUpdate();
            System.out.println(">> Book added! Rows affected: " + rowsAffected);

        } catch (SQLException e) {
            System.out.println("Error adding book:");
            e.printStackTrace();
        }
    }

    public void deleteBook(int bookId) {
        String query = "DELETE FROM Books WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            if (conn == null) return;

            pstmt.setInt(1, bookId);
            pstmt.executeUpdate();
            System.out.println(">> Book deleted with ID: " + bookId);

        } catch (SQLException e) {
            System.out.println("Error deleting book:");
            e.printStackTrace();
        }
    }
}
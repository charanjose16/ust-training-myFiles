package com.bookstoreapp.repository;

import com.bookstoreapp.model.Book;
import com.bookstoreapp.util.JdbcConnectionUtil;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepositoryImpl implements BookRepository {

    Connection connection= JdbcConnectionUtil.createConnection();
    @Override
    public List<Book> findAll() {
        String sql="select * from book_store";
        Book book=null;
        List<Book> books=new ArrayList<>();
        try {
            PreparedStatement statement= connection.prepareStatement(sql);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String title=resultSet.getString("title");
                String author= resultSet.getString("author");
                int publication_year=resultSet.getInt("publication_year");
                long isbn=resultSet.getLong("isbn");
                double price=resultSet.getDouble("price");
                book=new Book(id,title,author,publication_year,isbn,price);
                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    @Override
    public Optional<Book> findById(int id) {
        String sql="select * from book_store where id=?";
        Book book=null;

        try {
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next()){
                String title=resultSet.getString("title");
                String author= resultSet.getString("author");
                int publication_year=resultSet.getInt("publication_year");
                long isbn=resultSet.getLong("isbn");
                double price=resultSet.getDouble("price");
                book=new Book(id,title,author,publication_year,isbn,price);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(book);
    }

    @Override
    public Book save(Book book) {
        String sql="insert into book_store(title,author,publication_year,isbn,price) values(?,?,?,?,?)";

        try {
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3,book.getPublicationYear());
            statement.setLong(4,book.getIsbn());
            statement.setDouble(5,book.getPrice());

            int rowCount= statement.executeUpdate();
            System.out.println(rowCount+ "rows inserted");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return book;
    }

    @Override
    public void deleteById(int id) {
        String sql="delete from book_store where id=?";
        try {
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.executeUpdate();
            System.out.println("Book deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Book update(Book book) {
        String sql="update book_store set id=?,title=?,author=?,publication_year=?,isbn=?,price=? where id=?";
        try {
            PreparedStatement statement= connection.prepareStatement(sql);
            statement.setInt(1,book.getId());
            statement.setString(2,book.getTitle());
            statement.setString(3,book.getAuthor());
            statement.setInt(4,book.getPublicationYear());
            statement.setLong(5,book.getIsbn());
            statement.setDouble(6,book.getPrice());
            statement.setInt(7,book.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }
}

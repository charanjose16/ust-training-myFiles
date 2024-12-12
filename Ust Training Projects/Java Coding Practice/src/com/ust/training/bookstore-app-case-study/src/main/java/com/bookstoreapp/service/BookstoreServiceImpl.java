package com.bookstoreapp.service;

import com.bookstoreapp.exception.BookAlreadyExistsException;
import com.bookstoreapp.exception.BookNotFoundException;
import com.bookstoreapp.model.Book;
import com.bookstoreapp.repository.BookRepository;
import com.bookstoreapp.repository.BookRepositoryImpl;


import java.util.List;
import java.util.Optional;


public class BookstoreServiceImpl implements BookstoreService{


   BookRepository bookRepository=new BookRepositoryImpl();



    @Override
    public List<Book> getAllBooks() {
        return  bookRepository.findAll();
    }

    @Override
    public Book getBookById(int id) {
      return bookRepository.findById(id).orElseThrow(()->new BookNotFoundException("Book not present in store"));
    }

    @Override
    public Book saveBook(Book book) {

        Optional<Book> isBookPresent=bookRepository.findById(book.getId());
        if(isBookPresent.isPresent()){
            throw new BookAlreadyExistsException("Book already exist");
        }
        else {
            return bookRepository.save(book);
        }
    }

    @Override
    public Book updateBook(int id, Book book) {

        Optional<Book> isBookPresent=bookRepository.findById(book.getId());
        if(isBookPresent.isPresent()){
            bookRepository.update(book);
            System.out.println("Book updated");
        }
        else{
            throw  new BookNotFoundException("Book not present in book store");
        }
        return book;
    }

    @Override
    public void deleteBook(int id) {

        Optional<Book> isBookPresent=bookRepository.findById(id);
        if(isBookPresent.isPresent()){
            bookRepository.deleteById(id);
        }
        else {
            throw new BookNotFoundException("Book not present in book store");
        }

    }


}

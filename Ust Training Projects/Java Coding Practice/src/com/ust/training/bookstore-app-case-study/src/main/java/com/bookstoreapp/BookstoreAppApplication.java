package com.bookstoreapp;

import com.bookstoreapp.model.Book;
import com.bookstoreapp.service.BookstoreService;
import com.bookstoreapp.service.BookstoreServiceImpl;

public class BookstoreAppApplication {

	public static void main(String[] args) {
		BookstoreService service=new BookstoreServiceImpl();
		Book book=new Book(1,"SPD Emergency","S.H Charan",2009,768727568583L,1100.00);
////
//		service.saveBook(book);
//		System.out.println(service.getBookById(1));
//		service.getAllBooks().forEach(System.out::println);
//service.deleteBook(5);
		service.updateBook(1,book);
	}

}

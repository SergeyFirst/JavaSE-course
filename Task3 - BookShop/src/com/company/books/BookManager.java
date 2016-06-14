package com.company.books;

import java.util.ArrayList;
import java.util.List;


public class BookManager {

    private static final BooksList storage = new BooksList();

    public static Book createBook(String name, String author) {
        Book result = new InternalBook(name, author);
        return result;
    }

    public static List<Book> findBooksByName(String bookName){
        List<Book> result = new ArrayList<Book>();

        //Не оптимальный поиск
        for(Book book : storage.list){
            if (book.name.contentEquals(bookName)){
                result.add(book);
            }
        }

        return result;
    }

    public static List<Book> findBooksByAuthor(String author){
        List<Book> result = new ArrayList<Book>();

        //Не оптимальный поиск
        for(Book book : storage.list){
            if (book.author.contentEquals(author)){
                result.add(book);
            }
        }

        return result;
    }

    public static Book findBook(String name, String author){
        Book result = null;
        for(Book book : storage.list){
            if (book.name.contentEquals(name) && book.author.contentEquals(author)){
                result = book;
                break;
            }
        }
        return result;
    }

    public static List<Book> getAllBooks(){
        return storage.list;
    }

    public static void saveBook(Book book){
        if ((!storage.list.contains(book)) && (findBook(book.name, book.author) == null)){
            storage.list.add(book);
        }
    }

    public static void removeBook(Book book) {
        if (storage.list.contains(book)){
            storage.list.remove(book);
        }
    }

}

class InternalBook extends Book {

    public InternalBook(String name, String author) {
        super(name, author);
    }
}
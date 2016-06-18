package com.company.orders;

import com.company.books.Book;

public class ItemListOfBooks {
    Book book;
    float prise;
    int quantity;
    float sum;

    public ItemListOfBooks(Book book, int quantity){
        this.book = book;
        this.prise = book.getPrice();
        this.quantity = quantity;
        this.sum = prise * quantity;
    }
}

package com.company.books;

public abstract class Book {

    public String name;
    public String author;
    public int numberOfPages;
    public float price;

    public Book(String name, String author){
        this.name = name;
        this.author = author;
    }

    public void save(){
        BookManager.saveBook(this);
    }

}

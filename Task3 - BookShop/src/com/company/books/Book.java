package com.company.books;

import com.company.basic.entitys.AbstractEntity;

public class Book extends AbstractEntity {

    //Название книги
    private String name;
    //Автор
    private String author;
    //Число старниц
    private int numberOfPages;
    //Цена
    private float price;

    public Book(String name, String author){
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}

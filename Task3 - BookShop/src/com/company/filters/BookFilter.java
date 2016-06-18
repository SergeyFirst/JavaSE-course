package com.company.filters;

import com.company.basic.entitys.AbstractFilter;

public class BookFilter extends AbstractFilter{

    //Название книги
    private String name;
    //Автор
    private String author;
    //Число старниц
    private int numberOfPages;
    //Цена
    private float price;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

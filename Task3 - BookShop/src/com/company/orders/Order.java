package com.company.orders;

import com.company.basic.entitys.AbstractEntity;
import com.company.users.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order extends AbstractEntity{
    private Date data;
    private int number;
    private User user;
    private float total;
    private List<ItemListOfBooks> listOfBooks = new ArrayList<ItemListOfBooks>();

    public Order(){
        data = new Date();
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<ItemListOfBooks> getListOfBooks() {
        return listOfBooks;
    }

    public void setListOfBooks(List<ItemListOfBooks> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }
}
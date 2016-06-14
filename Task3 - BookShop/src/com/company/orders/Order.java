package com.company.orders;

import com.company.books.Book;
import com.company.users.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Order {
    public Date data;
    public int number;
    public User user;
    public float total;
    public final List<ItemListOfBooks> listOfBooks = new ArrayList<ItemListOfBooks>();

    public Order(){
        data = new Date();
        number = 0;
        //автонумерация заказов
        for(Order order : OrderManager.getAllOrders()){
            number = (order.number > number) ? order.number : number;
        }
        number++;
    }

    public void addItemListOfBook(Book book, int quantity){
        ItemListOfBooks item = new ItemListOfBooks(book, quantity);
        listOfBooks.add(item);
        total =+ item.sum;
    }

    public void removeItemListOfBook(int index){
        total =- listOfBooks.get(index).sum;
        listOfBooks.remove(index);
    }

    public void print(){
        System.out.println("********************************");
        System.out.printf("Заказ № %d от %s\n", number, data.toString());
        System.out.printf("Контрагент: %s %s\n", user.firstName, user.lastName);
        for (ItemListOfBooks item : listOfBooks){
            System.out.printf("Книга: %1s, Количество: %2d, Цена: %3$15.2f, Сумма: %4$15.2f\n", item.book.name, item.quantity, item.prise, item.sum);
        }
        System.out.printf("Итого: %1$15.2f\n", total);
        System.out.println("********************************");
    }

    public void save(){
        OrderManager.saveOrder(this);
    }
}
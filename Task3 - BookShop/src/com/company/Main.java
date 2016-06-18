package com.company;

import com.company.exception.BussinesException;
import com.company.books.*;
import com.company.orders.*;
import com.company.users.*;

public class Main {

    public static void main(String[] args) throws BussinesException {


        //Работа с книгами
        BookManager bookManager = new BookManager();

        Book newBook = new Book("Война и мир", "Лев Толстой");
        newBook.setNumberOfPages(1500);
        newBook.setPrice(500);

        bookManager.add(newBook);

        Book myBook = (Book) bookManager.get(2L);
        System.out.println(myBook.getName());

        //Работа с пользователями
        UserManager userManager = new UserManager();

        User newUser = new User("Иван", "Иванов");
        userManager.add(newUser);

        //Работа с заказами
        OrderManager orderManager = new OrderManager();

        Order newOrder = new Order();
        orderManager.add(newOrder);

    }
}

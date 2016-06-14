package com.company;

import com.company.books.*;
import com.company.orders.*;
import com.company.users.*;

public class Main {

    public static void main(String[] args) {

        //Заполнение списка книг
        Book editBook = BookManager.createBook("Война и мир", "Лев Толстой");
        editBook.numberOfPages = 1500;
        editBook.price = 500;
        editBook.save();

        BookManager.createBook("Анна Каренина","Лев Толстой").save();
        BookManager.createBook("Руслан и Людмила","Александр Пушкин").save();
        BookManager.createBook("Кавказская пленница","Александр Пушкин").save();

        BookManager.findBook("Руслан и Людмила","Александр Пушкин").price = 400;

        //Поиск по автору и вывод списка
        System.out.println("Книги Льва Толстого:");
        for (Book book : BookManager.findBooksByAuthor("Лев Толстой")) {
            System.out.printf("Название: %s, Автор: %s, Число страниц: %d\n", book.name, book.author, book.numberOfPages);
        }

        //Редактирование книги
        editBook = BookManager.findBook("Кавказская пленница","Александр Пушкин");
        editBook.numberOfPages = 300;
        editBook.save();

        //Поиск по автору и вывод списка
        System.out.println("Книги Александра Пушкина:");
        for (Book book : BookManager.findBooksByAuthor("Александр Пушкин")) {
            System.out.printf("Название: %s, Автор: %s, Число страниц: %d\n", book.name, book.author, book.numberOfPages);
        }

        UserManager.createUser("Иван","Иванов").save();
        UserManager.createUser("Петр","Петров").save();
        UserManager.createUser("Сидор","Сидоров").save();

        //Вывод всех пользователей
        System.out.println("Пользователи:");
        for (User user : UserManager.getAllUsers()) {
            System.out.printf("Имя: %s, Фамилия: %s\n", user.firstName, user.lastName);
        }

        //Создание, заполнение и печать заказа
        Order order = OrderManager.createOrder();
        order.user = UserManager.findUser("Сидор","Сидоров");
        order.addItemListOfBook(BookManager.findBook("Война и мир", "Лев Толстой"), 1);
        order.addItemListOfBook(BookManager.findBook("Руслан и Людмила","Александр Пушкин"),1);
        order.save();
        order.print();

    }
}

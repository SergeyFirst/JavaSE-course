package com.company.orders;

import java.util.Date;
import java.util.List;

public class OrderManager {

    private static final OrderList storage = new OrderList();

    public static Order createOrder() {
        Order result = new InternalOrder();
        return result;
    }

    public static Order findOrder(int number, Date data){
        Order result = null;
        for(Order order : storage.list){
            if ((order.number == number) && order.data.equals(data)){
                result = order;
                break;
            }
        }
        return result;
    }


    public static List<Order> getAllOrders(){
        return storage.list;
    }

    public static void saveOrder(Order order){
        if (!(storage.list.contains(order)) && (findOrder(order.number, order.data) == null)){
            storage.list.add(order);
        }
    }

    public static void removeUser(Order order) {
        if (storage.list.contains(order)){
            storage.list.remove(order);
        }
    }

}


class InternalOrder extends Order {

}
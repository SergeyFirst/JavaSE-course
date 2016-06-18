package com.company.filters;

import com.company.basic.entitys.AbstractFilter;
import com.company.users.User;
import java.util.Date;

public class OrderFilter extends AbstractFilter{
    private Date data;
    private int number;
    private User user;
    private float total;

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
}

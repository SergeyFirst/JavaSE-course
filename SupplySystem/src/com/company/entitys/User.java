package com.company.entitys;

import com.company.abstractions.Catalog;
import java.util.ArrayList;

@DBAnnotation(tableName = "users")
public class User extends Catalog{

    @DBAnnotation(colomnName = "firstName", getter = "getFirstName", setter = "setFirstName")
    private String firstName;

    @DBAnnotation(colomnName = "lastName", getter = "getLastName", setter = "setLastName")
    private String lastName;

    @DBAnnotation(colomnName = "login", getter = "getLogin", setter = "setLogin")
    private String login;

    @DBAnnotation(colomnName = "password", getter = "getPassword", setter = "setPassword")
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

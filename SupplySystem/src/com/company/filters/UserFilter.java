package com.company.filters;

import com.company.entitys.DBAnnotation;

public class UserFilter extends Filter{

    @DBAnnotation (colomnName = "firstName")
    public String firstName;

    @DBAnnotation (colomnName = "lastName")
    public String lastName;

    @DBAnnotation (colomnName = "login")
    public String login;

    public UserFilter() {
        super();
    }

    public UserFilter(String firstName, String lastName, String login) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
    }
}

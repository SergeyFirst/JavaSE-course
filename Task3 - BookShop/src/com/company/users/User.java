package com.company.users;

public abstract class User {
    public String firstName;
    public String lastName;

    public User(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void save(){
        UserManager.saveUser(this);
    }
}

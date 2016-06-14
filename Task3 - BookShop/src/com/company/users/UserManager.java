package com.company.users;

import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private static final UsersList storage = new UsersList();

    public static User createUser(String firstName, String lastName) {
        User result = new InternalUser(firstName, lastName);
        return result;
    }

    public static List<User> findUsersByFirstName(String firstName){
        List<User> result = new ArrayList<User>();

        //Не оптимальный поиск
        for(User user : storage.list){
            if (user.firstName.contentEquals(firstName)){
                result.add(user);
            }
        }

        return result;
    }

    public static User findUser(String firstName, String lastName){
        User result = null;
        for(User user : storage.list){
            if (user.firstName.contentEquals(firstName) && user.lastName.contentEquals(lastName)){
                result = user;
                break;
            }
        }
        return result;
    }

    public static List<User> getAllUsers(){
        return storage.list;
    }

    public static void saveUser(User user){
        if (!(storage.list.contains(user)) && (findUser(user.firstName, user.lastName) == null)){
            storage.list.add(user);
        }
    }

    public static void removeUser(User user) {
        if (storage.list.contains(user)){
            storage.list.remove(user);
        }
    }
}

class InternalUser extends User {

    public InternalUser(String firstName, String lastName) {
        super(firstName, lastName);
    }

}
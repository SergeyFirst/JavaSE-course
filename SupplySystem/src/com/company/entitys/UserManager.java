package com.company.entitys;

import com.company.abstractions.CatalogManager;

public class UserManager extends CatalogManager<User>{

    public UserManager() {
        super(User.class);
    }

}

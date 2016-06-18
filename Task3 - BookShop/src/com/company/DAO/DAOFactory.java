package com.company.DAO;

public class DAOFactory {

    public static InterfaceDAO getDAO(Class entityClass) {
        return new FileDAO(entityClass);
    }

}

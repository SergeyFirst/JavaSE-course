package com.company.dao;

import com.company.abstractions.Catalog;

public class DAOFactory<E extends Catalog> {

    public InterfaceDAO getDAO(Class daoClass) {
        return new PostgreSQLDAO<E>(daoClass);
    }
}

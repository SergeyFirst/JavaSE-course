package com.company.dao;

import com.company.abstractions.Catalog;
import com.company.filters.Filter;
import com.company.exceptions.DAOException;
import java.util.ArrayList;

public interface InterfaceDAO<E extends Catalog> {

    public int add(E entity) throws DAOException;
    public void update(E entity) throws DAOException;
    public void delete(int ID) throws DAOException;
    public E get(int ID) throws DAOException, IllegalAccessException, InstantiationException;
    public ArrayList<E> find(Filter filter) throws DAOException, IllegalAccessException, InstantiationException;

}

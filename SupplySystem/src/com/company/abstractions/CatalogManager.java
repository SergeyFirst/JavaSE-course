package com.company.abstractions;

import com.company.dao.DAOFactory;
import com.company.dao.InterfaceDAO;
import com.company.exceptions.BusinessException;
import com.company.exceptions.DAOException;
import com.company.filters.Filter;

import java.util.ArrayList;

public abstract class CatalogManager <E extends Catalog>{

    private InterfaceDAO<E> dao;

    public CatalogManager(Class daoClass) {
        DAOFactory<E> daoFactory = new DAOFactory<E>();
        this.dao = (InterfaceDAO<E>) daoFactory.getDAO(daoClass);
    }

    public int add(E entity) throws BusinessException {
        try {
            return dao.add(entity);
        } catch (DAOException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public void update(E entity) throws BusinessException {
        try {
            dao.update(entity);
        } catch (DAOException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public void delete(int ID) throws BusinessException {
        try {
            dao.delete(ID);
        } catch (DAOException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public E get(int ID) throws BusinessException {
        try {
            return dao.get(ID);
        } catch (DAOException e) {
            throw new BusinessException(e.getMessage());
        } catch (InstantiationException e) {
            throw new BusinessException(e.getMessage());
        } catch (IllegalAccessException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public ArrayList<E> find(Filter filter) throws BusinessException {
        try {
            return dao.find(filter);
        } catch (DAOException e) {
            throw new BusinessException(e.getMessage());
        } catch (InstantiationException e) {
            throw new BusinessException(e.getMessage());
        } catch (IllegalAccessException e) {
            throw new BusinessException(e.getMessage());
        }
    }

}

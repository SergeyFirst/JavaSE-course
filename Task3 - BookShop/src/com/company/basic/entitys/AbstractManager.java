package com.company.basic.entitys;

import com.company.DAO.DAOFactory;
import com.company.DAO.InterfaceDAO;
import com.company.exceptions.BussinesException;
import com.company.exceptions.DAOException;

import java.util.List;

public abstract class AbstractManager {

    private InterfaceDAO dao;
    private Class entityClass;

    public AbstractManager(Class entityClass) {
        this.entityClass = entityClass;
        this.dao = (InterfaceDAO) DAOFactory.getDAO(entityClass);
    }

    public Long add(AbstractEntity entity) throws BussinesException{
        if (entity.getClass() != entityClass) {
            System.out.println("Несоответствие типов добавляемого объекта");
            throw new BussinesException();
        }
        try {
            return dao.add(entity);
        } catch (DAOException e) {
            throw new BussinesException();
        }
    }

    public void update(AbstractEntity entity) throws BussinesException {
        if (entity.getClass() != entityClass) {
            System.out.println("Несоответствие типов обновляемого объекта");
            throw new BussinesException();
        }
        try {
            dao.update(entity);
        } catch (DAOException e) {
            throw new BussinesException();
        }
    }

    public void delete(Long ID) throws BussinesException {
        try {
            dao.delete(ID);
        } catch (DAOException e) {
            throw new BussinesException();
        }
    }

    public AbstractEntity get(Long ID) throws BussinesException {
        try {
            return dao.get(ID);
        } catch (DAOException e) {
            throw new BussinesException();
        }
    }

    public List<AbstractEntity> find(AbstractFilter filter) throws BussinesException {
        try {
            return dao.find(filter);
        } catch (DAOException e) {
            throw new BussinesException();
        }
    }
}

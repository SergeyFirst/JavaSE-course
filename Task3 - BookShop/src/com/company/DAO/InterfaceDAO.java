package com.company.DAO;

import com.company.exceptions.DAOException;
import com.company.basic.entitys.AbstractEntity;
import com.company.basic.entitys.AbstractFilter;

import java.util.List;

public interface InterfaceDAO {
    public Class getEntityClass();
    public Long add(AbstractEntity entity) throws DAOException;
    public void update(AbstractEntity entity) throws DAOException;
    public void delete(Long ID) throws DAOException;
    public AbstractEntity get(Long ID) throws DAOException;
    public List<AbstractEntity> find(AbstractFilter filter) throws DAOException;
}

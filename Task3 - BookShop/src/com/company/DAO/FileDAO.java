package com.company.DAO;

import com.company.exceptions.DAOException;
import com.company.basic.entitys.AbstractEntity;
import com.company.basic.entitys.AbstractFilter;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class FileDAO implements InterfaceDAO {

    private Class entityClass;

    public FileDAO(Class entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public Class getEntityClass() {
        return entityClass;
    }

    @Override
    public Long add(AbstractEntity entity) throws DAOException {

        List <AbstractEntity> fileList = new ArrayList<AbstractEntity>();

        //Прочитаем файл и найдём максимальный ID
        Long maxID = 0L;

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(entityClass.getSimpleName()+".dat"));){
            AbstractEntity object = null;
            while (true) {
                try {
                    object = (AbstractEntity) input.readObject();
                    fileList.add(object);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    throw new DAOException();
                } catch (IOException e) {
                    break; //Конец файла
                }
                maxID = (maxID > object.getID()) ? maxID : object.getID();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new DAOException();
        }

        entity.setID(maxID + 1);
        fileList.add(entity);

        //Запишем файл
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(entityClass.getSimpleName()+".dat"));) {
            for (AbstractEntity item : fileList) {
                out.writeObject(item);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DAOException();
        }

        return entity.getID();
    }

    @Override
    public void update(AbstractEntity entity) throws DAOException{

        List <AbstractEntity> fileList = new ArrayList<AbstractEntity>();

        //Прочитаем файл и исключим объект с нужным ID
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(entityClass.getSimpleName()+".dat"));){
            AbstractEntity object = null;
            while (true) {
                try {
                    object = (AbstractEntity) input.readObject();
                    if (!object.getID().equals(entity.getID())) {
                        fileList.add(entity);
                    } else {
                        fileList.add(object);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    throw new DAOException();
                } catch (IOException e) {
                    break; //Конец файла
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new DAOException();
        }

        //Запишем файл
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(entityClass.getSimpleName()+".dat"));) {
            for (AbstractEntity item : fileList) {
                out.writeObject(item);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DAOException();
        }
    }

    @Override
    public void delete(Long ID) throws DAOException{

        List <AbstractEntity> fileList = new ArrayList<AbstractEntity>();

        //Прочитаем файл и исключим объект с нужным ID
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(entityClass.getSimpleName()+".dat"));){
            AbstractEntity object = null;
            while (true) {
                try {
                    object = (AbstractEntity) input.readObject();
                    if (!object.getID().equals(ID)) {
                        fileList.add(object);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    throw new DAOException();
                } catch (IOException e) {
                    break; //Конец файла
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new DAOException();
        }

        //Запишем файл
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(entityClass.getSimpleName()+".dat"));) {
            for (AbstractEntity item : fileList) {
                out.writeObject(item);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DAOException();
        }
    }

    @Override
    public AbstractEntity get(Long ID) throws DAOException{

        AbstractEntity result = null;

        //Прочитаем файл и найдём объект с нужным ID
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(entityClass.getSimpleName()+".dat"));){
            AbstractEntity object = null;
            while (true) {
                try {
                    object = (AbstractEntity) input.readObject();
                    if (object.getID().equals(ID)) {
                        result = object;
                        break;
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    throw new DAOException();
                } catch (IOException e) {
                    break; //Конец файла
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new DAOException();
        }

        return result;
    }

    @Override
    public List<AbstractEntity> find(AbstractFilter filter) throws DAOException{

        List <AbstractEntity> fileList = new ArrayList<AbstractEntity>();

        //Прочитаем файл
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(entityClass.getSimpleName()+".dat"));){
            AbstractEntity object = null;
            while (true) {
                try {
                    object = (AbstractEntity) input.readObject();
                    fileList.add(object);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    throw new DAOException();
                } catch (IOException e) {
                    break; //Конец файла
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new DAOException();
        }

        return fileList;
    }
}

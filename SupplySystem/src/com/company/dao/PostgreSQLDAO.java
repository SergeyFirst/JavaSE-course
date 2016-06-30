package com.company.dao;

import com.company.abstractions.Catalog;
import com.company.config.Settings;
import com.company.entitys.DBAnnotation;
import com.company.exceptions.DAOException;
import com.company.filters.Filter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;

public class PostgreSQLDAO<E extends Catalog> implements InterfaceDAO<E> {

    private static Connection DBConnection;
    private static Class daoClass;

    public PostgreSQLDAO(Class daoClass) {
        this.daoClass = daoClass;
    }

    public Connection getConnectionToDB() throws DAOException {

        if (DBConnection == null) {
            try {
                Class.forName(Settings.getProperty(Settings.DB_CLASS_NAME));

                String url = Settings.getProperty(Settings.DB_URL);
                String login = Settings.getProperty(Settings.DB_LOGIN);
                String password = Settings.getProperty(Settings.DB_PASSWORD);
                DBConnection = DriverManager.getConnection(url, login, password);

            } catch (ClassNotFoundException | SQLException e) {
                throw new DAOException(e.getMessage());
            }
        }
        return DBConnection;
    }

    @Override
    public int add(E entity) throws DAOException {

        int result = 0;

        //Определеим структуру класса
        DBAnnotation classAnnotation = (DBAnnotation) daoClass.getAnnotation(DBAnnotation.class);
        Field[] fields = daoClass.getDeclaredFields();

        Connection connection = getConnectionToDB();

        //Формируем текст запроса
        StringBuilder sql = new StringBuilder("INSERT INTO ")
                .append(classAnnotation.tableName()).append("(");
        boolean isItFirstField = true;
        StringBuilder colomnNames = new StringBuilder("");
        StringBuilder values = new StringBuilder("");
        for (Field field : fields) {
            DBAnnotation fieldAnnotation = field.getAnnotation(DBAnnotation.class);
            colomnNames.append(isItFirstField ? "" : ", ")
                    .append("\"").append(fieldAnnotation.colomnName()).append("\"");
            values.append(isItFirstField ? "" : ", ").append("?");
            isItFirstField = false;
        }
        sql.append(colomnNames).append(") VALUES (").append(values).append(")");

        try {
            PreparedStatement statement = connection.prepareStatement(sql.toString(), new String[]{"id"});
            int count = 1;
            //Заполняем параметры запроса
            for (Field field : fields) {
                DBAnnotation fieldAnnotation = field.getAnnotation(DBAnnotation.class);
                try {
                    Method getter = daoClass.getMethod(fieldAnnotation.getter());
                    statement.setObject(count, getter.invoke(entity));
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    throw new DAOException(e.getMessage());
                }
                count++;
            }

            statement.executeUpdate();
            //Получаем ID записанного объекта
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                result = generatedKeys.getInt("id");
            }
            generatedKeys.close();
            statement.close();
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }

        entity.setID(result);

        return result;
    }

    @Override
    public void update(E entity) throws DAOException {
        //Определеим структуру класса
        DBAnnotation classAnnotation = (DBAnnotation) daoClass.getAnnotation(DBAnnotation.class);
        Field[] fields = daoClass.getDeclaredFields();

        Connection connection = getConnectionToDB();

        //Формируем текст запроса
        StringBuilder sql = new StringBuilder("UPDATE ")
                .append(classAnnotation.tableName()).append(" SET");
        boolean isItFirstField = true;
        StringBuilder setString = new StringBuilder("");
        for (Field field : fields) {
            DBAnnotation fieldAnnotation = field.getAnnotation(DBAnnotation.class);
            setString.append(isItFirstField ? "" : ", ")
                    .append(" \"")
                    .append(fieldAnnotation.colomnName())
                    .append("\" = ?");
            isItFirstField = false;
        }
        sql.append(setString).append(" WHERE id = " + entity.getID());

        try {
            PreparedStatement statement = connection.prepareStatement(sql.toString());
            int count = 1;
            //Установка параметров запроса
            for (Field field : fields) {
                DBAnnotation fieldAnnotation = field.getAnnotation(DBAnnotation.class);
                try {
                    Method getter = daoClass.getMethod(fieldAnnotation.getter());
                    statement.setObject(count, getter.invoke(entity));
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    throw new DAOException(e.getMessage());
                }
                count++;
            }
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public void delete(int ID) throws DAOException {
        //Определеим структуру класса
        DBAnnotation classAnnotation = (DBAnnotation) daoClass.getAnnotation(DBAnnotation.class);

        Connection connection = getConnectionToDB();

        try {
            //Выполнение запроса
            String sql = "DELETE FROM " + classAnnotation.tableName() + " WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, ID);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public E get(int ID) throws DAOException, IllegalAccessException, InstantiationException {

        E result = (E) daoClass.newInstance();

        //Определеим структуру класса
        DBAnnotation classAnnotation = (DBAnnotation) daoClass.getAnnotation(DBAnnotation.class);
        Field[] fields = daoClass.getDeclaredFields();

        Connection connection = getConnectionToDB();

        try {
            //Выполнение запроса
            StringBuilder sql = new StringBuilder("SELECT * FROM ")
                    .append(classAnnotation.tableName()).append(" WHERE ID = ?");
            PreparedStatement statement = connection.prepareStatement(sql.toString());
            statement.setInt(1, ID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                //Обход полей объекта и заполнение нового объекта
                for (Field field : fields) {
                    DBAnnotation fieldAnnotation = field.getAnnotation(DBAnnotation.class);
                    String colomnName = fieldAnnotation.colomnName();
                    try {
                        Method method = daoClass.getMethod(fieldAnnotation.setter(), new Class[]{field.getType()});
                        Object[] arg = {resultSet.getObject(colomnName, field.getType())};
                        method.invoke(result, arg);
                    } catch (NoSuchMethodException e) {
                        throw new DAOException(e.getMessage());
                    } catch (InvocationTargetException e) {
                        throw new DAOException(e.getMessage());
                    }
                }
                //Глюк reflection - не видит скрытые поля родителя
                result.setID(resultSet.getInt("id"));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
        return result;
    }

    @Override
    public ArrayList<E> find(Filter filter) throws DAOException {

        ArrayList<E> result = new ArrayList<E>();

        //Определим структуру класса
        DBAnnotation classAnnotation = (DBAnnotation) daoClass.getAnnotation(DBAnnotation.class);
        Field[] fields = daoClass.getDeclaredFields();

        Connection connection = getConnectionToDB();

        //Подготовка текста запроса
        StringBuilder sql = new StringBuilder("SELECT * FROM ")
                .append(classAnnotation.tableName()).append(" WHERE ");
        Field[] filterFields = filter.getClass().getFields();
        boolean isItFirstField = true;
        for (Field filterField : filterFields) {
            try {
                if (filterField.get(filter) != null) {
                    DBAnnotation filterFieldAnnotation = filterField.getAnnotation(DBAnnotation.class);
                    sql.append(isItFirstField ? "" : " AND ")
                            .append(filterFieldAnnotation.colomnName()).append(" = ?");
                    isItFirstField = false;
                }
            } catch (IllegalAccessException e) {
                throw new DAOException(e.getMessage());
            }
        }
        sql.append(isItFirstField ? "TRUE" : "");
        sql.append(" ORDER BY id");

        try {
            //Выполнение запроса

            PreparedStatement statement = connection.prepareStatement(sql.toString());

            //Установка параметров фильтра
            int count = 1;
            for (Field filterField : filterFields) {
                if (filterField.get(filter) != null) {
                    statement.setObject(count, filterField.get(filter));
                    count++;
                }
            }
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                E newItem = (E) daoClass.newInstance();
                //обход полей объекта и заполнение нового обекта
                for (Field field : fields) {
                    DBAnnotation fieldAnnotation = field.getAnnotation(DBAnnotation.class);
                    String colomnName = fieldAnnotation.colomnName();
                    try {
                        Method method = daoClass.getMethod(fieldAnnotation.setter(), new Class[]{field.getType()});
                        Object[] arg = {resultSet.getObject(colomnName, field.getType())};
                        method.invoke(newItem, arg);
                    } catch (NoSuchMethodException e) {
                        throw new DAOException(e.getMessage());
                    } catch (InvocationTargetException e) {
                        throw new DAOException(e.getMessage());
                    }
                }
                //Глюк reflection - не видит скрытые поля родителя
                newItem.setID(resultSet.getInt("id"));
                result.add(newItem);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException | InstantiationException | IllegalAccessException e) {
            throw new DAOException(e.getMessage());
        }
        return result;
    }
}

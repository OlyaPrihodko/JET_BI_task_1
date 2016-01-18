package ie.globalcom.task_1.dao.impl;

import ie.globalcom.task_1.controller.listener.ContextServletListener;
import ie.globalcom.task_1.dao.DataBaseParameterName;
import ie.globalcom.task_1.dao.entity.ClazzDAO;
import ie.globalcom.task_1.entity.Clazz;
import ie.globalcom.task_1.exception.ConnectionPoolException;
import ie.globalcom.task_1.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MySQLClazzDAO implements ClazzDAO{
    private final static String getAllClasses = "select * from db_task_1.class";
    public Clazz getById(int domainId) throws DAOException{
        return new Clazz();
    }
    public void create(Clazz domain)  throws DAOException{

    }
    public void update (Clazz domain) throws DAOException{

    }
    public void delete (Clazz domain) throws DAOException{

    }
    public Map<Integer,Clazz> getAllMap()throws DAOException{
        Map<Integer, Clazz> mapClass = new HashMap<Integer, Clazz>();
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet =null;
        try{
            connection =  ContextServletListener.connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(getAllClasses);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(DataBaseParameterName.ID);
                String className = resultSet.getString(DataBaseParameterName.CLASS_NAME);
                Clazz clazz = new Clazz(id,className);
                mapClass.put(id, clazz);
            }
        }catch (SQLException e){
            throw new DAOException("MySQLClassDao has problem with Sql in getClassMap method",e);
        }catch (ConnectionPoolException e) {
            throw new DAOException("MySQLClassDao has problem with connection pool in getClassMap method",e);
        } finally {
            ContextServletListener.connectionPool.closeConnection(connection, preparedStatement,resultSet);
        }
        return mapClass;
    }
}
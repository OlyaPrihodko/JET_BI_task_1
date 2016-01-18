package ie.globalcom.task_1.dao.impl;

import ie.globalcom.task_1.controller.listener.ContextServletListener;
import ie.globalcom.task_1.dao.DataBaseParameterName;
import ie.globalcom.task_1.dao.entity.KeywordDAO;
import ie.globalcom.task_1.entity.Keyword;
import ie.globalcom.task_1.exception.ConnectionPoolException;
import ie.globalcom.task_1.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MySQLKeywordDAO implements KeywordDAO {
    private final static String getAllKeywords = "select * from db_task_1.keyword";
    private final static String getKeyword = "select * from db_task_1.keyword where keyword=?";
    public Keyword getByKeyword(String keyword) throws DAOException{
        Keyword keyWord = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        try{
            connection =  ContextServletListener.connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(getKeyword);
            preparedStatement.setString(1, keyword);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(DataBaseParameterName.ID);
                String key_word = resultSet.getString(DataBaseParameterName.KEYWORD);
                int bindedClass = resultSet.getInt(DataBaseParameterName.BINDED_CLASS);
                keyWord = new Keyword(id,key_word,bindedClass);
            }

        }catch (SQLException e){
            throw new DAOException("MySQLClassDao has problem with Sql in getClassMap method",e);
        }catch (ConnectionPoolException e) {
            throw new DAOException("MySQLClassDao has problem with connection pool in getClassMap method",e);
        } finally {
            ContextServletListener.connectionPool.closeConnection(connection, preparedStatement,resultSet);
        }
        return keyWord;
    }
    public void create(Keyword domain)  throws DAOException{

    }
    public void update (Keyword domain) throws DAOException{

    }
    public void delete (Keyword domain) throws DAOException{

    }

    public Map<Integer,Keyword> getAllMap()throws DAOException{
        Map<Integer, Keyword> mapKeyword = new HashMap<Integer, Keyword>();
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        try{
            connection =  ContextServletListener.connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(getAllKeywords);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(DataBaseParameterName.ID);
                String keyWord = resultSet.getString(DataBaseParameterName.KEYWORD);
                int bindedClass = resultSet.getInt(DataBaseParameterName.BINDED_CLASS);
                Keyword keyword = new Keyword(id,keyWord,bindedClass);
                mapKeyword.put(id, keyword);
            }
        }catch (SQLException e){
            throw new DAOException("MySQLClassDao has problem with Sql in getClassMap method",e);
        }catch (ConnectionPoolException e) {
            throw new DAOException("MySQLClassDao has problem with connection pool in getClassMap method",e);
        } finally {
            ContextServletListener.connectionPool.closeConnection(connection, preparedStatement,resultSet);
        }
        return mapKeyword;
    }
}

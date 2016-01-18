package ie.globalcom.task_1.dao;

import ie.globalcom.task_1.exception.DAOException;

import java.util.Map;

public interface GenericDAO <T>{
    public void create(T domain)  throws DAOException;
    public void update (T domain) throws DAOException;
    public void delete (T domain) throws DAOException;
    public Map<Integer,T> getAllMap()throws DAOException;

}

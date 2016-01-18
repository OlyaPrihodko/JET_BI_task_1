package ie.globalcom.task_1.dao.entity;

import ie.globalcom.task_1.dao.GenericDAO;
import ie.globalcom.task_1.entity.Clazz;
import ie.globalcom.task_1.exception.DAOException;

import java.util.Map;

public interface ClazzDAO  extends GenericDAO<Clazz> {

    public void create(Clazz domain)  throws DAOException;
    public void update (Clazz domain) throws DAOException;
    public void delete (Clazz domain) throws DAOException;
    public Map<Integer,Clazz> getAllMap()throws DAOException;
}

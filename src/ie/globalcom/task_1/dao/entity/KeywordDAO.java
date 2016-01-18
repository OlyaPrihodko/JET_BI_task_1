package ie.globalcom.task_1.dao.entity;

import ie.globalcom.task_1.dao.GenericDAO;
import ie.globalcom.task_1.entity.Keyword;
import ie.globalcom.task_1.exception.DAOException;

import java.util.Map;

public interface KeywordDAO extends GenericDAO<Keyword> {
    public Keyword getByKeyword(String keyword) throws DAOException;
    public void create(Keyword domain)  throws DAOException;
    public void update (Keyword domain) throws DAOException;
    public void delete (Keyword domain) throws DAOException;
    public Map<Integer,Keyword> getAllMap()throws DAOException;
}
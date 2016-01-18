package ie.globalcom.task_1.dao.factory;

import ie.globalcom.task_1.dao.entity.ClazzDAO;
import ie.globalcom.task_1.dao.entity.KeywordDAO;
import ie.globalcom.task_1.dao.impl.MySQLClazzDAO;
import ie.globalcom.task_1.dao.impl.MySQLKeywordDAO;

/**
 * Concrete factory
 * */
public class MySQLDAOFactory extends DAOFactory {

public ClazzDAO getClazzDAO(){
        return new MySQLClazzDAO();
        }
public KeywordDAO getKeywordDAO(){
        return new MySQLKeywordDAO();
        }
        }

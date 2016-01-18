package ie.globalcom.task_1.dao.factory;

import ie.globalcom.task_1.dao.entity.ClazzDAO;
import ie.globalcom.task_1.dao.entity.KeywordDAO;

public abstract class DAOFactory {
    private final static MySQLDAOFactory mySqlDAOFactory = new MySQLDAOFactory();
    /**Enum of DAO types supported by the factory*/
    public static enum DataSourceName{
        MYSQL
    }
    /**
     * There are methods for each DAO that can be created.
     * The concrete factories implement these methods
     * */
    public abstract ClazzDAO getClazzDAO();
    public abstract KeywordDAO getKeywordDAO();
    /**
     * Method that gets needed  DAOFactory
     * */
    public static DAOFactory getDAOFactory(DataSourceName dataSourceName ){
        switch (dataSourceName){
            case MYSQL:
                return mySqlDAOFactory;
            default:
                return null;
        }
    }
}
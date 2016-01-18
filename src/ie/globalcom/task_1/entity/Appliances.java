package ie.globalcom.task_1.entity;

import ie.globalcom.task_1.dao.entity.ClazzDAO;
import ie.globalcom.task_1.dao.entity.KeywordDAO;
import ie.globalcom.task_1.dao.factory.DAOFactory;
import ie.globalcom.task_1.exception.DAOException;
import ie.globalcom.task_1.exception.LogicException;

import java.util.HashMap;
import java.util.Map;

public class Appliances {
    private final static DAOFactory MySQLDaoFactory = DAOFactory.getDAOFactory(DAOFactory.DataSourceName.MYSQL);
    private final static ClazzDAO clazzDao = MySQLDaoFactory.getClazzDAO();
    private final static KeywordDAO keywordDao = MySQLDaoFactory.getKeywordDAO();
    private final static String OFF = "off";
    private static Appliances instance;
    private Map<String,String> appliancesMap;
    private Appliances() throws LogicException{
        try{
        this.appliancesMap = new HashMap<String,String>();
        Map <Integer,Keyword> keywordMap = keywordDao.getAllMap();
        Map <Integer,Clazz> clazzMap = clazzDao.getAllMap();
        //Map <String, String> mapAppl = new HashMap<String, String>();
        for(Map.Entry<Integer,Keyword> entry : keywordMap.entrySet()) {
            Keyword k = entry.getValue();
            Clazz cl = clazzMap.get(k.getBindedClass());
            this.appliancesMap.put(cl.getClassName(),OFF);
        }
        }catch (DAOException e){
            throw new LogicException("problem with dao",e);
        }
    }
    public Map< String,String> getAppliances() {
        return appliancesMap;
    }

    public void setAppliances(Map<String,String> appliances) {
        this.appliancesMap = appliances;
    }
    public void setElement(String str, String str1){
        this.appliancesMap.put(str,str1);
    }
    public String getElement (String str){
        return this.appliancesMap.get(str);
    }
    public static Appliances getInstance() throws LogicException{
        Appliances localInstance = instance;
        if (localInstance == null) {
            synchronized (Appliances.class) {
                localInstance = instance;
                if (localInstance == null) {
                    localInstance = new Appliances();
                    instance = localInstance;
                }
            }
        }
        return localInstance;
    }
}

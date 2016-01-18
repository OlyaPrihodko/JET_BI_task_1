package ie.globalcom.task_1.logic.impl;

import ie.globalcom.task_1.controller.JSPPageName;
import ie.globalcom.task_1.controller.RequestParameterName;
import ie.globalcom.task_1.dao.entity.ClazzDAO;
import ie.globalcom.task_1.dao.entity.KeywordDAO;
import ie.globalcom.task_1.dao.factory.DAOFactory;
import ie.globalcom.task_1.entity.Appliances;
import ie.globalcom.task_1.entity.Clazz;
import ie.globalcom.task_1.entity.Keyword;
import ie.globalcom.task_1.exception.DAOException;
import ie.globalcom.task_1.exception.LogicException;
import ie.globalcom.task_1.logic.ICommand;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.ResourceBundle;

public class SubmitCommand implements ICommand {

    private final static DAOFactory MySQLDaoFactory = DAOFactory.getDAOFactory(DAOFactory.DataSourceName.MYSQL);
    private final static ClazzDAO clazzDao = MySQLDaoFactory.getClazzDAO();
    private final static KeywordDAO keywordDao = MySQLDaoFactory.getKeywordDAO();
    private final static String message = ": I'm turn ";
    private final static String OFF = "off";
    private final static String ON = "on";
    @Override
    public String execute(HttpServletRequest request) throws LogicException {
        String page= JSPPageName.MAIN_PAGE;
        String keyword = request.getParameter(RequestParameterName.KEYWORD);
        ResourceBundle resourceBundle = ResourceBundle.getBundle(RequestParameterName.LOCALE);
        Appliances appliances = Appliances.getInstance();
        try{

            Map <Integer,Clazz> clazzMap = clazzDao.getAllMap();
            Keyword keywordObject = keywordDao.getByKeyword(keyword);
                if(keywordObject!=null) {
                    String classname = clazzMap.get(keywordObject.getBindedClass()).getClassName();
                    String toogle = null;
                    if(appliances.getElement(classname).equals(OFF)){
                        appliances.setElement(classname,ON);
                        toogle = ON;
                    }else if(appliances.getElement(classname).equals(ON)){
                        appliances.setElement(classname,OFF);
                        toogle = OFF;
                    }
                    request.getSession().setAttribute(RequestParameterName.MESSAGE, classname+message+toogle);
                }
                else{
                    request.getSession().setAttribute(RequestParameterName.MESSAGE,resourceBundle.getString("locale.message.Message1"));
                }

            request.getSession().setAttribute(RequestParameterName.LIST,"");
        }catch (DAOException e){
            throw new LogicException("problem with dao",e);
        }
        return page;
    }
}

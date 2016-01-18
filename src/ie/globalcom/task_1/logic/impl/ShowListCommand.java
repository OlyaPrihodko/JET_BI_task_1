package ie.globalcom.task_1.logic.impl;

import ie.globalcom.task_1.controller.JSPPageName;
import ie.globalcom.task_1.controller.RequestParameterName;
import ie.globalcom.task_1.dao.entity.KeywordDAO;
import ie.globalcom.task_1.dao.factory.DAOFactory;
import ie.globalcom.task_1.entity.Appliances;
import ie.globalcom.task_1.entity.Keyword;
import ie.globalcom.task_1.exception.DAOException;
import ie.globalcom.task_1.exception.LogicException;
import ie.globalcom.task_1.logic.ICommand;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class ShowListCommand implements ICommand {

    private static DAOFactory MySQLDaoFactory = DAOFactory.getDAOFactory(DAOFactory.DataSourceName.MYSQL);
    private static KeywordDAO keywordDao = MySQLDaoFactory.getKeywordDAO();
    @Override
    public String execute(HttpServletRequest request) throws LogicException {
        String page= JSPPageName.MAIN_PAGE;
        Appliances appliances = Appliances.getInstance();
        try{
            Map<Integer,Keyword> keywordHashMap = keywordDao.getAllMap();
            request.getSession().setAttribute(RequestParameterName.LIST,keywordHashMap);
            request.getSession().setAttribute(RequestParameterName.MESSAGE, "");

        }catch (DAOException e){
            throw new LogicException("problem with dao",e);
        }
        return page;
    }
}

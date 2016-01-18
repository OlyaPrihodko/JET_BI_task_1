package ie.globalcom.task_1.logic.impl;


import ie.globalcom.task_1.controller.CommandName;
import ie.globalcom.task_1.controller.JSPPageName;
import ie.globalcom.task_1.controller.RequestParameterName;
import ie.globalcom.task_1.exception.LogicException;
import ie.globalcom.task_1.logic.ICommand;

import javax.servlet.http.HttpServletRequest;
/**
 * GoToPageCommand returns the right page and executes the necessary operations if necessary
 * */
public class GoToPageCommand implements ICommand {
   /*private static DAOFactory MySQLDaoFactory = DAOFactory.getDAOFactory(DAOFactory.DataSourceName.MYSQL);
    private static OrderDao orderDao = MySQLDaoFactory.getOrderDao();
    private static ApartmentDao apartmentDao = MySQLDaoFactory.getApartmentDao();*/
    @Override
    public String execute(HttpServletRequest request) throws LogicException {
        CommandName commandName = CommandName.valueOf(request.getParameter(RequestParameterName.COMMAND_NAME).toUpperCase().replace("-","_"));
        switch (commandName){
            case PREVIOUS_PAGE:
                String str = (String)request.getSession().getAttribute(RequestParameterName.PREVIOUS_PAGE);
                if(str.equals(JSPPageName.MAIN_PAGE)){
                    return JSPPageName.MAIN_PAGE;
                }
        }
        return null;
    }
}

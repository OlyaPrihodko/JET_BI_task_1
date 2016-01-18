package ie.globalcom.task_1.controller;

import ie.globalcom.task_1.exception.ControllerException;
import ie.globalcom.task_1.exception.LogicException;
import ie.globalcom.task_1.logic.ICommand;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {
   private static final Logger log = Logger.getLogger(Controller.class);
   private final static CommandHelper commandHelper = new CommandHelper();

    @Override
    public void init(ServletConfig conf)throws ServletException {
        super.init(conf);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{processRequest(request, response);}
        catch (ControllerException e){
            log.error("something is seriously wrong",e);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(JSPPageName.ERROR_PAGE);
            dispatcher.forward(request,response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try{
            processRequest(request, response);
       }
        catch (ControllerException e){
            log.error("something is seriously wrong",e);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(JSPPageName.ERROR_PAGE);
            dispatcher.forward(request,response);
        }
    }
    private void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ControllerException{
        //ТУТ НАДО СОЗДАВАТЬ ОБЪЕКТ. ВЫТАСКИВАЯ ИЗ БД ВСЕ ДАННЫЕ

        String page=null;
        ICommand iCommand = commandHelper.defineCommand(request);
        try{
            page = iCommand.execute(request);
        }
        catch (LogicException e){
            throw new ControllerException("Logic exception in execute method",e);
        }
        if(page!=null){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request,response);
        }
        else{
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(JSPPageName.INDEX_PAGE);
            dispatcher.forward(request,response);
        }
    }
}

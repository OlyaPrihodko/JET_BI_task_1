package ie.globalcom.task_1.logic;

import ie.globalcom.task_1.exception.LogicException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Оля on 17.01.16.
 */
public interface ICommand {
    /**
     * There is a method for each Command that can be created.
     * */
    public String execute(HttpServletRequest request) throws LogicException;
}

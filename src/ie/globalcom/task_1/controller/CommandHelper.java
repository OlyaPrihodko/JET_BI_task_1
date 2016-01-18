package ie.globalcom.task_1.controller;

import ie.globalcom.task_1.logic.ICommand;
import ie.globalcom.task_1.logic.impl.GoToPageCommand;
import ie.globalcom.task_1.logic.impl.ShowListCommand;
import ie.globalcom.task_1.logic.impl.SubmitCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandHelper {
    private Map<CommandName,ICommand> mapCommand = new HashMap<CommandName,ICommand>();

    public CommandHelper(){
        mapCommand.put(CommandName.SUBMIT,new SubmitCommand());
        mapCommand.put(CommandName.PREVIOUS_PAGE,new GoToPageCommand());
        mapCommand.put(CommandName.SHOW_LIST,new ShowListCommand());
    }
    public ICommand defineCommand(HttpServletRequest request) {
        String nameCommand = request.getParameter(RequestParameterName.COMMAND_NAME).toUpperCase().replace("-","_");
        CommandName commandName = CommandName.valueOf(nameCommand);
        ICommand iCommand = null;
        switch (commandName){
            case SUBMIT:
                iCommand = mapCommand.get(CommandName.SUBMIT);
                break;
            case PREVIOUS_PAGE:
                iCommand = mapCommand.get(CommandName.PREVIOUS_PAGE);
                break;
            case SHOW_LIST:
                iCommand = mapCommand.get(CommandName.SHOW_LIST);
                break;
        }
        return iCommand;
    }
}

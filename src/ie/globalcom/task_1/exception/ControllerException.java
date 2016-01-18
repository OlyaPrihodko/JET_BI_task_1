package ie.globalcom.task_1.exception;

/**
 * Created by Оля on 17.01.16.
 */
public class ControllerException extends Exception {
    private static final long serialVersionUID = 1L;
    private Exception hiddenException;

    public ControllerException(String msg){
        super(msg);
    }
    public ControllerException(String msg, Exception e){
        super(msg);
        hiddenException = e;
    }
    public Exception getHiddenException(){
        return hiddenException;
    }
}

package ie.globalcom.task_1.exception;

public class ConnectionPoolException extends Exception {
    private static final long serialVersionUID = 1L;
    private Exception hiddenException;

    public ConnectionPoolException(String msg){
        super(msg);
    }
    public ConnectionPoolException(String msg, Exception e){
        super(msg);
        hiddenException = e;
    }
    public Exception getHiddenException(){
        return hiddenException;
    }
}

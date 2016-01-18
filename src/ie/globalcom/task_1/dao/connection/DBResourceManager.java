package ie.globalcom.task_1.dao.connection;

import java.util.ResourceBundle;

public class DBResourceManager {
    private final static DBResourceManager instance = new DBResourceManager();
    private final static String resourcesDB = "ie.globalcom.task_1/resources/database";
    private final static ResourceBundle bundle = ResourceBundle.getBundle(resourcesDB);
    public static DBResourceManager getInstance() {
        return instance;
    }
    public String getValue(String key){
        return bundle.getString(key);
    }

}

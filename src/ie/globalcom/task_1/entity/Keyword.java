package ie.globalcom.task_1.entity;

public class Keyword {
    private int id;
    private String keyword;
    private int bindedClass;

    public Keyword() {}
    public Keyword(int id, String keyword, int bindedClass) {
        this.id=id;
        this.keyword=keyword;
        this.bindedClass=bindedClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getBindedClass() {
        return bindedClass;
    }

    public void setBindedClass(int bindedClass) {
        this.bindedClass = bindedClass;
    }
}

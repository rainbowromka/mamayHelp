package http.mamay.help.mamayHelp.dataBase.entities;

public class Category {
    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Category(String name, String url) {
        this.name = name;
        this.url = url;
    }
}

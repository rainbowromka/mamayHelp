package http.mamay.help.mamayHelp.dataBase.entities;

import java.util.Date;

public class Tweet {
    private String created;
    private String messages;

    public Tweet(String created, String messages) {
        this.created = created;
        this.messages = messages;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }
}

package http.mamay.help.mamayHelp.dataBase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    Date dateWriten;
    String textBlog;
    int user_id; // ссылаемся на пользователя

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateWriten() {
        return dateWriten;
    }

    public void setDateWriten(Date dateWriten) {
        this.dateWriten = dateWriten;
    }

    public String getTextBlog() {
        return textBlog;
    }

    public void setTextBlog(String textBlog) {
        this.textBlog = textBlog;
    }

//    public int getIdUser() {
//        return idUser;
//    }
//
//    public void setIdUser(int idUser) {
//        this.idUser = idUser;
//    }
}

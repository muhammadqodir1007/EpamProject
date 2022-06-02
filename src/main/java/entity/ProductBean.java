package entity;

import java.io.InputStream;
import java.sql.Date;

public class ProductBean {

    int id;
    String name,title,description;
    Date createdDate;
    byte [] photo;

    public ProductBean() {
        super();
    }

    public ProductBean(String name, String title, String description, Date createdDate, byte[] photo) {
        this.name = name;
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
        this.photo = photo;
    }

    public ProductBean(int id, String name, String title, String description, Date createdDate, byte [] photo) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public byte [] getPhoto() {
        return photo;
    }

    public void setPhoto(byte [] photo) {
        this.photo = photo;
    }
}

package entity;

import java.io.InputStream;
import java.sql.Date;

public class ProductBean {


    int id,categoryId;

    byte[] photoFile;
    String titles, description, sourceLinkTo, text;
    Date createdTime;

    public ProductBean(int id, int categoryId, byte[] photoFile, String titles, String description, String sourceLinkTo, String text, Date createdTime) {
        this.id = id;
        this.categoryId = categoryId;
        this.photoFile = photoFile;
        this.titles = titles;
        this.description = description;
        this.sourceLinkTo = sourceLinkTo;
        this.text = text;
        this.createdTime = createdTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public byte[] getPhotoFile() {
        return photoFile;
    }

    public void setPhotoFile(byte[] photoFile) {
        this.photoFile = photoFile;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSourceLinkTo() {
        return sourceLinkTo;
    }

    public void setSourceLinkTo(String sourceLinkTo) {
        this.sourceLinkTo = sourceLinkTo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public ProductBean() {
    }

    public ProductBean(int categoryId, byte[] photoFile, String titles, String description, String sourceLinkTo, String text, Date createdTime) {
        this.categoryId = categoryId;
        this.photoFile = photoFile;
        this.titles = titles;
        this.description = description;
        this.sourceLinkTo = sourceLinkTo;
        this.text = text;
        this.createdTime = createdTime;
    }
}
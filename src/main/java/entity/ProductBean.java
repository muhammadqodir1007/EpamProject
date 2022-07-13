package entity;

import java.sql.Date;

public class ProductBean {


   private int id, category_Id;

   private byte[] photoFile;
 private    String titles, description, sourceLinkTo, text;
 private    Date created_at ;
    private Date updated_at;
    private int category_id;



    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }





    public ProductBean(int id, int categoryId, byte[] photoFile, String titles, String description, String sourceLinkTo, String text, Date created_at, Date updated_at, int category_id) {
        this.id = id;
        this.category_Id = categoryId;
        this.photoFile = photoFile;
        this.titles = titles;
        this.description = description;
        this.sourceLinkTo = sourceLinkTo;
        this.text = text;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.category_id = category_id;
    }

    public ProductBean(int id, int categoryId, byte[] photoFile, String titles, String description, String sourceLinkTo, String text, Date createdTime) {
        this.id = id;
        this.category_Id = categoryId;
        this.photoFile = photoFile;
        this.titles = titles;
        this.description = description;
        this.sourceLinkTo = sourceLinkTo;
        this.text = text;
        this.created_at = createdTime;
    }

    public ProductBean(Long id, String titles, String description, String sourcelinkTo, byte[] photofile, java.util.Date created_at, java.util.Date updated_at) {


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_Id() {
        return category_Id;
    }

    public void setCategory_Id(int category_Id) {
        this.category_Id = category_Id;
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
        return created_at;
    }

    public void setCreatedTime(Date createdTime) {
        this.created_at = createdTime;
    }

    public ProductBean() {
    }

    public ProductBean(int categoryId, byte[] photoFile, String titles, String description, String sourceLinkTo, String text, Date createdTime) {
        this.category_Id = categoryId;
        this.photoFile = photoFile;
        this.titles = titles;
        this.description = description;
        this.sourceLinkTo = sourceLinkTo;
        this.text = text;
        this.created_at = createdTime;
    }
}
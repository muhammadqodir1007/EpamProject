package entity;


import javax.xml.crypto.Data;

public class Product {
    private Long id;
    private String title;
    private Data dataCreated;
    private String description;
    private String photoOfNews;

    public Product() {
    }

    public Product(Long id, String title, Data dataCreated, String description, String photoOfNews) {
        this.id = id;
        this.title = title;
        this.dataCreated = dataCreated;
        this.description = description;
        this.photoOfNews = photoOfNews;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Data getDataCreated() {
        return dataCreated;
    }

    public void setDataCreated(Data dataCreated) {
        this.dataCreated = dataCreated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoOfNews() {
        return photoOfNews;
    }

    public void setPhotoOfNews(String photoOfNews) {
        this.photoOfNews = photoOfNews;
    }
}

package entity;

import java.sql.Date;

public class TaskBean {



    int id;
    String work;
    Date createdDate;

    public TaskBean(String work, Date createdDate) {
        this.work = work;
        this.createdDate = createdDate;
    }

    public TaskBean() {
    }

    public TaskBean(int id, String work, Date createdDate) {
        this.id = id;
        this.work = work;
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}

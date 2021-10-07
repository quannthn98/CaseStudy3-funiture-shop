package model;

import java.util.Date;

public class News {
    private int id ;
    private String title;
    private String subtitle;
    private Date createdDate;
    private String description;
    private boolean status;
    private int id_Customer;

    public News() {
    }

    public News(int id, String title, String subtitle, Date createdDate, String description, boolean status, int id_Customer) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.createdDate = createdDate;
        this.description = description;
        this.status = status;
        this.id_Customer = id_Customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId_Customer() {
        return id_Customer;
    }

    public void setId_Customer(int id_Customer) {
        this.id_Customer = id_Customer;
    }
}

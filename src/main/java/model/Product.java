package model;

public class Product {
    private int id;
    private String name;
    private String image;
    private String subImage;
    private float price;
    private int priceSell;
    private String subDescription;
    private String Description;
    private String createdDate;
    private int status;

    public Product() {
    }

    public Product(int id, String name, float price, int priceSell) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.priceSell = priceSell;
    }

    public Product(int id, String name, String image, String subImage, float price, int priceSell, String subDescription, String description, String createdDate, int status) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.subImage = subImage;
        this.price = price;
        this.priceSell = priceSell;
        this.subDescription = subDescription;
        Description = description;
        this.createdDate = createdDate;
        this.status = status;
    }

    public Product(String name, String image, String subImage, float price, int priceSell, String subDescription, String description, String createdDate, int status) {
        this.name = name;
        this.image = image;
        this.subImage = subImage;
        this.price = price;
        this.priceSell = priceSell;
        this.subDescription = subDescription;
        Description = description;
        this.createdDate = createdDate;
        this.status = status;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSubImage() {
        return subImage;
    }

    public void setSubImage(String subImage) {
        this.subImage = subImage;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getPriceSell() {
        return priceSell;
    }

    public void setPriceSell(int priceSell) {
        this.priceSell = priceSell;
    }

    public String getSubDescription() {
        return subDescription;
    }

    public void setSubDescription(String subDescription) {
        this.subDescription = subDescription;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
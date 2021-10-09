package model;

public class Cart {
    private int id;
    private int customerId;
    private int productId;
    private int quantity;
    private String image;
    private String productName;
    private double productPrice;
    private double saleOff;

    public Cart(int id, int customerId, int productId, int quantity, String image, String productName) {
        this.id = id;
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
        this.image = image;
        this.productName = productName;
    }

    public Cart(int customerId, int productId, int quantity) {
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getSaleOff() {
        return saleOff;
    }

    public void setSaleOff(double saleOff) {
        this.saleOff = saleOff;
    }

    public Cart(int id, int customerId, int productId, int quantity, String image, String productName, double productPrice, double saleOff) {
        this.id = id;
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
        this.image = image;
        this.productName = productName;
        this.productPrice = productPrice;
        this.saleOff = saleOff;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

package model;

import java.util.HashMap;

public class Order {
    private HashMap<Product, Integer> productList = new HashMap<>();
    private int id;
    private int customerId;
    private String productName;
    private float price;
    private int saleOff;
    private double totalPayment;
    private boolean status;
    private String createDate;
    private String addressOrder;
    private String phone;
    private String note;

    public Order(HashMap<Product, Integer> productList, int id, int customerId, String productName, float price, int saleOff, double totalPayment, boolean status, String createDate, String addressOrder, String phone, String note) {
        this.productList = productList;
        this.id = id;
        this.customerId = customerId;
        this.productName = productName;
        this.price = price;
        this.saleOff = saleOff;
        this.totalPayment = totalPayment;
        this.status = status;
        this.createDate = createDate;
        this.addressOrder = addressOrder;
        this.phone = phone;
        this.note = note;
    }

    public Order(int id, String productName, float price, int saleOff, boolean status, String createDate, String addressOrder, String phone, String note, int customerId) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.saleOff = saleOff;
        this.status = status;
        this.createDate = createDate;
        this.addressOrder = addressOrder;
        this.phone = phone;
        this.note = note;
        this.customerId = customerId;
    }

    public HashMap<Product, Integer> getProductList() {
        return productList;
    }

    public void setProductList(HashMap<Product, Integer> productList) {
        this.productList = productList;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getSaleOff() {
        return saleOff;
    }

    public void setSaleOff(int saleOff) {
        this.saleOff = saleOff;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getAddressOrder() {
        return addressOrder;
    }

    public void setAddressOrder(String addressOrder) {
        this.addressOrder = addressOrder;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

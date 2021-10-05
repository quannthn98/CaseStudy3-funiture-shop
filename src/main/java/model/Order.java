package model;

import java.util.HashMap;

public class Order {
    private int id;
    private int customerId;
    private String createdDate;
    private boolean status;
    private String consignee;
    private String addressOrder;
    private String phone;
    private String note;

    public Order(int id, int customerId, String createdDate, boolean status, String consignee, String addressOrder, String phone, String note) {
        this.id = id;
        this.customerId = customerId;
        this.createdDate = createdDate;
        this.status = status;
        this.consignee = consignee;
        this.addressOrder = addressOrder;
        this.phone = phone;
        this.note = note;
    }

    public Order(int customerId, String consignee, String addressOrder, String phone, String note) {
        this.customerId = customerId;
        this.consignee = consignee;
        this.addressOrder = addressOrder;
        this.phone = phone;
        this.note = note;
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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
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

package model;

public class Company {
    private int id;
    private String name;
    private String address;
    private String hotline;
    private String note;
    private boolean status;

    public Company() {
    }

    public Company(String name, String address, String hotline, String note, boolean status) {
        this.name = name;
        this.address = address;
        this.hotline = hotline;
        this.note = note;
        this.status = status;
    }

    public Company(int id, String name, String address, String hotline, String note, boolean status) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.hotline = hotline;
        this.note = note;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHotline() {
        return hotline;
    }

    public void setHotline(String hotline) {
        this.hotline = hotline;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

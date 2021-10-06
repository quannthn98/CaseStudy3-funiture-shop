package model;

public class Brand {
    private int id;
    private String name;
    private int Status;

    public Brand() {
    }

    public Brand(String name, int status) {
        this.name = name;
        Status = status;
    }

    public Brand(int id, String name, int status) {
        this.id = id;
        this.name = name;
        Status = status;
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

    public int isStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}

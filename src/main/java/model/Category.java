package model;

public class Category {
    private int id;
    private String name;
    private int location;
    private int status;

    public Category() {
    }

    public Category(int id, String name, int location, int status) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.status = status;
    }

    public Category(String name, int location, int status) {
        this.name = name;
        this.location = location;
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

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

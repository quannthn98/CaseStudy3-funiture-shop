package model;

public class Banner {
    private int id ;
    private String name;
    private String image;
    private int location;
    private boolean status;

    public Banner() {
    }
    public Banner(String name, String image, int location, boolean status) {
        this.name = name;
        this.image = image;
        this.location = location;
        this.status = status;
    }
    public Banner(int id, String name, String image, int location, boolean status) {
        this.id = id;
        this.name = name;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

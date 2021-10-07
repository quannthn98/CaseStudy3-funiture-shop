package model;

public class Settings {
    private int id ;
    private String title;
    private String logo;
    private String hotline;
    private String address;
    private String linkMap;
    private String email;
    private String pageFacebook;
    private String logo_payment;
    private String note;

    public Settings() {
    }

    public Settings(String title, String logo, String hotline, String address, String linkMap, String email, String pageFacebook, String logo_payment, String note) {
        this.title = title;
        this.logo = logo;
        this.hotline = hotline;
        this.address = address;
        this.linkMap = linkMap;
        this.email = email;
        this.pageFacebook = pageFacebook;
        this.logo_payment = logo_payment;
        this.note = note;
    }

    public Settings(int id, String title, String logo, String hotline, String address, String linkMap, String email, String pageFacebook, String logo_Payment, String note) {
        this.id = id;
        this.title = title;
        this.logo = logo;
        this.hotline = hotline;
        this.address = address;
        this.linkMap = linkMap;
        this.email = email;
        this.pageFacebook = pageFacebook;
        this.logo_payment = logo_Payment;
        this.note = note;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getHotline() {
        return hotline;
    }

    public void setHotline(String hotline) {
        this.hotline = hotline;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLinkMap() {
        return linkMap;
    }

    public void setLinkMap(String linkMap) {
        this.linkMap = linkMap;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPageFacebook() {
        return pageFacebook;
    }

    public void setPageFacebook(String pageFacebook) {
        this.pageFacebook = pageFacebook;
    }

    public String getLogo_payment() {
        return logo_payment;
    }

    public void setLogo_payment(String logo_payment) {
        this.logo_payment = logo_payment;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

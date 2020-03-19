package model;

public class Model {
    private Long id;
    private String firstname;
    private String lastname;
    private String address;
    private String mobilphone;
    private String homephone;
    private String date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobilphone() {
        return mobilphone;
    }

    public void setMobilphone(String mobilphone) {
        this.mobilphone = mobilphone;
    }

    public String getHomephone() {
        return homephone;
    }

    public void setHomephone(String homephone) {
        this.homephone = homephone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", mobilphone='" + mobilphone + '\'' +
                ", homephone='" + homephone + '\'' +
                ", date='" + date + '\'' +
                ", address='" + address +'\'' +
                '}';
    }


}

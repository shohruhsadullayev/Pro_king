package entity;


import javax.persistence.*;

@Entity
@Table(name = "students")
public class StudentEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column
        private String firstname;

        @Column
        private String lastname;

        @Column
        private String mobilphone;

        @Column
        private String homephone;

        @Column
        private String date;

        @Column
        private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "StudentEntity{" +
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

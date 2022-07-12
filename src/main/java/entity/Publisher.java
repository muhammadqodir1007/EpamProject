package entity;

import java.util.Date;
import java.util.Objects;

public class Publisher {
    private long id;
    private String nameOf;
    private String address;
    private String phoneNumber;
    private String email;
    private String password;
    private String description;
    private Date created_At;
    private Date updated_At;

    public Publisher(String nameOf,
                     String address,
                     String phoneNumber,
                     String email,
                     String password,
                     String description) {
        this.nameOf = nameOf;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.description = description;
    }

    public Publisher(long id, String nameOf,
                     String address, String phoneNumber,
                     String email, String password, String description) {
        this.id = id;
        this.nameOf = nameOf;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.description = description;
    }

    public Publisher(long id, String nameOf, String address,
                     String phoneNumber,
                     String email, String password,
                     String description, Date created_At,
                     Date updated_At) {
        this.id = id;
        this.nameOf = nameOf;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.description = description;
        this.created_At = created_At;
        this.updated_At = updated_At;
    }

    public Publisher() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameOf() {
        return nameOf;
    }

    public void setNameOf(String nameOf) {
        this.nameOf = nameOf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    public Date getUpdated_At() {
        return updated_At;
    }

    public void setUpdated_At(Date updated_At) {
        this.updated_At = updated_At;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", nameOf='" + nameOf + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", description='" + description + '\'' +
                ", created_At=" + created_At +
                ", updated_At=" + updated_At +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publisher)) return false;
        Publisher publisher = (Publisher) o;
        return nameOf.equals(publisher.nameOf) &&
                address.equals(publisher.address) &&
                phoneNumber.equals(publisher.phoneNumber) &&
                email.equals(publisher.email) &&
                password.equals(publisher.password) &&
                description.equals(publisher.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOf, address, phoneNumber, email, password, description);
    }
}

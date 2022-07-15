package entity;


import java.sql.Date;

public class Publisher {


    Long id;
    String nameOfCompany, address, phoneNumber, email, password, username, description;
    Date created_at, updated_at;
    boolean isActive, isBlocked;


    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Publisher(Long id, String nameOfCompany, String address, String phoneNumber, String email, String password, String username, String description, Date created_at, Date updated_at, boolean isActive) {
        this.id = id;
        this.nameOfCompany = nameOfCompany;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.username = username;
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.isActive = isActive;
    }

    public Publisher(Long id, String nameOfCompany, String address, String phoneNumber, String email, String password, Date created_at, Date updated_at) {
        this.id = id;
        this.nameOfCompany = nameOfCompany;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfCompany() {
        return nameOfCompany;
    }

    public void setNameOfCompany(String nameOfCompany) {
        this.nameOfCompany = nameOfCompany;
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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }


    public Publisher(String nameOfCompany, String address, String phoneNumber, String email, String password, String username, String description, boolean isBlocked) {
        this.nameOfCompany = nameOfCompany;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.username = username;
        this.description = description;
        this.isBlocked = isBlocked;

    }

    public Publisher(Long id, String nameOfCompany, String address, String phoneNumber, String email, String password, String username, boolean isBlocked) {

        this.id = id;
        this.nameOfCompany = nameOfCompany;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.username = username;
        this.isBlocked = isBlocked;


    }


    public Publisher() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Publisher(Long id, String nameOfCompany, String address, String phoneNumber, String email, String password, String username, String description, Date created_at, Date updated_at) {
        this.id = id;
        this.nameOfCompany = nameOfCompany;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.username = username;
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}

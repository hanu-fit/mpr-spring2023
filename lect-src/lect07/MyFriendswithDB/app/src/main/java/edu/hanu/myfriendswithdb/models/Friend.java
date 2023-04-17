package edu.hanu.myfriendswithdb.models;

public class Friend {
    private long id;
    private String name;
    private String phoneNo;
    private String email;

    // from db record
    public Friend(long id, String name, String phoneNo, String email) {
        this.id = id;
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    // from form data
    public Friend(String name, String phoneNo, String email) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "name='" + name + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

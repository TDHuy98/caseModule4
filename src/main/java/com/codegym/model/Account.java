package com.codegym.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountID;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String mobile;
    private Date registeredAt;
    private Date lastLogin;
    @Column(name="isAdmin", columnDefinition = "INT DEFAULT 0")
    private int isAdmin;

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(Date registeredAt) {
        this.registeredAt = registeredAt;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Account() {
    }

    public Account(int accountID, String username, String password, String firstname, String lastname, String mobile, Date registeredAt, Date lastLogin, int isAdmin) {
        this.accountID = accountID;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mobile = mobile;
        this.registeredAt = registeredAt;
        this.lastLogin = lastLogin;
        this.isAdmin = isAdmin;
    }

}
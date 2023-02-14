package com.codegym.casemodule4.entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Account implements Serializable {
    public static final String ROLE_USER = "USER";
    public static final String ROLE_ADMIN = "ADMIN";
    private static final long serialVersionUID = -2054386655979281969L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    @Basic
    @Column(name = "user_name", length = 20, nullable = false)
    private String userName;
    @Basic
    @Column(name = "encryted_password", length = 128, nullable = false)
    private String encrytedPassword;
    @Basic
    @Column(name = "active", length = 1, nullable = false)
    private boolean active;
    @Basic
    @Column(name = "user_role", length = 20, nullable = false)
    private String userRole;
    @OneToMany(mappedBy = "accountByUserId")
    private List<Bill> billsById;


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", encrytedPassword='" + encrytedPassword + '\'' +
                ", active=" + active +
                ", userRole='" + userRole + '\'' +
                '}';
    }

}

package com.codegym.casemodule4.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Data
@Setter @Getter
@NoArgsConstructor
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "firstName")
    private String firstName;
    @Basic
    @Column(name = "lastName")
    private String lastName;
    @Basic
    @Column(name = "mobile")
    private String mobile;
    @Basic
    @Column(name = "admin")
    private byte admin;
    @Basic
    @Column(name = "registeredAt")
    private Timestamp registeredAt;
    @Basic
    @Column(name = "lastLogin")
    private Timestamp lastLogin;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && admin == user.admin && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(mobile, user.mobile) && Objects.equals(registeredAt, user.registeredAt) && Objects.equals(lastLogin, user.lastLogin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, firstName, lastName, mobile, admin, registeredAt, lastLogin);
    }
}

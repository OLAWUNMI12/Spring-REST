package com.app.rest.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class User implements Serializable {
    static final long serialVersionUID = 42L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name", nullable = false, length = 20)
    private String name;

    @Column(name = "Email", nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "User_Id", nullable = false, length = 20, unique = true)
    private String userId;

    @Column(name = "Token", nullable = false, length = 30)
    private String token;

    @Column(name = "Password", nullable = false, length = 70)
    private String password;

    @Column(name = "Encrypted_Password", nullable = false, length = 70)
    private String encryptedPassword;

    @Column(name = "Status", nullable = false, length = 20)
    private String status;

    @Column(name = "Activated", nullable = false)
    private boolean activated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }
}

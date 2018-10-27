package com.netcracker.backend.entity;

import javax.persistence.*;

@Entity
@Table(name= "accounts" )
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    private String password;
    private long roleId;

    public Account(long id, String login, String password,long roleId) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.roleId = roleId;
    }

    public Account() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {

        return "Account : " +
               "id = " +this.id +
                "login = " + this.login +
                " password = " + this.password +
                " role_id = " + this.roleId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
}

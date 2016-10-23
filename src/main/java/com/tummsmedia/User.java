package com.tummsmedia;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by john.tumminelli on 10/23/16.
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    Integer id;

    @Column(nullable =  false)
    String name;

    @Column(nullable = false)
    String password;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

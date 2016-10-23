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

    ArrayList<Message> messages = new ArrayList<>();
}

package com.tummsmedia;

import javax.persistence.*;

/**
 * Created by john.tumminelli on 10/23/16.
 */

@Entity
@Table(name = "messages")

public class Message {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String text;

    @ManyToOne
    User user;

    public Message() {
    }

    public Message(String text, User user) {
        this.text = text;
        this.user = user;
    }

    public Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

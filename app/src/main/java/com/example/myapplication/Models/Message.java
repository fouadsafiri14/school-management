package com.example.myapplication.Models;

import java.util.Date;

public class Message {
    private String uid_receiver;
    private String uid_sender;
    private String text;
    private Date createdAt;

    public String getUid_sender() {
        return uid_sender;
    }

    public void setUid_sender(String uid_sender) {
        this.uid_sender = uid_sender;
    }

    public Message(String uid_receiver, String uid_sender, String text, Date createdAt) {
        this.uid_receiver = uid_receiver;
        this.uid_sender = uid_sender;
        this.text = text;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "MessageBean{" +
                "uid_receiver='" + uid_receiver + '\'' +
                ", text='" + text + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public String getUid_receiver() {
        return uid_receiver;
    }

    public void setUid_receiver(String uid_receiver) {
        this.uid_receiver = uid_receiver;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

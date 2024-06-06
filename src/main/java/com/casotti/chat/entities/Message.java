package com.casotti.chat.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Message {

    private Long id;
    private String content;
    private LocalDateTime timestamp;

    @ManyToOne
    private Channel channel;

    @ManyToOne
    private User author;
}

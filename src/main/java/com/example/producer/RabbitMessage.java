package com.example.producer;

import lombok.Data;

import java.util.Date;

@Data
public class RabbitMessage {
    private String title;
    private String content;
    private Date createdate;
}

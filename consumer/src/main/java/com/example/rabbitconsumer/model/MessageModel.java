package com.example.rabbitconsumer.model;

import lombok.Data;

import java.util.UUID;

@Data
public class MessageModel {
    private UUID id;
    private String message;
    private String deliveredAt;
}

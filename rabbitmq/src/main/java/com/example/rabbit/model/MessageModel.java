package com.example.rabbit.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class MessageModel {
    private UUID id;
    private String message;
    private String deliveredAt;
}

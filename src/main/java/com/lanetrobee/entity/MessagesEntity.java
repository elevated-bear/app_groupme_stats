package com.lanetrobee.entity;

import lombok.Data;

@Data
public class MessagesEntity {
    private Double count;
    private String last_message_id;
    private String last_message_created_at;
    private PreviewEntity preview;
}

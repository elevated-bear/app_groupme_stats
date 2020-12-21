package com.lanetrobee.entity.message;

import com.lanetrobee.entity.group.AttachmentEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class MessageEntity {
    @Id
    private Integer id;
    private List<AttachmentEntity> attachments;
    private String avatar_url;
    private Integer created_at;
    private List<String> favorited_by;
    private String group_id;
    private String name;
    private String sender_id;
    private String sender_type;
    private String source_guid;
    private Boolean system;
    private String text;
    private String user_id;
    private String platform;
}

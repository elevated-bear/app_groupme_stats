package com.lanetrobee.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "groups")
public class GroupEntity {
    @Id
    private Integer id;
    private String group_id;
    private String name;
    private String phone_number;
    private String type;
    private String description;
    private String image_url;
    private String creator_user_id;
    private String created_at;
    private String updated_at;
    private String muted_until;
    private String office_mode;
    private String share_url;
    private String share_qr_code_url;
    private List<MemberEntity> members;
    private MessagesEntity messages;
    private String max_members;
    private String theme_name;
    private LikeIconEntity like_icon;
}

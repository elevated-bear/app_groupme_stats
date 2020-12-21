package com.lanetrobee.entity.group;

import lombok.Data;

import java.util.List;

@Data
public class MemberEntity {
    private String user_id;
    private String nickname;
    private String image_url;
    private String id;
    private Boolean muted;
    private Boolean autokicked;
    private List<String> roles;
    private String name;
}

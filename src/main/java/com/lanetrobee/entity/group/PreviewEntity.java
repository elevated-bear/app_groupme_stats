package com.lanetrobee.entity.group;

import lombok.Data;

import java.util.List;

@Data
public class PreviewEntity {
    private String nickname;
    private String text;
    private String image_url;
    private List<AttachmentEntity> attachments;

}

package com.lanetrobee.entity;

import lombok.Data;

import java.util.List;

@Data
public class GroupMeResponseEntity<T> {
    private List<T> response;
    private Object meta;
}

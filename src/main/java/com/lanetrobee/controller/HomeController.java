package com.lanetrobee.controller;

import com.lanetrobee.entity.GroupEntity;
import com.lanetrobee.service.GroupMeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class HomeController {

    @Autowired
    private GroupMeService gms;

    @GetMapping ("/help")
    public List<String> getgroups() {
        List<GroupEntity> gm = gms.getListOfGroups();
        return gm.stream()
                .map(GroupEntity::getName)
                .collect(Collectors.toList());
    }
}

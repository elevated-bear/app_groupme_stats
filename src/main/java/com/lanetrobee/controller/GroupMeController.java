package com.lanetrobee.controller;

import com.lanetrobee.entity.GroupEntity;
import com.lanetrobee.repository.GroupRepository;
import com.lanetrobee.service.GroupMeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/gm")
public class GroupMeController {

    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private GroupMeService groupMeService;

    @GetMapping(value = "/groups")
    public List<GroupEntity> getGroups() {
        return groupRepository.findAll();
    }

    @PostMapping(value = "/groups")
    public void updateGroupData() {
        List<GroupEntity> result = groupMeService.getListOfGroups();
        for (GroupEntity e : result) {
            groupRepository.save(e);
        }
    }
}

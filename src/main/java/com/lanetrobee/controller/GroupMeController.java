package com.lanetrobee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController(value = "/gm")
public class GroupMeController {

    @GetMapping(value = "/groups")
    public List<String> getGroups() {
        //TODO fetch groups on profile
        return new ArrayList<>();
    }

    @PostMapping(value = "/load")
    public void loadGroupData(@PathVariable String groupId) {
        //TODO perform a load of group data
        //TODO allow for some kind of progression indicator
    }
}

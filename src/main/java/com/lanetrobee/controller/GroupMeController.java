package com.lanetrobee.controller;

import com.lanetrobee.entity.group.GroupEntity;
import com.lanetrobee.entity.message.MessageEntity;
import com.lanetrobee.repository.GroupRepository;
import com.lanetrobee.service.GroupMeService;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/gm")
public class GroupMeController {

    @Autowired
    private MongoClient mongoClient;
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

    @DeleteMapping(value = "/groups")
    public void removeGroups() {
        groupRepository.deleteAll();
    }

    @PostMapping(value = "/messages")
    public void updateMessages(@RequestParam Integer groupId) {
        String groupMsgCollection = "messages_group_" + groupId;
        MongoDatabase db = mongoClient.getDatabase("groupme");
        MongoCollection<Document> collection = db.getCollection(groupMsgCollection);
        collection.insertOne(new Document());
    }

    @DeleteMapping(value = "/messages")
    public void deleteMessages(@RequestParam Integer groupId) {
        log.debug("Dropping message collection for group: {}", groupId);
        MongoDatabase db = mongoClient.getDatabase("groupme");
        db.getCollection("messages_group_" + groupId).drop();
    }
}

package com.lanetrobee.service;

import com.lanetrobee.client.GroupMeServiceClient;
import com.lanetrobee.configuration.properties.ApplicationProperties;
import com.lanetrobee.entity.GroupEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupMeService {

    GroupMeServiceClient gmServiceClient;
    ApplicationProperties appProperties;

    public GroupMeService(ApplicationProperties appProperties, GroupMeServiceClient gmServiceClient) {
        this.appProperties = appProperties;
        this.gmServiceClient = gmServiceClient;
    }

    public List<GroupEntity> getListOfGroups() {
        return gmServiceClient.getGroups(appProperties.getGetGroupsEndpoint()).getResponse();
    }
}

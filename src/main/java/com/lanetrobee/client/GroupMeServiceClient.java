package com.lanetrobee.client;

import com.lanetrobee.entity.GroupEntity;
import com.lanetrobee.entity.GroupMeResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class GroupMeServiceClient {

    @Autowired
    private WebClient webclient;

    @Value("${services.groupme.baseURL}")
    String baseURL;

    @Value("${GROUPME_TOKEN}")
    String gmToken;

    public GroupMeResponseEntity<GroupEntity> getGroups(String destination) {
        String url = baseURL.concat(destination);
        String authURL = addAuthToken(url);
        return webclient.get()
                .uri(authURL)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<GroupMeResponseEntity<GroupEntity>>() {})
                .block();
    }

    private String addAuthToken(String url) {
        if (url.contains("?")) {
            url = url.concat("&");
        } else {
            url = url.concat("?");
        }
        return url.concat("token=").concat(gmToken);
    }

}

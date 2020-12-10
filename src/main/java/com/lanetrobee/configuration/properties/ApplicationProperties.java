package com.lanetrobee.configuration.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class ApplicationProperties {

	@Value("${services.timeOutInMilliSecs}")
	private Integer timeOutInMilliSecs;

	@Value("${services.groupme.endpoints.getGroups}")
	private String getGroupsEndpoint;
}

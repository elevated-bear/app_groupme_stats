package com.lanetrobee.configuration;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import com.lanetrobee.configuration.properties.ApplicationProperties;

import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.AllArgsConstructor;
import reactor.netty.http.client.HttpClient;

@Configuration
@AllArgsConstructor
public class WebClientConfiguration {

	private ApplicationProperties applicationProperties;

	@Bean
	public WebClient webClient() {
		HttpClient httpClient = HttpClient.create().tcpConfiguration(tcpClient -> {
			tcpClient = tcpClient.doOnConnected(conn -> conn
					.addHandlerLast(new ReadTimeoutHandler(applicationProperties.getTimeOutInMilliSecs(),
							TimeUnit.MILLISECONDS))
					.addHandlerLast(new WriteTimeoutHandler(applicationProperties.getTimeOutInMilliSecs(),
							TimeUnit.MILLISECONDS)));
			return tcpClient;
		});
		ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);
		return WebClient.builder().clientConnector(connector).build();
	}
}

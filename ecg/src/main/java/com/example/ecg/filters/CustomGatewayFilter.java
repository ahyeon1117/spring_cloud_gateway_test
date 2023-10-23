package com.example.ecg.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomGatewayFilter
  extends AbstractGatewayFilterFactory<CustomGatewayFilter.Config> {

  public CustomGatewayFilter() {
    super(Config.class);
  }

  @Override
  public GatewayFilter apply(Config config) {
    // Custom filter logic goes here
    return (exchange, chain) -> {
      ServerHttpRequest request = exchange.getRequest();
      log.info(request.getURI().toString());

      ServerHttpResponse response = exchange.getResponse();
      log.info(response.getStatusCode().toString());

      // Perform custom logic here
      return chain.filter(exchange);
    };
  }

  public static class Config {
    // Configuration properties for your filter, if needed
  }
}
